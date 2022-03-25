import c3a.*;
import sa.*;
import sa.SaDepthFirstVisitor;
import ts.Ts;
import ts.TsItemFct;
import ts.TsItemVar;


public class Sa2c3a extends SaDepthFirstVisitor <C3aOperand>{
    private final C3a c3a;
    private final Ts tableGlobale;
    private Ts tableLocaleCourante = null;

    public Sa2c3a(SaNode root, Ts TableGlobale){
        c3a = new C3a();
        this.tableGlobale = TableGlobale;
        root.accept(this);
    }

    /*public void defaultIn(SaNode node) {
        System.out.println("<" + node.getClass().getSimpleName() + ">");
    }
    public void defaultOut(SaNode node) {
        System.out.println("</" + node.getClass().getSimpleName() + ">");

    }*/
    public C3a getC3a() {
        return c3a;
    }

    @Override
    public C3aOperand visit(SaProg node) {
        C3aTemp temp = c3a.newTemp();
        defaultIn(node);
        C3aFunction main = new C3aFunction(tableGlobale.getFct("main"));
        c3a.ajouteInst(new C3aInstCall(main, temp, ""));
        c3a.ajouteInst(new C3aInstStop(temp, ""));
        C3aOperand result = super.visit(node);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaDecFonc node) {
        TsItemFct fonction = tableGlobale.getFct(node.getNom());
        defaultIn(node);
        c3a.ajouteInst(new C3aInstFBegin(fonction, "entree fonction"));
        tableLocaleCourante = tableGlobale.getTableLocale(node.getNom());
        super.visit(node);
        tableLocaleCourante = null;
        c3a.ajouteInst(new C3aInstFEnd("fend"));
        defaultOut(node);
        return null;
    }
    //Appel Fonction
    @Override
    public C3aOperand visit(SaExpAppel node) {
        defaultIn(node);
        C3aOperand result = node.getVal().accept(this);
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit(SaAppel node) {
        SaLExp arguments = node.getArguments();
        SaExp exp;
        defaultIn(node);
        while (arguments != null){
            exp = arguments.getTete();
            c3a.ajouteInst(new C3aInstParam(exp.accept(this), ""));
            arguments = arguments.getQueue();
        }
        C3aFunction function = new C3aFunction(tableGlobale.getFct(node.getNom()));
        C3aTemp result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstCall(function, result, ""));
        defaultOut(node);
        return result;
    }
    //Variables
    @Override
    public C3aOperand visit(SaExpInt node){
        defaultIn(node);
        C3aOperand result = new C3aConstant(node.getVal());
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit(SaExpVar node){
        defaultIn(node);
        C3aOperand var = node.getVar().accept(this);
        defaultOut(node);
        return var;
    }
    @Override
    public C3aOperand visit(SaVarSimple node) {
        defaultIn(node);
        TsItemVar var = tableLocaleCourante.getVar(node.getNom());
        if (var == null) var = tableGlobale.getVar(node.getNom());
        C3aOperand result = new C3aVar(var, null);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) {
        defaultIn(node);
        TsItemVar var = tableGlobale.getVar(node.getNom());
        C3aOperand indice = node.getIndice().accept(this);
        // TODO: instanceof Constant
        C3aOperand result = new C3aVar(var, indice);
        defaultOut(node);
        return result;
    }
    //Operations arithmétiques et logiques.
    @Override
    public C3aOperand visit (SaExpAdd node){
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept( this);
        C3aOperand op2 = node.getOp2().accept( this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstAdd(op1, op2, result, ""));
        defaultOut(node);
        return result;

    }
    @Override
    public C3aOperand visit (SaExpSub node){
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept( this);
        C3aOperand op2 = node.getOp2().accept( this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstSub(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit (SaExpMult node){
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept( this);
        C3aOperand op2 = node.getOp2().accept( this);
        C3aOperand reslut = c3a.newTemp();
        c3a.ajouteInst(new C3aInstMult(op1, op2, reslut, ""));
        defaultOut(node);
        return reslut;

    }
    @Override
    public C3aOperand visit (SaExpDiv node){
        defaultIn(node);
        C3aOperand op1 = node.getOp1().accept( this);
        C3aOperand op2 = node.getOp2().accept( this);
        C3aOperand result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstDiv(op1, op2, result, ""));
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit(SaExpAnd node) {
        /*
        fbegin
        si op1 = 0 goto labelFalseResult
        si op2 = 0 goto labelIfResultIfFalse
        result = 1
        goto result
        labelIfResultIfFalse: result = 0
        labelResult: use result
        fend
         */
        defaultIn(node);
        C3aTemp result = c3a.newTemp();
        C3aLabel labelResult = c3a.newAutoLabel();
        C3aLabel labelFalseResult = c3a.newAutoLabel();
        C3aOperand vrai = new C3aConstant(1);
        C3aOperand faux = new C3aConstant(0);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, faux, labelFalseResult, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op2, faux, labelFalseResult, ""));
        c3a.ajouteInst(new C3aInstAffect(vrai, result, ""));
        c3a.ajouteInst(new C3aInstJump(labelResult, ""));
        c3a.addLabelToNextInst(labelFalseResult);
        c3a.ajouteInst(new C3aInstAffect(faux, result, ""));
        c3a.addLabelToNextInst(labelResult);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpOr node) {
        /*
        fbegin
        si op1 != 0 goto labelTrueResult
        si op2 != 0 goto labelTrueResult
        result = 0
        goto labelResult
        labelTrueResult: result = 1
        labelResult: use result
        fend
         */
        defaultIn(node);
        C3aTemp result = c3a.newTemp();
        C3aLabel labelResult = c3a.newAutoLabel();
        C3aLabel labelTrueResult = c3a.newAutoLabel();
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        C3aConstant vrai = new C3aConstant(1);
        C3aOperand faux = new C3aConstant(0);
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, vrai, labelTrueResult, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op2, vrai, labelTrueResult, ""));
        c3a.ajouteInst(new C3aInstAffect(faux, result, ""));
        c3a.ajouteInst(new C3aInstJump(labelResult, ""));
        c3a.addLabelToNextInst(labelTrueResult);
        c3a.ajouteInst(new C3aInstAffect(vrai, result, ""));
        c3a.addLabelToNextInst(labelResult);
        defaultOut(node);
        return result;
    }

