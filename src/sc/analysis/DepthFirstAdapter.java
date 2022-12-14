/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import java.util.*;
import sc.node.*;

public class DepthFirstAdapter extends AnalysisAdapter
{
    public void inStart(Start node)
    {
        defaultIn(node);
    }

    public void outStart(Start node)
    {
        defaultOut(node);
    }

    public void defaultIn(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    public void defaultOut(@SuppressWarnings("unused") Node node)
    {
        // Do nothing
    }

    @Override
    public void caseStart(Start node)
    {
        inStart(node);
        node.getPProgramme().apply(this);
        node.getEOF().apply(this);
        outStart(node);
    }

    public void inALdfDvglobalsProgramme(ALdfDvglobalsProgramme node)
    {
        defaultIn(node);
    }

    public void outALdfDvglobalsProgramme(ALdfDvglobalsProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdfDvglobalsProgramme(ALdfDvglobalsProgramme node)
    {
        inALdfDvglobalsProgramme(node);
        if(node.getOptdv() != null)
        {
            node.getOptdv().apply(this);
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        outALdfDvglobalsProgramme(node);
    }

    public void inALdfProgramme(ALdfProgramme node)
    {
        defaultIn(node);
    }

    public void outALdfProgramme(ALdfProgramme node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdfProgramme(ALdfProgramme node)
    {
        inALdfProgramme(node);
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        outALdfProgramme(node);
    }

    public void inAOptdvOptdv(AOptdvOptdv node)
    {
        defaultIn(node);
    }

    public void outAOptdvOptdv(AOptdvOptdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOptdvOptdv(AOptdvOptdv node)
    {
        inAOptdvOptdv(node);
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAOptdvOptdv(node);
    }

    public void inALdvLdv(ALdvLdv node)
    {
        defaultIn(node);
    }

    public void outALdvLdv(ALdvLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdvLdv(ALdvLdv node)
    {
        inALdvLdv(node);
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getLdvsuite() != null)
        {
            node.getLdvsuite().apply(this);
        }
        outALdvLdv(node);
    }

    public void inADvLdv(ADvLdv node)
    {
        defaultIn(node);
    }

    public void outADvLdv(ADvLdv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADvLdv(ADvLdv node)
    {
        inADvLdv(node);
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        outADvLdv(node);
    }

    public void inASuiteLdvLdvsuite(ASuiteLdvLdvsuite node)
    {
        defaultIn(node);
    }

    public void outASuiteLdvLdvsuite(ASuiteLdvLdvsuite node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASuiteLdvLdvsuite(ASuiteLdvLdvsuite node)
    {
        inASuiteLdvLdvsuite(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        if(node.getLdvsuite() != null)
        {
            node.getLdvsuite().apply(this);
        }
        outASuiteLdvLdvsuite(node);
    }

    public void inASuiteDvLdvsuite(ASuiteDvLdvsuite node)
    {
        defaultIn(node);
    }

    public void outASuiteDvLdvsuite(ASuiteDvLdvsuite node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASuiteDvLdvsuite(ASuiteDvLdvsuite node)
    {
        inASuiteDvLdvsuite(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getDv() != null)
        {
            node.getDv().apply(this);
        }
        outASuiteDvLdvsuite(node);
    }

    public void inAVarDv(AVarDv node)
    {
        defaultIn(node);
    }

    public void outAVarDv(AVarDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarDv(AVarDv node)
    {
        inAVarDv(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        outAVarDv(node);
    }

    public void inATableauDv(ATableauDv node)
    {
        defaultIn(node);
    }

    public void outATableauDv(ATableauDv node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATableauDv(ATableauDv node)
    {
        inATableauDv(node);
        if(node.getType() != null)
        {
            node.getType().apply(this);
        }
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getCrochetOuvrant() != null)
        {
            node.getCrochetOuvrant().apply(this);
        }
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        if(node.getCrochetFermant() != null)
        {
            node.getCrochetFermant().apply(this);
        }
        outATableauDv(node);
    }

    public void inALdfLdf(ALdfLdf node)
    {
        defaultIn(node);
    }

    public void outALdfLdf(ALdfLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdfLdf(ALdfLdf node)
    {
        inALdfLdf(node);
        if(node.getDf() != null)
        {
            node.getDf().apply(this);
        }
        if(node.getLdf() != null)
        {
            node.getLdf().apply(this);
        }
        outALdfLdf(node);
    }

    public void inALdfVideLdf(ALdfVideLdf node)
    {
        defaultIn(node);
    }

    public void outALdfVideLdf(ALdfVideLdf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALdfVideLdf(ALdfVideLdf node)
    {
        inALdfVideLdf(node);
        outALdfVideLdf(node);
    }

    public void inADfDf(ADfDf node)
    {
        defaultIn(node);
    }

    public void outADfDf(ADfDf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADfDf(ADfDf node)
    {
        inADfDf(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getLparam() != null)
        {
            node.getLparam().apply(this);
        }
        if(node.getOptdv() != null)
        {
            node.getOptdv().apply(this);
        }
        if(node.getInstbloc() != null)
        {
            node.getInstbloc().apply(this);
        }
        outADfDf(node);
    }

    public void inADfSansvariablesDf(ADfSansvariablesDf node)
    {
        defaultIn(node);
    }

    public void outADfSansvariablesDf(ADfSansvariablesDf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADfSansvariablesDf(ADfSansvariablesDf node)
    {
        inADfSansvariablesDf(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getLparam() != null)
        {
            node.getLparam().apply(this);
        }
        if(node.getInstbloc() != null)
        {
            node.getInstbloc().apply(this);
        }
        outADfSansvariablesDf(node);
    }

    public void inASansLparam(ASansLparam node)
    {
        defaultIn(node);
    }

    public void outASansLparam(ASansLparam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASansLparam(ASansLparam node)
    {
        inASansLparam(node);
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outASansLparam(node);
    }

    public void inAAvecLparam(AAvecLparam node)
    {
        defaultIn(node);
    }

    public void outAAvecLparam(AAvecLparam node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAvecLparam(AAvecLparam node)
    {
        inAAvecLparam(node);
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getLdv() != null)
        {
            node.getLdv().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAAvecLparam(node);
    }

    public void inAInstaffectInst(AInstaffectInst node)
    {
        defaultIn(node);
    }

    public void outAInstaffectInst(AInstaffectInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstaffectInst(AInstaffectInst node)
    {
        inAInstaffectInst(node);
        if(node.getInstaffect() != null)
        {
            node.getInstaffect().apply(this);
        }
        outAInstaffectInst(node);
    }

    public void inAInstblocInst(AInstblocInst node)
    {
        defaultIn(node);
    }

    public void outAInstblocInst(AInstblocInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstblocInst(AInstblocInst node)
    {
        inAInstblocInst(node);
        if(node.getInstbloc() != null)
        {
            node.getInstbloc().apply(this);
        }
        outAInstblocInst(node);
    }

    public void inAInstsiInst(AInstsiInst node)
    {
        defaultIn(node);
    }

    public void outAInstsiInst(AInstsiInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstsiInst(AInstsiInst node)
    {
        inAInstsiInst(node);
        if(node.getInstsi() != null)
        {
            node.getInstsi().apply(this);
        }
        outAInstsiInst(node);
    }

    public void inAInsttantqueInst(AInsttantqueInst node)
    {
        defaultIn(node);
    }

    public void outAInsttantqueInst(AInsttantqueInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInsttantqueInst(AInsttantqueInst node)
    {
        inAInsttantqueInst(node);
        if(node.getInsttantque() != null)
        {
            node.getInsttantque().apply(this);
        }
        outAInsttantqueInst(node);
    }

    public void inAInstappelInst(AInstappelInst node)
    {
        defaultIn(node);
    }

    public void outAInstappelInst(AInstappelInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstappelInst(AInstappelInst node)
    {
        inAInstappelInst(node);
        if(node.getInstappel() != null)
        {
            node.getInstappel().apply(this);
        }
        outAInstappelInst(node);
    }

    public void inAInstretourInst(AInstretourInst node)
    {
        defaultIn(node);
    }

    public void outAInstretourInst(AInstretourInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstretourInst(AInstretourInst node)
    {
        inAInstretourInst(node);
        if(node.getInstretour() != null)
        {
            node.getInstretour().apply(this);
        }
        outAInstretourInst(node);
    }

    public void inAInstecritureInst(AInstecritureInst node)
    {
        defaultIn(node);
    }

    public void outAInstecritureInst(AInstecritureInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstecritureInst(AInstecritureInst node)
    {
        inAInstecritureInst(node);
        if(node.getInstecriture() != null)
        {
            node.getInstecriture().apply(this);
        }
        outAInstecritureInst(node);
    }

    public void inAInstincrInst(AInstincrInst node)
    {
        defaultIn(node);
    }

    public void outAInstincrInst(AInstincrInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstincrInst(AInstincrInst node)
    {
        inAInstincrInst(node);
        if(node.getInstincr() != null)
        {
            node.getInstincr().apply(this);
        }
        outAInstincrInst(node);
    }

    public void inAInstvideInst(AInstvideInst node)
    {
        defaultIn(node);
    }

    public void outAInstvideInst(AInstvideInst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstvideInst(AInstvideInst node)
    {
        inAInstvideInst(node);
        if(node.getInstvide() != null)
        {
            node.getInstvide().apply(this);
        }
        outAInstvideInst(node);
    }

    public void inAInstaffect(AInstaffect node)
    {
        defaultIn(node);
    }

    public void outAInstaffect(AInstaffect node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstaffect(AInstaffect node)
    {
        inAInstaffect(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getEgale() != null)
        {
            node.getEgale().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstaffect(node);
    }

    public void inAInstbloc(AInstbloc node)
    {
        defaultIn(node);
    }

    public void outAInstbloc(AInstbloc node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstbloc(AInstbloc node)
    {
        inAInstbloc(node);
        if(node.getAccoladeOuvrante() != null)
        {
            node.getAccoladeOuvrante().apply(this);
        }
        if(node.getLinst() != null)
        {
            node.getLinst().apply(this);
        }
        if(node.getAccoladeFermante() != null)
        {
            node.getAccoladeFermante().apply(this);
        }
        outAInstbloc(node);
    }

    public void inALinstLinst(ALinstLinst node)
    {
        defaultIn(node);
    }

    public void outALinstLinst(ALinstLinst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALinstLinst(ALinstLinst node)
    {
        inALinstLinst(node);
        if(node.getInst() != null)
        {
            node.getInst().apply(this);
        }
        if(node.getLinst() != null)
        {
            node.getLinst().apply(this);
        }
        outALinstLinst(node);
    }

    public void inALinstvideLinst(ALinstvideLinst node)
    {
        defaultIn(node);
    }

    public void outALinstvideLinst(ALinstvideLinst node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALinstvideLinst(ALinstvideLinst node)
    {
        inALinstvideLinst(node);
        outALinstvideLinst(node);
    }

    public void inASinonInstsi(ASinonInstsi node)
    {
        defaultIn(node);
    }

    public void outASinonInstsi(ASinonInstsi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASinonInstsi(ASinonInstsi node)
    {
        inASinonInstsi(node);
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getInstbloc() != null)
        {
            node.getInstbloc().apply(this);
        }
        if(node.getInstsinon() != null)
        {
            node.getInstsinon().apply(this);
        }
        outASinonInstsi(node);
    }

    public void inASiInstsi(ASiInstsi node)
    {
        defaultIn(node);
    }

    public void outASiInstsi(ASiInstsi node)
    {
        defaultOut(node);
    }

    @Override
    public void caseASiInstsi(ASiInstsi node)
    {
        inASiInstsi(node);
        if(node.getSi() != null)
        {
            node.getSi().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getAlors() != null)
        {
            node.getAlors().apply(this);
        }
        if(node.getInstbloc() != null)
        {
            node.getInstbloc().apply(this);
        }
        outASiInstsi(node);
    }

    public void inAInstsinon(AInstsinon node)
    {
        defaultIn(node);
    }

    public void outAInstsinon(AInstsinon node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstsinon(AInstsinon node)
    {
        inAInstsinon(node);
        if(node.getSinon() != null)
        {
            node.getSinon().apply(this);
        }
        if(node.getInstbloc() != null)
        {
            node.getInstbloc().apply(this);
        }
        outAInstsinon(node);
    }

    public void inAInsttantque(AInsttantque node)
    {
        defaultIn(node);
    }

    public void outAInsttantque(AInsttantque node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInsttantque(AInsttantque node)
    {
        inAInsttantque(node);
        if(node.getTantque() != null)
        {
            node.getTantque().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getFaire() != null)
        {
            node.getFaire().apply(this);
        }
        if(node.getInstbloc() != null)
        {
            node.getInstbloc().apply(this);
        }
        outAInsttantque(node);
    }

    public void inAInstappel(AInstappel node)
    {
        defaultIn(node);
    }

    public void outAInstappel(AInstappel node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstappel(AInstappel node)
    {
        inAInstappel(node);
        if(node.getAppelf() != null)
        {
            node.getAppelf().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstappel(node);
    }

    public void inAInstretour(AInstretour node)
    {
        defaultIn(node);
    }

    public void outAInstretour(AInstretour node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstretour(AInstretour node)
    {
        inAInstretour(node);
        if(node.getRetour() != null)
        {
            node.getRetour().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstretour(node);
    }

    public void inAInstecriture(AInstecriture node)
    {
        defaultIn(node);
    }

    public void outAInstecriture(AInstecriture node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstecriture(AInstecriture node)
    {
        inAInstecriture(node);
        if(node.getEcrire() != null)
        {
            node.getEcrire().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstecriture(node);
    }

    public void inAInstvide(AInstvide node)
    {
        defaultIn(node);
    }

    public void outAInstvide(AInstvide node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstvide(AInstvide node)
    {
        inAInstvide(node);
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstvide(node);
    }

    public void inAInstincr(AInstincr node)
    {
        defaultIn(node);
    }

    public void outAInstincr(AInstincr node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInstincr(AInstincr node)
    {
        inAInstincr(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        if(node.getInc() != null)
        {
            node.getInc().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getPointVirgule() != null)
        {
            node.getPointVirgule().apply(this);
        }
        outAInstincr(node);
    }

    public void inAOuExp(AOuExp node)
    {
        defaultIn(node);
    }

    public void outAOuExp(AOuExp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAOuExp(AOuExp node)
    {
        inAOuExp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getOu() != null)
        {
            node.getOu().apply(this);
        }
        if(node.getT1() != null)
        {
            node.getT1().apply(this);
        }
        outAOuExp(node);
    }

    public void inAT1Exp(AT1Exp node)
    {
        defaultIn(node);
    }

    public void outAT1Exp(AT1Exp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAT1Exp(AT1Exp node)
    {
        inAT1Exp(node);
        if(node.getT1() != null)
        {
            node.getT1().apply(this);
        }
        outAT1Exp(node);
    }

    public void inAEtT1(AEtT1 node)
    {
        defaultIn(node);
    }

    public void outAEtT1(AEtT1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEtT1(AEtT1 node)
    {
        inAEtT1(node);
        if(node.getT1() != null)
        {
            node.getT1().apply(this);
        }
        if(node.getEt() != null)
        {
            node.getEt().apply(this);
        }
        if(node.getT2() != null)
        {
            node.getT2().apply(this);
        }
        outAEtT1(node);
    }

    public void inAT2T1(AT2T1 node)
    {
        defaultIn(node);
    }

    public void outAT2T1(AT2T1 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAT2T1(AT2T1 node)
    {
        inAT2T1(node);
        if(node.getT2() != null)
        {
            node.getT2().apply(this);
        }
        outAT2T1(node);
    }

    public void inAInfT2(AInfT2 node)
    {
        defaultIn(node);
    }

    public void outAInfT2(AInfT2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAInfT2(AInfT2 node)
    {
        inAInfT2(node);
        if(node.getT2() != null)
        {
            node.getT2().apply(this);
        }
        if(node.getInferieur() != null)
        {
            node.getInferieur().apply(this);
        }
        if(node.getT3() != null)
        {
            node.getT3().apply(this);
        }
        outAInfT2(node);
    }

    public void inAEgaleT2(AEgaleT2 node)
    {
        defaultIn(node);
    }

    public void outAEgaleT2(AEgaleT2 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAEgaleT2(AEgaleT2 node)
    {
        inAEgaleT2(node);
        if(node.getT2() != null)
        {
            node.getT2().apply(this);
        }
        if(node.getEgale() != null)
        {
            node.getEgale().apply(this);
        }
        if(node.getT3() != null)
        {
            node.getT3().apply(this);
        }
        outAEgaleT2(node);
    }

    public void inAT3T2(AT3T2 node)
    {
        defaultIn(node);
    }

    public void outAT3T2(AT3T2 node)
    {
        defaultOut(node);
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

    public void inAPlusT3(APlusT3 node)
    {
        defaultIn(node);
    }

    public void outAPlusT3(APlusT3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAPlusT3(APlusT3 node)
    {
        inAPlusT3(node);
        if(node.getT3() != null)
        {
            node.getT3().apply(this);
        }
        if(node.getPlus() != null)
        {
            node.getPlus().apply(this);
        }
        if(node.getT4() != null)
        {
            node.getT4().apply(this);
        }
        outAPlusT3(node);
    }

    public void inAMinusT3(AMinusT3 node)
    {
        defaultIn(node);
    }

    public void outAMinusT3(AMinusT3 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMinusT3(AMinusT3 node)
    {
        inAMinusT3(node);
        if(node.getT3() != null)
        {
            node.getT3().apply(this);
        }
        if(node.getMinus() != null)
        {
            node.getMinus().apply(this);
        }
        if(node.getT4() != null)
        {
            node.getT4().apply(this);
        }
        outAMinusT3(node);
    }

    public void inAT4T3(AT4T3 node)
    {
        defaultIn(node);
    }

    public void outAT4T3(AT4T3 node)
    {
        defaultOut(node);
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

    public void inAMultT4(AMultT4 node)
    {
        defaultIn(node);
    }

    public void outAMultT4(AMultT4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAMultT4(AMultT4 node)
    {
        inAMultT4(node);
        if(node.getT4() != null)
        {
            node.getT4().apply(this);
        }
        if(node.getMult() != null)
        {
            node.getMult().apply(this);
        }
        if(node.getT5() != null)
        {
            node.getT5().apply(this);
        }
        outAMultT4(node);
    }

    public void inADiviseT4(ADiviseT4 node)
    {
        defaultIn(node);
    }

    public void outADiviseT4(ADiviseT4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseADiviseT4(ADiviseT4 node)
    {
        inADiviseT4(node);
        if(node.getT4() != null)
        {
            node.getT4().apply(this);
        }
        if(node.getDivise() != null)
        {
            node.getDivise().apply(this);
        }
        if(node.getT5() != null)
        {
            node.getT5().apply(this);
        }
        outADiviseT4(node);
    }

    public void inAT5T4(AT5T4 node)
    {
        defaultIn(node);
    }

    public void outAT5T4(AT5T4 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAT5T4(AT5T4 node)
    {
        inAT5T4(node);
        if(node.getT5() != null)
        {
            node.getT5().apply(this);
        }
        outAT5T4(node);
    }

    public void inANonT5(ANonT5 node)
    {
        defaultIn(node);
    }

    public void outANonT5(ANonT5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANonT5(ANonT5 node)
    {
        inANonT5(node);
        if(node.getNon() != null)
        {
            node.getNon().apply(this);
        }
        if(node.getT5() != null)
        {
            node.getT5().apply(this);
        }
        outANonT5(node);
    }

    public void inATerT5(ATerT5 node)
    {
        defaultIn(node);
    }

    public void outATerT5(ATerT5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATerT5(ATerT5 node)
    {
        inATerT5(node);
        if(node.getCrochetOuvrant() != null)
        {
            node.getCrochetOuvrant().apply(this);
        }
        if(node.getT5() != null)
        {
            node.getT5().apply(this);
        }
        if(node.getCrochetFermant() != null)
        {
            node.getCrochetFermant().apply(this);
        }
        if(node.getPointIntero() != null)
        {
            node.getPointIntero().apply(this);
        }
        if(node.getT6() != null)
        {
            node.getT6().apply(this);
        }
        if(node.getPoints() != null)
        {
            node.getPoints().apply(this);
        }
        if(node.getT7() != null)
        {
            node.getT7().apply(this);
        }
        outATerT5(node);
    }

    public void inAT7T5(AT7T5 node)
    {
        defaultIn(node);
    }

    public void outAT7T5(AT7T5 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAT7T5(AT7T5 node)
    {
        inAT7T5(node);
        if(node.getT7() != null)
        {
            node.getT7().apply(this);
        }
        outAT7T5(node);
    }

    public void inAT6(AT6 node)
    {
        defaultIn(node);
    }

    public void outAT6(AT6 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAT6(AT6 node)
    {
        inAT6(node);
        if(node.getT7() != null)
        {
            node.getT7().apply(this);
        }
        outAT6(node);
    }

    public void inANombreT7(ANombreT7 node)
    {
        defaultIn(node);
    }

    public void outANombreT7(ANombreT7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseANombreT7(ANombreT7 node)
    {
        inANombreT7(node);
        if(node.getNombre() != null)
        {
            node.getNombre().apply(this);
        }
        outANombreT7(node);
    }

    public void inAAppelfT7(AAppelfT7 node)
    {
        defaultIn(node);
    }

    public void outAAppelfT7(AAppelfT7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAppelfT7(AAppelfT7 node)
    {
        inAAppelfT7(node);
        if(node.getAppelf() != null)
        {
            node.getAppelf().apply(this);
        }
        outAAppelfT7(node);
    }

    public void inAVarT7(AVarT7 node)
    {
        defaultIn(node);
    }

    public void outAVarT7(AVarT7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarT7(AVarT7 node)
    {
        inAVarT7(node);
        if(node.getVar() != null)
        {
            node.getVar().apply(this);
        }
        outAVarT7(node);
    }

    public void inAParT7(AParT7 node)
    {
        defaultIn(node);
    }

    public void outAParT7(AParT7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAParT7(AParT7 node)
    {
        inAParT7(node);
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAParT7(node);
    }

    public void inALireT7(ALireT7 node)
    {
        defaultIn(node);
    }

    public void outALireT7(ALireT7 node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALireT7(ALireT7 node)
    {
        inALireT7(node);
        if(node.getLire() != null)
        {
            node.getLire().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outALireT7(node);
    }

    public void inATabVar(ATabVar node)
    {
        defaultIn(node);
    }

    public void outATabVar(ATabVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseATabVar(ATabVar node)
    {
        inATabVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getCrochetOuvrant() != null)
        {
            node.getCrochetOuvrant().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getCrochetFermant() != null)
        {
            node.getCrochetFermant().apply(this);
        }
        outATabVar(node);
    }

    public void inAVarVar(AVarVar node)
    {
        defaultIn(node);
    }

    public void outAVarVar(AVarVar node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVarVar(AVarVar node)
    {
        inAVarVar(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        outAVarVar(node);
    }

    public void inALexpLexp(ALexpLexp node)
    {
        defaultIn(node);
    }

    public void outALexpLexp(ALexpLexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALexpLexp(ALexpLexp node)
    {
        inALexpLexp(node);
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLexpSuite() != null)
        {
            node.getLexpSuite().apply(this);
        }
        outALexpLexp(node);
    }

    public void inAVideLexp(AVideLexp node)
    {
        defaultIn(node);
    }

    public void outAVideLexp(AVideLexp node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLexp(AVideLexp node)
    {
        inAVideLexp(node);
        outAVideLexp(node);
    }

    public void inALsuiteLexpSuite(ALsuiteLexpSuite node)
    {
        defaultIn(node);
    }

    public void outALsuiteLexpSuite(ALsuiteLexpSuite node)
    {
        defaultOut(node);
    }

    @Override
    public void caseALsuiteLexpSuite(ALsuiteLexpSuite node)
    {
        inALsuiteLexpSuite(node);
        if(node.getVirgule() != null)
        {
            node.getVirgule().apply(this);
        }
        if(node.getExp() != null)
        {
            node.getExp().apply(this);
        }
        if(node.getLexpSuite() != null)
        {
            node.getLexpSuite().apply(this);
        }
        outALsuiteLexpSuite(node);
    }

    public void inAVideLexpSuite(AVideLexpSuite node)
    {
        defaultIn(node);
    }

    public void outAVideLexpSuite(AVideLexpSuite node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAVideLexpSuite(AVideLexpSuite node)
    {
        inAVideLexpSuite(node);
        outAVideLexpSuite(node);
    }

    public void inAAppelf(AAppelf node)
    {
        defaultIn(node);
    }

    public void outAAppelf(AAppelf node)
    {
        defaultOut(node);
    }

    @Override
    public void caseAAppelf(AAppelf node)
    {
        inAAppelf(node);
        if(node.getIdentif() != null)
        {
            node.getIdentif().apply(this);
        }
        if(node.getParentheseOuvrante() != null)
        {
            node.getParentheseOuvrante().apply(this);
        }
        if(node.getLexp() != null)
        {
            node.getLexp().apply(this);
        }
        if(node.getParentheseFermante() != null)
        {
            node.getParentheseFermante().apply(this);
        }
        outAAppelf(node);
    }
}
