import sc.analysis.DepthFirstAdapter;
import sa.*;
import sc.node.*;

public class Sc2sa extends DepthFirstAdapter {
    private SaNode returnValue;

    /*public void defaultIn(Node node){
        System.out.println("<" + node.getClass().getSimpleName() + ">");
    }
    public void defaultOut(Node node){
        System.out.println("</" + node.getClass().getSimpleName() + ">");
    }*/
    public SaNode getRoot(){
        return returnValue;
    }

    @Override
    public void caseStart(Start node) {
        inStart(node);
        System.out.println("Start");
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    @Override
    public void caseALdfDvglobalsProgramme(ALdfDvglobalsProgramme node){
        SaLDec var= null;
        SaLDec function = null ;
        inALdfDvglobalsProgramme(node);
        if(node.getOptdv() != null) {
            node.getOptdv().apply(this);
            var = (SaLDec) this.returnValue;
        }
        if(node.getLdf() != null) {
            node.getLdf().apply(this);
            function= (SaLDec) this.returnValue;
        }
        this.returnValue = new SaProg(var , function);
        outALdfDvglobalsProgramme(node);
    }
    public void caseAOptdvOptdv(AOptdvOptdv node) {
        SaLDec optdv = null;
        inAOptdvOptdv(node);
        if(node.getLdv() != null) {
            node.getLdv().apply(this);
            optdv = (SaLDec) this.returnValue;
        }
        if(node.getPointVirgule() != null){
            node.getPointVirgule().apply(this);
        }
        this.returnValue = optdv;
        outAOptdvOptdv(node);
    }

    @Override
    public void caseALdvLdv(ALdvLdv node){
        SaDec head =null;
        SaLDec queue=null;
        inALdvLdv(node);
        if (node.getDv() != null){
            node.getDv().apply(this);
            head = (SaDec) this.returnValue;
        }
        if (node.getLdvsuite() != null){
            node.getLdvsuite().apply(this);
            queue = (SaLDec) this.returnValue;
        }
        this.returnValue = new SaLDec(head, queue);
        outALdvLdv(node);
    }

    @Override
    public void caseADvLdv(ADvLdv node){
        SaDec dvar =null;
        inADvLdv(node);
        if (node.getDv() != null){
            node.getDv().apply(this);
            dvar = (SaDec) this.returnValue;
        }
        this.returnValue = new SaLDec(dvar, null);
        outADvLdv(node);
    }
    @Override
    public void caseASuiteLdvLdvsuite(ASuiteLdvLdvsuite node){
        SaDec head =null;
        SaLDec queue=null;
        inASuiteLdvLdvsuite(node);
        if (node.getVirgule() != null){
            node.getVirgule().apply(this);
        }
        if (node.getDv() != null){
            node.getDv().apply(this);
            head = (SaDec) this.returnValue;
        }
        if (node.getLdvsuite() != null){
            node.getLdvsuite().apply(this);
            queue = (SaLDec) this.returnValue;
        }
        this.returnValue = new SaLDec(head, queue);
        outASuiteLdvLdvsuite(node);
    }
    @Override
    public void caseASuiteDvLdvsuite(ASuiteDvLdvsuite node){
        SaDec dvar =null;
        inASuiteDvLdvsuite(node);
        if (node.getVirgule() != null){
            node.getVirgule().apply(this);
        }
        if (node.getDv() != null){
            node.getDv().apply(this);
            dvar = (SaDec) this.returnValue;
        }
        this.returnValue = new SaLDec(dvar, null);
        outASuiteDvLdvsuite(node);
    }
    @Override
    public void caseAVarDv(AVarDv node){
        String id = null;
        inAVarDv(node);
        if (node.getType() != null){
            node.getType().apply(this);
        }
        if (node.getIdentif() != null){
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }
        this.returnValue = new SaDecVar(id);
        outAVarDv(node);
    }
    @Override
    public void caseATableauDv(ATableauDv node){
        String id = null;
        int taille = 0;
        inATableauDv(node);
        if (node.getType() != null){
            node.getType().apply(this);
        }
        if (node.getIdentif() != null){
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
            System.out.println("h");
        }
        if (node.getCrochetOuvrant() != null){
            node.getCrochetOuvrant().apply(this);
        }
        if (node.getNombre() != null){
            node.getNombre().apply(this);
            taille = Integer.parseInt (node.getNombre().getText());
        }
        if (node.getCrochetFermant() != null){
            node.getCrochetFermant().apply(this);
        }
        this.returnValue = new SaDecTab(id, taille);
        outATableauDv(node);
    }

    @Override
    public void caseALdfLdf(ALdfLdf node){
        SaDec head =null;
        SaLDec queue=null;
        inALdfLdf(node);
        if (node.getDf() != null){
            node.getDf().apply(this);
            head = (SaDec) this.returnValue;
        }
        if (node.getLdf() != null){
            node.getLdf().apply(this);
            queue = (SaLDec) this.returnValue;
        }
        this.returnValue = new SaLDec(head, queue);
        outALdfLdf(node);
    }
    @Override
    public void caseALdfVideLdf(ALdfVideLdf node){
        inALdfVideLdf(node);
        this.returnValue = null;
        outALdfVideLdf(node);
    }
    @Override
    public void caseADfDf(ADfDf node){
        String id = null;
        SaLDec param=null;
        SaLDec variables=null;
        SaInst corps=null;
        inADfDf(node);
        if (node.getIdentif() != null){
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }
        if (node.getLparam() != null){
            node.getLparam().apply(this);
            param = (SaLDec) this.returnValue;
        }
        if (node.getOptdv() != null){
            node.getOptdv().apply(this);
            variables = (SaLDec) this.returnValue;
        }
        if (node.getInstbloc() != null){
            node.getInstbloc().apply(this);
            corps = (SaInst) this.returnValue;
        }
        this.returnValue = new SaDecFonc(id, param, variables, corps);
        outADfDf(node);
    }
    @Override
    public void caseADfSansvariablesDf(ADfSansvariablesDf node){
        String id = null;
        SaLDec param=null;
        SaInst corps=null;
        inADfSansvariablesDf(node);
        if (node.getIdentif() != null){
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }
        if (node.getLparam() != null){
            node.getLparam().apply(this);
            param = (SaLDec) this.returnValue;
        }
        if (node.getInstbloc() != null){
            node.getInstbloc().apply(this);
            corps = (SaInst) this.returnValue;
        }
        this.returnValue = new SaDecFonc(id, param, null, corps);
        outADfSansvariablesDf(node);
    }
    @Override
    public void caseASansLparam(ASansLparam node){
        inASansLparam(node);
        if (node.getParentheseOuvrante() != null){
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getParentheseFermante() != null){
            node.getParentheseFermante().apply(this);
        }
        this.returnValue = null;
        outASansLparam(node);
    }
    @Override
    public void caseAAvecLparam(AAvecLparam node){
        SaLDec param = null;
        inAAvecLparam(node);
        if (node.getParentheseOuvrante() != null){
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getLdv() != null){
            node.getLdv().apply(this);
            param = (SaLDec) this.returnValue;
        }
        if (node.getParentheseFermante() != null){
            node.getParentheseFermante().apply(this);
        }
        this.returnValue = param;
        outAAvecLparam(node);
    }

    @Override
    public void caseAInstaffectInst(AInstaffectInst node){
        SaInst ins= null;
        inAInstaffectInst(node);
        if (node.getInstaffect() != null){
            node.getInstaffect().apply(this);
            ins = (SaInst) this.returnValue;
        }
        this.returnValue = ins;
        outAInstaffectInst(node);
    }
    @Override
    public void caseAInstblocInst(AInstblocInst node){
        SaInstBloc ib= null;
        inAInstblocInst(node);
        if (node.getInstbloc() != null){
            node.getInstbloc().apply(this);
            ib = (SaInstBloc) this.returnValue;
        }
        this.returnValue = ib;
        outAInstblocInst(node);
    }
    @Override
    public void caseAInstsiInst(AInstsiInst node){
        inAInstsiInst(node);
        if (node.getInstsi() != null){
            node.getInstsi().apply(this);
        }
        outAInstsiInst(node);
    }
    @Override
    public void caseAInsttantqueInst(AInsttantqueInst node){
        inAInsttantqueInst(node);
        if (node.getInsttantque() != null){
            node.getInsttantque().apply(this);
        }
        outAInsttantqueInst(node);
    }
    @Override
    public void caseAInstappelInst(AInstappelInst node){
        inAInstappelInst(node);
        if (node.getInstappel() != null){
            node.getInstappel().apply(this);
        }
        outAInstappelInst(node);
    }
    @Override
    public void caseAInstretourInst(AInstretourInst node){
        inAInstretourInst(node);
        if (node.getInstretour() != null){
            node.getInstretour().apply(this);
        }
        outAInstretourInst(node);
    }
    @Override
    public void caseAInstecritureInst(AInstecritureInst node){
        inAInstecritureInst(node);
        if (node.getInstecriture() != null){
            node.getInstecriture().apply(this);
        }
        outAInstecritureInst(node);
    }
    @Override
    public void caseAInstvideInst(AInstvideInst node){
        inAInstvideInst(node);
        if (node.getInstvide() != null){
            node.getInstvide().apply(this);
        }
        outAInstvideInst(node);
    }

    @Override
    public void caseAInstaffect(AInstaffect node){
        SaVar var = null;
        SaExp exp = null;
        inAInstaffect(node);
        if (node.getVar() != null){
            node.getVar().apply(this);
            var = (SaVar) this.returnValue;
        }
        if (node.getEgale() != null){
            node.getEgale().apply(this);
        }
        if (node.getExp() != null){
            node.getExp().apply(this);
            exp = (SaExp) this.returnValue;
        }
        if (node.getPointVirgule() != null){
            node.getPointVirgule().apply(this);
        }
        this.returnValue = new SaInstAffect(var, exp);
        outAInstaffect(node);
    }

    @Override
    public void caseAInstbloc(AInstbloc node){
        SaLInst linst = null;
        inAInstbloc(node);
        if (node.getAccoladeOuvrante() != null){
            node.getAccoladeOuvrante().apply(this);
        }
        if (node.getLinst() != null){
            node.getLinst().apply(this);
            linst = (SaLInst) this.returnValue;
        }
        if (node.getAccoladeFermante() != null){
            node.getAccoladeFermante().apply(this);
        }
        if (linst == null) this.returnValue = null;
        else this.returnValue = new SaInstBloc(linst);
        outAInstbloc(node);
    }
    @Override
    public void caseALinstLinst(ALinstLinst node){
        SaInst inst = null;
        SaLInst linst = null;
        inALinstLinst(node);
        if (node.getInst() != null){
            node.getInst().apply(this);
            inst = (SaInst) this.returnValue;
        }
        if (node.getLinst() != null){
            node.getLinst().apply(this);
            linst = (SaLInst) this.returnValue;
        }
        this.returnValue = new SaLInst(inst, linst);
        outALinstLinst(node);
    }
    @Override
    public void caseALinstvideLinst(ALinstvideLinst node){
        inALinstvideLinst(node);
        this.returnValue = null;
        outALinstvideLinst(node);
    }

    @Override
    public void caseASinonInstsi(ASinonInstsi node){
        SaExp exp = null;
        SaInst ib = null;
        SaInst isinon = null;
        inASinonInstsi(node);
        if (node.getSi() != null){
            node.getSi().apply(this);
        }
        if (node.getExp() != null){
            node.getExp().apply(this);
            exp = (SaExp) this.returnValue;
        }
        if (node.getAlors() != null){
            node.getAlors().apply(this);
        }
        if (node.getInstbloc() != null){
            node.getInstbloc().apply(this);
            ib = (SaInst) this.returnValue;
        }
        if (node.getInstsinon() != null){
            node.getInstsinon().apply(this);
            isinon = (SaInst) this.returnValue;
        }

        this.returnValue = new SaInstSi(exp, ib, isinon);
        outASinonInstsi(node);
    }
    @Override
    public void caseASiInstsi(ASiInstsi node){
        SaExp exp = null;
        SaInst ib = null;
        inASiInstsi(node);
        if (node.getSi() != null){
            node.getSi().apply(this);
        }
        if (node.getExp() != null){
            node.getExp().apply(this);
            exp = (SaExp) this.returnValue;
        }
        if (node.getAlors() != null){
            node.getAlors().apply(this);
        }
        if (node.getInstbloc() != null){
            node.getInstbloc().apply(this);
            ib = (SaInst) this.returnValue;
        }

        this.returnValue = new SaInstSi(exp, ib, null);
        outASiInstsi(node);
    }
    @Override
    public void caseAInstsinon(AInstsinon node){
        SaInst ib = null;
        inAInstsinon(node);
        if (node.getSinon() != null){
            node.getSinon().apply(this);
        }
        if (node.getInstbloc() != null){
            node.getInstbloc().apply(this);
            ib = (SaInst) this.returnValue;
        }
        this.returnValue = ib;
        outAInstsinon(node);
    }

    @Override
    public void caseAInsttantque(AInsttantque node){
        SaExp exp = null;
        SaInst ib = null;
        inAInsttantque(node);
        if (node.getTantque() != null){
            node.getTantque().apply(this);
        }
        if (node.getExp() != null){
            node.getExp().apply(this);
            exp = (SaExp) this.returnValue;
        }
        if (node.getFaire() != null){
            node.getFaire().apply(this);
        }
        if (node.getInstbloc() != null){
            node.getInstbloc().apply(this);
            ib = (SaInst) this.returnValue;
        }
        this.returnValue = new SaInstTantQue(exp, ib);
        outAInsttantque(node);
    }

    @Override
    public void caseAInstappel(AInstappel node){
        inAInstappel(node);
        if (node.getAppelf() != null){
            node.getAppelf().apply(this);
        }
        if (node.getPointVirgule() != null){
            node.getPointVirgule().apply(this);
        }
        outAInstappel(node);
    }

    @Override
    public void caseAInstretour(AInstretour node){
        SaExp exp = null;
        inAInstretour(node);
        if (node.getRetour() != null){
            node.getRetour().apply(this);
        }
        if (node.getExp() != null){
            node.getExp().apply(this);
            exp = (SaExp) this.returnValue;
        }
        if (node.getPointVirgule() != null){
            node.getPointVirgule().apply(this);
        }
        this.returnValue = new SaInstRetour(exp);
        outAInstretour(node);
    }

    @Override
    public void caseAInstecriture(AInstecriture node){
        SaExp exp = null;
        inAInstecriture(node);
        if (node.getEcrire() != null){
            node.getEcrire().apply(this);
        }
        if (node.getParentheseOuvrante() != null){
            node.getParentheseOuvrante().apply(this);
        }
        if (node.getExp() != null){
            node.getExp().apply(this);
            exp = (SaExp) this.returnValue;
        }
        if (node.getParentheseFermante() != null){
            node.getParentheseFermante().apply(this);
        }
        if (node.getPointVirgule() != null){
            node.getPointVirgule().apply(this);
        }
        this.returnValue = new SaInstEcriture(exp);
        outAInstecriture(node);
    }

    @Override
    public void caseAInstvide(AInstvide node){
        inAInstvide(node);
        if (node.getPointVirgule() != null){
            node.getPointVirgule().apply(this);
        }
        outAInstvide(node);
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
        if(node.getT3() != null) {
            node.getT3().apply(this);
            exp2 = (SaExp) this.returnValue;
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
        if(node.getInferieur() != null) {
            node.getInferieur().apply(this);
        }
        if(node.getT3() != null) {
            node.getT3().apply(this);
            exp2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpInf(exp1 , exp2 );
        outAInfT2(node);
    }

    @Override
    public void caseAT3T2(AT3T2 node) {
        inAT3T2(node);
        if(node.getT3() != null) {
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
    public void caseAT4T3(AT4T3 node) {
        inAT4T3(node);
        if(node.getT4() != null) {
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
    public void caseADiviseT4(ADiviseT4 node) {
        SaExp exp1 = null;
        SaExp exp2 = null;
        inADiviseT4(node);
        if(node.getT4() != null) {
            node.getT4().apply(this);
            exp1 = (SaExp) this.returnValue;
        }
        if(node.getDivise() != null) {
            node.getDivise().apply(this);
        }
        if(node.getT5() != null) {
            node.getT5().apply(this);
            exp2 = (SaExp) this.returnValue;
        }
        this.returnValue = new SaExpDiv(exp1 , exp2);
        outADiviseT4(node);
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
    public void caseAT6T5(AT6T5 node) {
        inAT6T5(node);
        if(node.getT6() != null) {
            node.getT6().apply(this);
        }
        outAT6T5(node);
    }

    @Override
    public void caseANombreT6(ANombreT6 node) {
        Integer val = null;
        inANombreT6(node);
        if(node.getNombre() != null) {
            node.getNombre().apply(this);
            val = Integer.parseInt(node.getNombre().getText());
        }
        this.returnValue = new SaExpInt(val);
        outANombreT6(node);
    }

    @Override
    public void caseAVarT6(AVarT6 node) {
        SaVar var = null;
        inAVarT6(node);
        if(node.getVar() != null) {
            node.getVar().apply(this);
            var = (SaVar) this.returnValue;
        }
        this.returnValue = new SaExpVar(var);
        outAVarT6(node);
    }

    @Override
    public void caseAAppelfT6(AAppelfT6 node) {
        SaAppel appel = null;
        inAAppelfT6(node);
        if(node.getAppelf() != null) {
            node.getAppelf().apply(this);
            appel = (SaAppel) this.returnValue;
        }
        this.returnValue = new SaExpAppel(appel);
        outAAppelfT6(node);
    }

    @Override
    public void caseAParT6(AParT6 node) {
        inAParT6(node);
        if(node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getExp() != null) {
            node.getExp().apply(this);
        }
        if(node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        outAParT6(node);
    }
    @Override
    public void caseALireT6(ALireT6 node) {
        inALireT6(node);
        if(node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        outALireT6(node);
    }

    @Override
    public void caseATabVar(ATabVar node) {
        String id = null;
        SaExp exp = null;
        inATabVar(node);
        if(node.getIdentif() != null) {
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }
        if(node.getCrochetOuvrant() != null) {
            node.getCrochetOuvrant().apply(this);
        }
        if(node.getExp() != null) {
            node.getExp().apply(this);
            exp = (SaExp) this.returnValue;
        }
        if(node.getCrochetFermant() != null) {
            node.getCrochetFermant().apply(this);
        }
        this.returnValue = new SaVarIndicee(id, exp);
        outATabVar(node);
    }
    @Override
    public void caseAVarVar(AVarVar node) {
        String id = null;
        inAVarVar(node);
        if(node.getIdentif() != null) {
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }
        this.returnValue = new SaVarSimple(id);
        outAVarVar(node);
    }

    @Override
    public void caseALexpLexp(ALexpLexp node) {
        SaExp head = null;
        SaLExp queue = null;
        inALexpLexp(node);
        if(node.getExp() != null) {
            node.getExp().apply(this);
            head = (SaExp) this.returnValue;
        }
        if(node.getLexpSuite() != null) {
            node.getLexpSuite().apply(this);
            queue = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(head, queue);
        outALexpLexp(node);
    }
    @Override
    public void caseAVideLexp(AVideLexp node) {
        inAVideLexp(node);
        this.returnValue = null;
        outAVideLexp(node);
    }

    @Override
    public void caseALsuiteLexpSuite(ALsuiteLexpSuite node) {
        SaExp head = null;
        SaLExp queue = null;
        inALsuiteLexpSuite(node);
        if(node.getVirgule() != null) {
            node.getVirgule().apply(this);
        }
        if(node.getExp() != null) {
            node.getExp().apply(this);
            head = (SaExp) this.returnValue;
        }
        if(node.getLexpSuite() != null) {
            node.getLexpSuite().apply(this);
            queue = (SaLExp) this.returnValue;
        }
        this.returnValue = new SaLExp(head, queue);
        outALsuiteLexpSuite(node);
    }
    @Override
    public void caseAVideLexpSuite(AVideLexpSuite node) {
        inAVideLexpSuite(node);
        this.returnValue = null;
        outAVideLexpSuite(node);
    }

    @Override
    public void caseAAppelf(AAppelf node) {
        String id = null;
        SaLExp lexp = null;
        inAAppelf(node);
        if(node.getIdentif() != null) {
            node.getIdentif().apply(this);
            id = node.getIdentif().getText();
        }
        if(node.getParentheseOuvrante() != null) {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getLexp() != null) {
            node.getLexp().apply(this);
            lexp = (SaLExp) this.returnValue;
        }
        if(node.getParentheseFermante() != null) {
            node.getParentheseFermante().apply(this);
        }
        this.returnValue = new SaAppel(id, lexp);
        outAAppelf(node);
    }
}
