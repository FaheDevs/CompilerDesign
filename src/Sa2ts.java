import sa.*;
import ts.Ts;

import java.util.ArrayList;
import java.util.List;

public class Sa2ts extends SaDepthFirstVisitor<Void> {
    enum Context {LOCAL, GLOBAL, PARAM;
        public boolean isGlobal(){return this == GLOBAL;}
        public boolean isLocal(){ return this == LOCAL;}
        public boolean isParam(){ return this == PARAM;}
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
        while (v != null && isInParam == false) {
            //System.out.println(tableLocaleCourante.variables.get(p.getTete().getNom()));
            isInParam = parametres.contains(v.getTete().getNom());
            //isInParam = tableLocaleCourante.variables.containsKey(p.getTete().getNom());
            v = v.getQueue();
        }
        return isInParam;
    }
//Créaion de la table des symboles
    public Sa2ts(SaNode racine){
        tableGlobale = new Ts();
        context= Context.GLOBAL;
        racine.accept(this);
    }

    public Ts getTableGlobale() {
        return tableGlobale;
    }
    public Ts getTableLocalCourante() {
        return tableLocaleCourante;
    }
    public Context getContext() {
        return context;
    }

// Déclaration de variables
    // Déclaration de variables
    public Void visit(SaDecVar node) {
        Ts Tablecourante = null;
        String identif = node.getNom();
        defaultIn(node);
        if (context.isLocal()) {
            Tablecourante = tableLocaleCourante;
        }
        else Tablecourante = tableGlobale;

        if (Tablecourante.getVar(identif) != null) {
            System.err.println("il ya une variable du même nom");
            System.exit(1);
        }
        else if(context.isParam()) node.tsItem = Tablecourante.addParam(identif);
        else {
            node.tsItem = Tablecourante.addVar(identif, 1);
        }

        defaultOut(node);
        return null;
    }
    // Déclaration de Tableaux
    public Void visit(SaDecTab node) {
        Ts Tablecourante = null;
        int tab_length = node.getTaille();
        String identif = node.getNom();
        defaultIn(node);
       /* if (context.isLocal()) {
            Tablecourante = tableLocaleCourante;
        }
        else Tablecourante = tableGlobale;*/
        Tablecourante = tableGlobale;
        if (Tablecourante.getVar(identif) != null) {
            System.err.println("il existe déja un tab  du même nom");
            System.exit(1);
        }
        else if(context.isParam())  node.tsItem = Tablecourante.addParam(identif);
        else node.tsItem = Tablecourante.addVar(identif,tab_length);

        defaultOut(node);
        return null;
    }
// Appel Var
    //Var Simple
    public Void visit(SaVarSimple node) {
        String identif = node.getNom();
        defaultIn(node);
        /*if(context == Context.LOCAL || context == Context.PARAM){
            if(tableLocaleCourante.getVar(identif) == null) {
                System.out.println("dz");
                System.err.println("la variable référencée n'existe pas");
                System.exit(1);
            }
        }*/;
        System.out.println(tableGlobale.getVar(identif) == null);
        if(context == Context.GLOBAL && tableGlobale.getVar(identif) == null){
            System.err.println("la variable référencée n'existe pas");
            System.exit(1);
        }
        System.out.println(tableLocaleCourante.getVar(identif) == null);
        if((context == Context.LOCAL || context == Context.PARAM) && (tableLocaleCourante.getVar(identif) == null && tableGlobale.getVar(identif) == null)) {
            System.out.println("dz");
            System.err.println("la variable référencée n'existe pas");
            System.exit(1);
        }
        /*if (context == Context.GLOBAL) {
            if(tableGlobale.getVar(identif) == null){
                System.err.println("la variable référencée n'existe pas");
                System.exit(1);
            }
        }*/

        defaultOut(node);
        return null;
    }
    //Var Indicee
    public Void visit(SaVarIndicee node) {
        String identif = node.getNom();
        defaultIn(node);
        if(tableGlobale.getVar(identif) == null) {
            System.err.println("la variable référencée n'existe pas");
            System.exit(1);
        }
        if (node.getIndice() == null){
            System.err.println("l'indice de la variable est manquante");
            System.exit(1);
        }

        defaultOut(node);
        return null;
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
        return null;
}
// Appele de fonctions
    public Void visit(SaAppel node) {
        String identifFonction = node.getNom();
        Integer nbArguments = null;
        if (node.getArguments() == null){
            nbArguments = 0;
        }
        else if (node.getArguments() != null){
            nbArguments = (Integer)node.getArguments().length();
        }
        defaultIn(node);
        if(tableGlobale.getFct(identifFonction) == null){
            System.err.println("la fonction appelée n'existe pas");
            System.exit(1);
        }

        if(node.getArguments() != null && (tableGlobale.getFct(identifFonction).getNbArgs() == nbArguments)){
            System.out.println("n n");
            node.getArguments().accept(this);
        }
        if(node.getArguments() == null && (tableGlobale.getFct(identifFonction).getNbArgs() == nbArguments)){
            //node.getArguments().accept(this);
        }
        else if (tableGlobale.getFct(identifFonction).getNbArgs() != nbArguments){
            System.err.println("Le nombre des arguments incopatible.");
            System.exit(1);
        }
        defaultOut(node);
        return null;
    }
}
