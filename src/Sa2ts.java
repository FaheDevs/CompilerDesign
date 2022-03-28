import sa.*;
import ts.Ts;
import ts.TsItemVar;

import java.util.ArrayList;
import java.util.List;

public class Sa2ts extends SaDepthFirstVisitor<Void> {
    enum Context {LOCAL, GLOBAL, PARAM;
        public boolean isGlobal(){return this == GLOBAL;}
        public boolean isLocal(){return this == LOCAL;}
        public boolean isParam(){return this == PARAM;}
    }

    private Ts tableGlobale;
    private Ts tableLocaleCourante;
    private Context context;
    private List<String> addParam(SaLDec param){
        List<String> parametres = new ArrayList<>();
        SaLDec p = param;
        while (p != null) {
            //System.out.println(tableLocaleCourante.variables.get(p.getTete().getNom()));
            parametres.add(p.getTete().getNom());
            //isInParam = tableLocaleCourante.variables.containsKey(p.getTete().getNom());
            p = p.getQueue();
        }
        return parametres;
    }
    private boolean isInParam(SaLDec var, List<String> parametres){
        boolean isInParam = false;
        SaLDec v = var;
        while (v != null && !isInParam) {
            //System.out.println(tableLocaleCourante.variables.get(p.getTete().getNom()));
            isInParam = parametres.contains(v.getTete().getNom());
            //isInParam = tableLocaleCourante.variables.containsKey(p.getTete().getNom());
            v = v.getQueue();
        }
        return isInParam;
    }

    private void mainExists() {
        if (!tableGlobale.fonctions.containsKey("main")) {
            System.err.println("La fonction main n'existe pas");
            System.exit(1);
        }
    }
//Créaion de la table des symboles
    public Sa2ts(SaNode racine){
        tableGlobale = new Ts();
        tableLocaleCourante = null;
        context= Context.GLOBAL;
        visit((SaProg) racine);
        mainExists();
    }

    public Ts getTableGlobale() {
        return tableGlobale;
    }

// Déclaration de variables et de Tableaux
    // Déclaration de Tableaux
    public Void visit(SaDecTab node) {
        int tab_length = node.getTaille();
        String identif = node.getNom();
        defaultIn(node);
        if (tableGlobale.getVar(identif) != null) {
            System.err.println("il existe déja un tab  du même nom");
            System.exit(1);
        }
        else if(context.isParam())  node.tsItem = tableLocaleCourante.addParam(identif);
        else node.tsItem = tableGlobale.addVar(identif,tab_length*4);

        defaultOut(node);

        return super.visit(node);
    }
    // Déclaration de variables
    public Void visit(SaDecVar node) {
        Ts tablecourante = tableGlobale;
        String identif = node.getNom();
        defaultIn(node);
        if (context.isLocal()) {
            tablecourante = tableLocaleCourante;
        }

        if (tablecourante.getVar(identif) == null && context.isParam()) {
            node.tsItem = tableLocaleCourante.addParam(identif);
        }
        else if (tablecourante.getVar(identif) != null){
            System.err.println("il ya une variable du même nom");
            System.exit(1);
        }
        else{
            node.tsItem = tablecourante.addVar(identif, 4);
        }

        defaultOut(node);
        return super.visit(node);
    }
// Appel Var
    //Var Simple
    public Void visit(SaVarSimple node) {
        Ts tablecourante = tableGlobale;
        String identif = node.getNom();
        defaultIn(node);
        /*if (context.isLocal()) {
            tablecourante = tableLocaleCourante;
        }
        if(context == Context.GLOBAL && tableGlobale.getVar(identif) == null){
            System.err.println("la variable référencée n'existe pas");
            System.exit(1);
        }
        if((context == Context.LOCAL || context == Context.PARAM) && (tableLocaleCourante.getVar(identif) == null && tableGlobale.getVar(identif) == null)) {
            System.err.println("la variable référencée n'existe pas");
            System.exit(1);
        }
        else node.tsItem = tablecourante.variables.get(identif);*/
        TsItemVar variable = tableLocaleCourante.variables.get(identif);
        if (variable == null) variable = tableGlobale.variables.get(identif);
        if (variable == null) {
            System.err.println("la variable référencée n'existe pas");
            System.exit(1);
        }
        node.tsItem = variable;
        defaultOut(node);
        return super.visit(node);
    }
    //Var Indicee
    public Void visit(SaVarIndicee node) {
        String identif = node.getNom();
        defaultIn(node);
        TsItemVar variable = tableLocaleCourante.variables.get(identif);
        if (variable == null) variable = tableGlobale.variables.get(identif);
        if (variable == null) {
            System.err.println("la variable référencée n'existe pas");
            System.exit(1);
        }
        node.tsItem = variable;
        defaultOut(node);
        return super.visit(node);
    }
// Déclaration de fonctions
    public Void visit(SaDecFonc node) {
        String identifFonction = node.getNom();
        List<String> lp = new ArrayList<>();
        defaultIn(node);
        if (tableGlobale.getFct(identifFonction) != null){
            System.err.println("il existe une fonction du meme nom");
            System.exit(1);
        }
        tableLocaleCourante = new Ts();
        int nbArgs;
        if (node.getParametres() == null) nbArgs = 0;
        else nbArgs = node.getParametres().length();
        tableGlobale.addFct(identifFonction, nbArgs, tableLocaleCourante, node);
        context = Context.PARAM;
        if(node.getParametres() != null){
            node.getParametres().accept(this);
            lp = addParam(node.getParametres());
        }
        context = Context.LOCAL;
        //System.out.println(isInParam(node.getVariable(), lp));
        if(node.getVariable() != null && !isInParam(node.getVariable(), lp)){
            node.getVariable().accept(this);
            System.out.println("eee");
        }
        else if (node.getVariable() != null && isInParam(node.getVariable(), lp)){
            System.err.println("il existe un parametre du meme nom");
            System.exit(1);
        }
        if(node.getCorps()!=null) {
            node.getCorps().accept(this);
        }
        context = Context.GLOBAL;
        defaultOut(node);
        return super.visit(node);
}
// Appele de fonctions
    public Void visit(SaAppel node) {
        String identifFonction = node.getNom();
        Integer nbArguments = 0;

        if (node.getArguments() != null){
            nbArguments = (Integer)node.getArguments().length();
        }
        defaultIn(node);
        if(tableGlobale.getFct(identifFonction) == null){
            System.err.println("la fonction appelée n'existe pas");
            System.exit(1);
        }

        if(node.getArguments() != null && (tableGlobale.getFct(identifFonction).getNbArgs() == nbArguments)){
            node.getArguments().accept(this);
        }
        else if (tableGlobale.getFct(identifFonction).getNbArgs() != nbArguments){
            System.err.println("Le nombre des arguments incopatible.");
            System.exit(1);
        }
        node.tsItem = tableGlobale.fonctions.get(identifFonction);
        defaultOut(node);
        return super.visit(node);
    }
}
