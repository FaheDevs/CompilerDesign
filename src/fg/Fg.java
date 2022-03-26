package fg;
import nasm.*;
import util.graph.*;
import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor <Void> {
    public Nasm nasm;
    public Graph graph;
    Map< NasmInst, Node> inst2Node;
    Map< Node, NasmInst> node2Inst;
    Map< String, NasmInst> label2Inst;
    private Node[] nodeArray;

    public Fg(Nasm nasm){
	this.nasm = nasm;
	this.inst2Node = new HashMap< NasmInst, Node>();
	this.node2Inst = new HashMap< Node, NasmInst>();
	this.label2Inst = new HashMap< String, NasmInst>();
	this.graph = new Graph();

	for(NasmInst nasmInst : nasm.sectionText){
	    //	    System.out.println("<" + nasmInst.getClass().getSimpleName() + ">");
	    if(nasmInst.label != null) this.label2Inst.put(((NasmLabel)nasmInst.label).val, nasmInst);
	    Node n = this.graph.newNode();
	    this.inst2Node.put(nasmInst, n);
	    this.node2Inst.put(n, nasmInst);
	}

	int instNb = nasm.sectionText.size();
	for (int i = 0; i < instNb; i++) {
	    NasmInst nasmInst = nasm.sectionText.get(i);
	    //	    System.out.println("<" + nasmInst.getClass().getSimpleName() + ">");
	    if(nasmInst instanceof NasmJmp){
		this.graph.addEdge(this.inst2Node.get(nasmInst), this.inst2Node.get(this.label2Inst.get(((NasmLabel)((NasmJmp)nasmInst).address).val)));
		continue;
	    }
	    
	}
    nodeArray = graph.nodeArray();
    nasm.sectionText.forEach(i -> i.accept(this));
    }


    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;

	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".fg";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	for(NasmInst nasmInst : nasm.sectionText){
	    Node n = this.inst2Node.get(nasmInst);
	    out.print(n + " : ( ");
	    for(NodeList q=n.succ(); q!=null; q=q.tail) {
		out.print(q.head.toString());
		out.print(" ");
	    }
	    out.println(")\t" + nasmInst);
	}
	
    }
    //Etape 02   Création des arcs du graphe.
    private void addEdge(NasmInst inst) {
        int instCurrent = nasm.sectionText.indexOf(inst);
        int nextInst = instCurrent + 1;

        if (nextInst < graph.nodeCount()) {
            Node instCurrentNode = nodeArray[instCurrent];
            Node nextInstNode = nodeArray[nextInst];
            graph.addEdge(instCurrentNode, nextInstNode);
        }
    }
    private void addEdgeToLabel(NasmInst inst) {
        int instCurrent = nasm.sectionText.indexOf(inst);

        String label = inst.address.toString();
        NasmInst instLabel = label2Inst.get(label);

        Node instCurrentNode = nodeArray[instCurrent];
        Node instLabelNode = inst2Node.get(instLabel);

        // The label may not exist in the source code ; for example the call  to 'iprintLF' is valid, but the method
        // is defined in another file that is imported.
        if (instLabelNode != null)  graph.addEdge(instCurrentNode, instLabelNode);
    }

    public Void visit(NasmAdd inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmCall inst){
        addEdgeToLabel(inst);
        return null;
    }
    public Void visit(NasmDiv inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmJe inst){
        addEdgeToLabel(inst);
        addEdge(inst);
        return null;
    }
    public Void visit(NasmJle inst){
        addEdgeToLabel(inst);
        addEdge(inst);
        return null;
    }
    public Void visit(NasmJne inst){
        addEdgeToLabel(inst);
        addEdge(inst);
        return null;
    }
    public Void visit(NasmMul inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmOr inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmCmp inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmInst inst) {
        addEdge(inst);
        return null;
    }
    public Void visit(NasmJge inst){
        addEdgeToLabel(inst);
        addEdge(inst);
        return null;
    }
    public Void visit(NasmJl inst){
        addEdgeToLabel(inst);
        addEdge(inst);
        return null;
    }
    public Void visit(NasmNot inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmPop inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmRet inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmXor inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmAnd inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmJg inst){
        addEdgeToLabel(inst);
        addEdge(inst);
        return null;
    }
    public Void visit(NasmJmp inst){
        addEdgeToLabel(inst);
        return null;
    }
    public Void visit(NasmMov inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmPush inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmSub inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmEmpty inst){
        addEdge(inst);
        return null;
    }
    public Void visit(NasmInt inst){
        addEdge(inst);
        return null;
    }

    public Void visit(NasmAddress operand){

        return null;
    }
    public Void visit(NasmConstant operand){return null;}
    public Void visit(NasmLabel operand){return null;}
    public Void visit(NasmRegister operand){return null;}

    public Void visit(NasmResb pseudoInst){return null;}
    public Void visit(NasmResw pseudoInst){return null;}
    public Void visit(NasmResd pseudoInst){return null;}
    public Void visit(NasmResq pseudoInst){return null;}
    public Void visit(NasmRest pseudoInst){return null;}

}
