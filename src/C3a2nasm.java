import c3a.*;
import nasm.*;
import ts.*;

public class C3a2nasm implements C3aVisitor<NasmOperand> {
    private C3a c3a;
    private Nasm nasm;
    private Ts tableGlobale;
    private TsItemFct currentFct;

    public C3a2nasm(C3a c3a, Ts table) {
        this.nasm = new Nasm(table);
        this.tableGlobale = table;
        nasm.setTempCounter(c3a.getTempCounter());
        prelude();
        c3a.listeInst.remove(0);
        for (C3aInst inst : c3a.listeInst)
            inst.accept(this);
    }

    private void prelude() {
        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);
        NasmRegister ebx = nasm.newRegister();
        ebx.colorRegister(Nasm.REG_EBX);
        nasm.setTempCounter(0);
        NasmRegister t = nasm.newRegister();
        nasm.ajouteInst(new NasmSub(null, esp, new NasmConstant(4), "allocation mémoire pour la valeur de retour"));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("main"), ""));
        nasm.ajouteInst(new NasmPop(null, t, "récupération de la valeur de retour"));
        nasm.ajouteInst(new NasmMov(null, ebx, new NasmConstant(0), " valeur de retour du programme"));
        nasm.ajouteInst(new NasmMov(null, eax, new NasmConstant(1), " code de sortie"));
        nasm.ajouteInst(new NasmInt(null, ""));
    }

    @Override
    public NasmOperand visit(C3aInstAdd inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
        nasm.ajouteInst(new NasmAdd(null, dest, op2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(Nasm.REG_EBP);
        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);

        TsItemFct fct = inst.op1.val;
        NasmOperand result = inst.result.accept(this);

        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);

        nasm.ajouteInst(new NasmSub(label, esp, new NasmConstant(4), "allocation de quatre octets dans la pile pour stocker la valeur de\n" +
                "retour"));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel(fct.identif), "appel à la fonction"));
        nasm.ajouteInst(new NasmPop(null, result, "récupération de la valeur de retour"));
        nasm.ajouteInst(new NasmAdd(null, esp, new NasmConstant(4 * fct.nbArgs), "Désallocation de l’espace occupé dans la pile par les paramètres"));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {
        NasmOperand label = new NasmLabel(inst.val.identif);
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(Nasm.REG_EBP);
        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);
        NasmRegister ebx = nasm.newRegister();
        ebx.colorRegister(Nasm.REG_EBX);
        NasmRegister ecx = nasm.newRegister();
        ecx.colorRegister(Nasm.REG_ECX);
        NasmRegister edx = nasm.newRegister();
        edx.colorRegister(Nasm.REG_EDX);
        nasm.ajouteInst(new NasmPush(label, ebp, "sauvegarde la valeur de ebp"));
        nasm.ajouteInst(new NasmMov(null, ebp, esp, "nouvelle valeur de ebp"));
        nasm.ajouteInst(new NasmPush(null, eax, "sauvegarde de eax"));
        nasm.ajouteInst(new NasmPush(null, ebx, "sauvegarde de ebx"));
        nasm.ajouteInst(new NasmPush(null, ecx, "sauvegarde de ecx"));
        nasm.ajouteInst(new NasmPush(null, edx, "sauvegarde de edx"));
        currentFct = inst.val;
        NasmConstant nbLocalVar = new NasmConstant(4 * currentFct.getTable().nbVar());
        nasm.ajouteInst(new NasmSub(null, esp, nbLocalVar, "allocation des variables locales"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {
        throw new RuntimeException();
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand to = inst.result.accept(this);

        nasm.ajouteInst(new NasmCmp(label, op1, op2, ""));
        nasm.ajouteInst(new NasmJl(null, to, ""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
        nasm.ajouteInst(new NasmMul(null, dest, op2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);

        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);

        NasmOperand result = inst.result.accept(this);

        nasm.ajouteInst(new NasmMov(label, eax, new NasmLabel("sinput"), ""));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("readline"), ""));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("atoi"), ""));
        nasm.ajouteInst(new NasmMov(null, result, eax, ""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);
        nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
        nasm.ajouteInst(new NasmSub(null, dest, op2, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmOperand result = inst.result.accept(this);
        NasmOperand value = inst.op1.accept(this);

        nasm.ajouteInst(new NasmMov(label, result, value, "Affect"));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);

        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);

        NasmOperand result = inst.result.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);

        nasm.ajouteInst(new NasmMov(label, eax, op1, ""));

        if (op2 instanceof NasmConstant) {
            NasmRegister t = nasm.newRegister();
            op2 = inst.op2.accept(this);
            nasm.ajouteInst(new NasmMov(null, t, op2, ""));
            nasm.ajouteInst(new NasmDiv(null, t, ""));
        }
        else nasm.ajouteInst(new NasmDiv(null, op2, ""));
        nasm.ajouteInst(new NasmMov(null, result, eax, ""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmConstant nbLocalVar = new NasmConstant(4 * currentFct.getTable().nbVar());
        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(Nasm.REG_EBP);
        NasmRegister esp = nasm.newRegister();
        esp.colorRegister(Nasm.REG_ESP);
        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);
        NasmRegister ebx = nasm.newRegister();
        ebx.colorRegister(Nasm.REG_EBX);
        NasmRegister ecx = nasm.newRegister();
        ecx.colorRegister(Nasm.REG_ECX);
        NasmRegister edx = nasm.newRegister();
        edx.colorRegister(Nasm.REG_EDX);

        nasm.ajouteInst(new NasmAdd(label, esp, nbLocalVar, "désallocation des variables locales"));
        nasm.ajouteInst(new NasmPop(null, edx, "restaure edx"));
        nasm.ajouteInst(new NasmPop(null, ecx, "restaure ecx"));
        nasm.ajouteInst(new NasmPop(null, ebx, "restaure ebx"));
        nasm.ajouteInst(new NasmPop(null, eax, "restaure eax"));
        nasm.ajouteInst(new NasmPop(null, ebp, "restaure la valeur de ebp"));
        nasm.ajouteInst(new NasmRet(null, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand to = inst.result.accept(this);

        nasm.ajouteInst(new NasmCmp(label, op1, op2, ""));
        nasm.ajouteInst(new NasmJe(null, to, ""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand to = inst.result.accept(this);

        nasm.ajouteInst(new NasmCmp(label, op1, op2, ""));
        nasm.ajouteInst(new NasmJne(null, to, ""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);

        NasmOperand to = inst.result.accept(this);

        nasm.ajouteInst(new NasmJmp(label, to, ""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);

        NasmOperand arguments = inst.op1.accept(this);

        nasm.ajouteInst(new NasmPush(label, arguments, ""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);

        NasmOperand source = inst.op1.accept(this);

        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(Nasm.REG_EBP);

        NasmAddress destination = new NasmAddress(ebp, '+', new NasmConstant(2));

        nasm.ajouteInst(new NasmMov(label, destination, source, "ecriture de la valeur de retour"));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        NasmLabel label = null;
        if (inst.label != null) label = (NasmLabel) inst.label.accept(this);

        NasmRegister eax = nasm.newRegister();
        eax.colorRegister(Nasm.REG_EAX);

        NasmOperand value = inst.op1.accept(this);
        //new NasmMov(label, eax, value, "");
        nasm.ajouteInst(new NasmMov(label, eax, value, "Write 1"));
        nasm.ajouteInst(new NasmCall(null, new NasmLabel("iprintLF"), "Write 2"));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstStop inst) {
        NasmLabel op = null;
        if (inst.label != null) op = (NasmLabel)inst.label.accept(this);
        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant(oper.val);
    }

    @Override
    public NasmOperand visit(C3aLabel oper) {
        return new NasmLabel(oper.toString());
    }

    @Override
    public NasmOperand visit(C3aTemp oper) {
        return new NasmRegister(oper.num);
    }

    private NasmAddress variableAddress(TsItemVar var, C3aOperand index) {
        boolean isLocal = currentFct.getTable().variables.containsKey(var.identif);
        int varIndex = var.taille;
        if (isLocal) {
            NasmRegister ebp = nasm.newRegister();
            ebp.colorRegister(Nasm.REG_EBP);
            return new NasmAddress(ebp, '-', new NasmConstant(varIndex));
        }
        if (index != null) {
            NasmOperand operIndex = index.accept(this);
            NasmRegister t = nasm.newRegister();
            NasmConstant sp = new NasmConstant(4);
            nasm.ajouteInst(new NasmMov(null, t, operIndex, ""));
            nasm.ajouteInst(new NasmMul(null, t, sp, ""));
            System.out.println(t.val + "--" +var.identif);
            return new NasmAddress(new NasmLabel(var.getIdentif()), '+', t);
        }
        return new NasmAddress(new NasmLabel(var.identif));
    }
    private NasmAddress parameterAddress(TsItemVar var) {
        int arguments = var.portee.nbArg();
        int varIndex = var.taille;

        NasmRegister ebp = nasm.newRegister();
        ebp.colorRegister(Nasm.REG_EAX);
        return new NasmAddress(ebp, '+', new NasmConstant(2 + arguments - varIndex));
    }
    @Override
    public NasmOperand visit(C3aVar oper) {
        TsItemVar var = oper.item;
        if (var.isParam)
            return parameterAddress(var);
        return variableAddress(var, oper.index);
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {
        throw new RuntimeException();
    }

    public Nasm getNasm() {
        return nasm;
    }
}
