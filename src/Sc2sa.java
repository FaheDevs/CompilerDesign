import sc.analysis.DepthFirstAdapter;
import sa.*;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public SaNode getRoot(){
        return returnValue;
    }

    @Override
    public void caseStart(Start node) {
        inStart(node);
        System.out.println("Start");
        outStart(node);
    }
    @Override
    public void caseAProg1Programme(AProg1Programme node){
        SaLDec var= null;
        SaLDec function = null ;
        inAProg1Programme(node);
        if(node.getDvfonction() != null) {
            node.getDvfonction().apply(this);
            var = (SaLDec) this.returnValue;
        }
        if(node.getLfonction() != null) {
            node.getLfonction().apply(this);
            function= (SaLDec) this.returnValue;
        }
        this.returnValue = new SaProg(var , function);
        outAProg1Programme(node);
    }

    @Override
    public void caseAOuExp(AOuExp node) {
        SaExp op1 = null;
        SaExp op2 = null;
        inAOuExp(node);
        if(node.getExp() != null) {
            node.getExp().apply(this);
            op1 = (SaExp) this.returnValue;
        }
        if(node.getOu() != null){
            node.getOu().apply(this);
        }
        if(node.getT1() != null) {
            node.getT1().apply(this);
            op2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpOr(op1 , op2);
        outAOuExp(node);
    }
    @Override
    public void caseAT1Exp(AT1Exp node) {
        inAT1Exp(node);
        if(node.getT1() != null) {
            node.getT1().apply(this);
        }
        outAT1Exp(node);
    }

    @Override
    public void caseAEtT1(AEtT1 node) {
        SaExp exp1 = null;
        SaExp exp2 = null;
        inAEtT1(node);
        if(node.getT1() != null) {
            node.getT1().apply(this);
            exp1 =(SaExp) this.returnValue;
        }
        if(node.getEt() != null) {
            node.getEt().apply(this);
        }
        if(node.getT2() != null) {
            node.getT2().apply(this);
            exp2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpAnd(exp1 , exp2);
        outAEtT1(node);
    }
    @Override
    public void caseAT2T1(AT2T1 node) {
        inAT2T1(node);
        if(node.getT2() != null) {
            node.getT2().apply(this);
        }
        outAT2T1(node);
    }
    @Override
    public void caseAEgaleT2(AEgaleT2 node) {
        SaExp exp1 = null;
        SaExp exp2 = null;
        inAEgaleT2(node);
        if(node.getT2() != null) {
            node.getT2().apply(this);
            exp1=(SaExp) this.returnValue;
        }
        if(node.getEgale() != null) {
            node.getEgale().apply(this);
        }
        exp2 = (SaExp) this.returnValue;
        if(node.getT3() != null) {
            node.getT3().apply(this);
        }
        this.returnValue = new SaExpEqual(exp1, exp2);
        outAEgaleT2(node);
    }
    @Override
    public void caseAInfT2(AInfT2 node) {
        SaExp exp1 = null;
        SaExp exp2 = null;
        inAInfT2(node);
        if(node.getT2() != null) {
            node.getT2().apply(this);
            exp1 = (SaExp) this.returnValue;
        }
        if(node.getInf() != null) {
            node.getInf().apply(this);
            exp2 = (SaExp) this.returnValue;
        }
        if(node.getT3() != null) {
            node.getT3().apply(this);
        }
        this.returnValue = new SaExpInf(exp1 , exp2 );
        outAInfT2(node);
    }

    @Override
    public void caseAT3T2(AT3T2 node)
    {
        inAT3T2(node);
        if(node.getT3() != null)
        {
            node.getT3().apply(this);
        }
        outAT3T2(node);
    }

    @Override
    public void caseAPlusT3(APlusT3 node) {
        SaExp exp1 =null;
        SaExp exp2 = null;
        inAPlusT3(node);
        if(node.getT3() != null) {
            node.getT3().apply(this);
            exp1 = (SaExp) this.returnValue;
        }
        if(node.getPlus() != null) {
            node.getPlus().apply(this);
        }
        if(node.getT4() != null) {
            node.getT4().apply(this);
            exp2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpAdd(exp1, exp2);
        outAPlusT3(node);
    }

    @Override
    public void caseAMinusT3(AMinusT3 node){
        SaExp exp1 =null;
        SaExp exp2 = null;
        inAMinusT3(node);
        if(node.getT3() != null) {
            node.getT3().apply(this);
            exp1 = (SaExp) this.returnValue;
        }
        if(node.getMinus() != null) {
            node.getMinus().apply(this);

        }
        if(node.getT4() != null) {
            node.getT4().apply(this);
            exp2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpSub(exp1 , exp2);
        outAMinusT3(node);
    }

    @Override
    public void caseAT4T3(AT4T3 node)
    {
        inAT4T3(node);
        if(node.getT4() != null)
        {
            node.getT4().apply(this);
        }
        outAT4T3(node);
    }

    @Override
    public void caseAMultT4(AMultT4 node) {
        SaExp exp1 = null;
        SaExp exp2 = null;
        inAMultT4(node);
        if(node.getT4() != null) {
            node.getT4().apply(this);
            exp1 = (SaExp) this.returnValue;
        }
        if(node.getMult() != null) {
            node.getMult().apply(this);
        }
        if(node.getT5() != null) {
            node.getT5().apply(this);
            exp2= (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpMult(exp1,exp2);
        outAMultT4(node);
    }

    @Override
    public void caseADivT4(ADivT4 node) {
        SaExp exp1 = null;
        SaExp exp2 = null;
        inADivT4(node);
        if(node.getT4() != null) {
            node.getT4().apply(this);
            exp1 = (SaExp) this.returnValue;
        }
        if(node.getDiv() != null) {
            node.getDiv().apply(this);
            exp2 = (SaExp) this.returnValue;
        }
        if(node.getT5() != null) {
            node.getT5().apply(this);
        }
        this.returnValue = new SaExpDiv(exp1 , exp2);
        outADivT4(node);
    }

    @Override
    public void caseAT5T4(AT5T4 node) {
        inAT5T4(node);
        if(node.getT5() != null) {
            node.getT5().apply(this);
        }
        outAT5T4(node);
    }

    @Override
    public void caseANonT5(ANonT5 node) {
        SaExp exp = null;
        inANonT5(node);
        if(node.getNon() != null) {
            node.getNon().apply(this);
        }
        if(node.getT5() != null) {
            node.getT5().apply(this);
            exp = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpNot(exp);
        outANonT5(node);
    }

    @Override
    public void caseANombreT5(ANombreT5 node) {
        int val = 0;
        inANombreT5(node);
        if(node.getNombre() != null) {
            node.getNombre().apply(this);
            val = Integer.parseInt(node.getNombre().getText());
        }
        this.returnValue = new SaExpInt(val);
        outANombreT5(node);
    }

    @Override
    public void caseAIdentifT5(AIdentifT5 node) {
        SaVar var = null;
        inAIdentifT5(node);
        if(node.getIdentif() != null) {
            var = (SaVar) this.returnValue;
            node.getIdentif().apply(this);
        }
        this.returnValue = new SaExpVar(var);
        outAIdentifT5(node);
    }













}