    @Override
    public C3aOperand visit(SaExpInf node) {
        /*
        fbegin
        result = 1
        si op1 < op2 goto labelResult
        result = 0
        labelResult: use result
        fend
         */
        defaultIn(node);
        C3aTemp result = c3a.newTemp();
        C3aLabel labelResult = c3a.newAutoLabel();
        C3aOperand vrai = new C3aConstant(1);
        C3aOperand faux = new C3aConstant(0);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(vrai, result, ""));
        c3a.ajouteInst(new C3aInstJumpIfLess(op1, op2, labelResult, ""));
        c3a.ajouteInst(new C3aInstAffect(faux, result, ""));
        c3a.addLabelToNextInst(labelResult);
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit(SaExpEqual node) {
        /*
        fbegin
        result = 1
        si op1 = op2 goto labelEnd
        result = 0
        labelEnd: use result
        fend
        */
        defaultIn(node);
        C3aTemp result = c3a.newTemp();
        C3aLabel labelEnd = c3a.newAutoLabel();
        C3aOperand vrai = new C3aConstant(1);
        C3aOperand faux = new C3aConstant(0);
        C3aOperand op1 = node.getOp1().accept(this);
        C3aOperand op2 = node.getOp2().accept(this);
        c3a.ajouteInst(new C3aInstAffect(vrai, result, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, op2, labelEnd, ""));
        c3a.ajouteInst(new C3aInstAffect(faux, result, ""));
        c3a.addLabelToNextInst(labelEnd);
        defaultOut(node);
        return result;
    }
    @Override
    public C3aOperand visit(SaExpNot node) {
        /*
        fbegin
        result = 0
        si op1 = 1 goto end
        result = 1
        end: use result
        fend
         */
        defaultIn(node);
        C3aTemp result = c3a.newTemp();
        C3aLabel labelEnd = c3a.newAutoLabel();
        C3aOperand vrai = new C3aConstant(1);
        C3aOperand faux = new C3aConstant(0);
        C3aOperand op1 = node.getOp1().accept(this);
        c3a.ajouteInst(new C3aInstAffect(faux, result, ""));
        c3a.ajouteInst(new C3aInstJumpIfEqual(op1, vrai, labelEnd, ""));
        c3a.ajouteInst(new C3aInstAffect(vrai, result, ""));
        c3a.addLabelToNextInst(labelEnd);
        defaultOut(node);
        return result;
    }
    //Affectation.
    @Override
    public C3aOperand visit (SaInstAffect node){
        defaultIn(node);
        C3aOperand var = node.getLhs().accept(this);
        C3aOperand exp = node.getRhs().accept( this);
        c3a.ajouteInst(new C3aInstAffect(exp, var, ""));
        defaultOut(node);
        return null;
    }
    //Saut test
    @Override
    public C3aOperand visit(SaInstSi node) {
        /*
        fbegin
        si test = 0 goto labelEnd
        labelAlors
        labelEnd
        fend
         */
        /*
        fbegin
        si t==0 goto e3
        e1
        si t==0 goto e3
        e2
        e3
        fend
        */
        defaultIn(node);
        C3aLabel labelSinon = c3a.newAutoLabel();
        C3aLabel labelEnd = c3a.newAutoLabel();
        C3aConstant faux = new C3aConstant(0);
        C3aOperand test = node.getTest().accept(this);
        if (node.getSinon() == null) {
            c3a.ajouteInst(new C3aInstJumpIfEqual(test, faux,  labelEnd, ""));
            node.getAlors().accept(this);
        }
        else {
            c3a.ajouteInst(new C3aInstJumpIfEqual(test, faux, labelSinon, ""));
            node.getAlors().accept(this);
            c3a.ajouteInst(new C3aInstJump(labelEnd, ""));
            c3a.addLabelToNextInst(labelSinon);
            node.getSinon().accept(this);
        }
        c3a.addLabelToNextInst(labelEnd);
        defaultOut(node);
        return null;
    }
    //Boucle
    @Override
    public C3aOperand visit(SaInstTantQue node) {
        /*
        fbegin
        test: do test
        si test = 0 goto labelEnd
        do code
        goto test
        labelEnd: next
        fend
         */
        defaultIn(node);
        C3aLabel test = c3a.newAutoLabel();
        C3aLabel labelEnd = c3a.newAutoLabel();
        C3aConstant faux = new C3aConstant(0);
        c3a.addLabelToNextInst(test);
        C3aOperand testResult = node.getTest().accept(this);
        c3a.ajouteInst(new C3aInstJumpIfEqual(testResult, faux, labelEnd, ""));
        node.getFaire().accept(this);
        c3a.ajouteInst(new C3aInstJump(test, ""));
        c3a.addLabelToNextInst(labelEnd);
        defaultOut(node);
        return null;
    }
    //Lire
    @Override
    public C3aOperand visit(SaExpLire node) {
        // TODO: pas idéal
        defaultIn(node);
        C3aTemp result = c3a.newTemp();
        c3a.ajouteInst(new C3aInstRead(result, ""));
        defaultOut(node);
        return result;
    }
    //Ecrire
    @Override
    public C3aOperand visit(SaInstEcriture node) {
        defaultIn(node);
        C3aOperand exp = node.getArg().accept(this);
        c3a.ajouteInst(new C3aInstWrite(exp, ""));
        defaultOut(node);
        return null;
    }
    //Retour
    @Override
    public C3aOperand visit(SaInstRetour node) {
        defaultIn(node);
        C3aOperand op = node.getVal().accept(this);
        c3a.ajouteInst(new C3aInstReturn(op, ""));
        defaultOut(node);
        return null;
    }
}
