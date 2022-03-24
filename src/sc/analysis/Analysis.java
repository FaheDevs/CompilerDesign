/* This file was generated by SableCC (http://www.sablecc.org/). */

package sc.analysis;

import sc.node.*;

public interface Analysis extends Switch
{
    Object getIn(Node node);
    void setIn(Node node, Object o);
    Object getOut(Node node);
    void setOut(Node node, Object o);

    void caseStart(Start node);
    void caseALdfDvglobalsProgramme(ALdfDvglobalsProgramme node);
    void caseALdfProgramme(ALdfProgramme node);
    void caseAOptdvOptdv(AOptdvOptdv node);
    void caseALdvLdv(ALdvLdv node);
    void caseADvLdv(ADvLdv node);
    void caseASuiteLdvLdvsuite(ASuiteLdvLdvsuite node);
    void caseASuiteDvLdvsuite(ASuiteDvLdvsuite node);
    void caseAVarDv(AVarDv node);
    void caseATableauDv(ATableauDv node);
    void caseALdfLdf(ALdfLdf node);
    void caseALdfVideLdf(ALdfVideLdf node);
    void caseADfDf(ADfDf node);
    void caseADfSansvariablesDf(ADfSansvariablesDf node);
    void caseASansLparam(ASansLparam node);
    void caseAAvecLparam(AAvecLparam node);
    void caseAInstaffectInst(AInstaffectInst node);
    void caseAInstblocInst(AInstblocInst node);
    void caseAInstsiInst(AInstsiInst node);
    void caseAInsttantqueInst(AInsttantqueInst node);
    void caseAInstappelInst(AInstappelInst node);
    void caseAInstretourInst(AInstretourInst node);
    void caseAInstecritureInst(AInstecritureInst node);
    void caseAInstvideInst(AInstvideInst node);
    void caseAInstaffect(AInstaffect node);
    void caseAInstbloc(AInstbloc node);
    void caseALinstLinst(ALinstLinst node);
    void caseALinstvideLinst(ALinstvideLinst node);
    void caseASinonInstsi(ASinonInstsi node);
    void caseASiInstsi(ASiInstsi node);
    void caseAInstsinon(AInstsinon node);
    void caseAInsttantque(AInsttantque node);
    void caseAInstappel(AInstappel node);
    void caseAInstretour(AInstretour node);
    void caseAInstecriture(AInstecriture node);
    void caseAInstvide(AInstvide node);
    void caseAOuExp(AOuExp node);
    void caseAT1Exp(AT1Exp node);
    void caseAEtT1(AEtT1 node);
    void caseAT2T1(AT2T1 node);
    void caseAInfT2(AInfT2 node);
    void caseAEgaleT2(AEgaleT2 node);
    void caseAT3T2(AT3T2 node);
    void caseAPlusT3(APlusT3 node);
    void caseAMinusT3(AMinusT3 node);
    void caseAT4T3(AT4T3 node);
    void caseAMultT4(AMultT4 node);
    void caseADiviseT4(ADiviseT4 node);
    void caseAT5T4(AT5T4 node);
    void caseANonT5(ANonT5 node);
    void caseAT6T5(AT6T5 node);
    void caseANombreT6(ANombreT6 node);
    void caseAAppelfT6(AAppelfT6 node);
    void caseAVarT6(AVarT6 node);
    void caseAParT6(AParT6 node);
    void caseALireT6(ALireT6 node);
    void caseATabVar(ATabVar node);
    void caseAVarVar(AVarVar node);
    void caseALexpLexp(ALexpLexp node);
    void caseAVideLexp(AVideLexp node);
    void caseALsuiteLexpSuite(ALsuiteLexpSuite node);
    void caseAVideLexpSuite(AVideLexpSuite node);
    void caseAAppelf(AAppelf node);

    void caseTEspaces(TEspaces node);
    void caseTCommentaire(TCommentaire node);
    void caseTVirgule(TVirgule node);
    void caseTDivise(TDivise node);
    void caseTPointVirgule(TPointVirgule node);
    void caseTMult(TMult node);
    void caseTMinus(TMinus node);
    void caseTParentheseOuvrante(TParentheseOuvrante node);
    void caseTParentheseFermante(TParentheseFermante node);
    void caseTCrochetOuvrant(TCrochetOuvrant node);
    void caseTCrochetFermant(TCrochetFermant node);
    void caseTAccoladeOuvrante(TAccoladeOuvrante node);
    void caseTAccoladeFermante(TAccoladeFermante node);
    void caseTEgale(TEgale node);
    void caseTInferieur(TInferieur node);
    void caseTEt(TEt node);
    void caseTOu(TOu node);
    void caseTNon(TNon node);
    void caseTPlus(TPlus node);
    void caseTSi(TSi node);
    void caseTAlors(TAlors node);
    void caseTSinon(TSinon node);
    void caseTTantque(TTantque node);
    void caseTFaire(TFaire node);
    void caseTType(TType node);
    void caseTRetour(TRetour node);
    void caseTLire(TLire node);
    void caseTEcrire(TEcrire node);
    void caseTNombre(TNombre node);
    void caseTIdentif(TIdentif node);
    void caseEOF(EOF node);
    void caseInvalidToken(InvalidToken node);
}