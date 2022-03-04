package ts;

import sa.*;

public class Sa2ts extends SaDepthFirstVisitor<Void> {
    enum Context {LOCAL, GLOBAL, PARAM;
        public boolean isGlobal(){return this == GLOBAL;}
        public boolean isLocal(){ return this == LOCAL;}
        public boolean isParam(){ return this == PARAM;}
    }

    private Ts tableGlobale;
    private Ts tableLocaleCourante;
    private Context context;
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
        else node.tsItem = Tablecourante.addVar(identif, 1);

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
        if(context== Context.LOCAL || context== Context.PARAM){
            if(tableLocaleCourante.getVar(identif) == null ) {
                System.err.println("la variable référencée n'existe pas");
                System.exit(1);
            }
        }
        if (context == Context.GLOBAL) {
            if(tableGlobale.getVar(identif) == null){
                System.err.println("la variable référencée n'existe pas");
                System.exit(1);
            }
        }

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
        String ideontifFonction = node.getNom();
        defaultIn(node);
        if (tableGlobale.getFct(ideontifFonction) != null){
            System.err.println("il existe une fonction du meme nom");
            System.exit(1);
        }
        tableLocaleCourante = new Ts();
        int nbArgs;
        if (node.getParametres() == null) nbArgs = 0;
        else nbArgs = node.getParametres().length();
        tableGlobale.addFct(ideontifFonction, nbArgs, tableLocaleCourante, node);

        context = Context.PARAM;
        if(node.getParametres()!= null) node.getParametres().accept(this);

        context = Context.LOCAL;
        if(node.getVariable()!=null) node.getVariable().accept(this);
        if(node.getCorps()!=null) node.getCorps().accept(this);
        context = Context.GLOBAL;

        defaultOut(node);
        return null;
}
// Appele de fonctions
    public Void visit(SaAppel node) {
        String idontifFonction = node.getNom();
        defaultIn(node);
        if(tableGlobale.getFct(idontifFonction) == null){
            System.err.println("la fonction appelée n'existe pas");
            System.exit(1);
        }
        if(node.getArguments() != null) node.getArguments().accept(this);

        defaultOut(node);
        return null;
    }
}
