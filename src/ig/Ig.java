package ig;

import fg.*;
import nasm.*;
import util.graph.*;
import util.intset.*;
import java.util.*;
import java.io.*;

public class Ig {
    public Graph graph;
    public FgSolution fgs;
    public int regNb;
    public Nasm nasm;
    public Node int2Node[];

    
    public Ig(FgSolution fgs){
	this.fgs = fgs;
 	this.graph = new Graph();
	this.nasm = fgs.nasm;
	this.regNb = this.nasm.getTempCounter();
	this.int2Node = new Node[regNb];
	this.build();
    }
	public static Set<List<Integer>> setCartisiantProduct(IntSet a, IntSet b) {
		Set<List<Integer>> product = new HashSet<>();

		for (int i = 0; i < a.getSize(); i++) {
			if (a.isMember(i)){
				for (int j = 0; j < b.getSize(); j++) {
					if (b.isMember(j)) product.add(List.of(i, j));
				}
			}
		}

		return product;
	}
    public void build(){
		for (int i = 0; i < regNb; i++) int2Node[i] = graph.newNode();

		for (NasmInst inst: nasm.sectionText) {
			//in Edge
			for (List<Integer> sommets : this.setCartisiantProduct(fgs.in.get(inst), fgs.in.get(inst))) {
				if (!sommets.get(0).equals(sommets.get(1))){
					Node from = int2Node[sommets.get(0)];
					Node to = int2Node[sommets.get(1)];
					graph.addNOEdge(from, to);
				}
			}
			//out Edge
			for (List<Integer> sommets : this.setCartisiantProduct(fgs.out.get(inst), fgs.out.get(inst))) {
				if (!sommets.get(0).equals(sommets.get(1))){
					Node from = int2Node[sommets.get(0)];
					Node to = int2Node[sommets.get(1)];
					graph.addNOEdge(from, to);
				}
			}
		}



	}

    public int[] getPrecoloredTemporaries() {
		int[] couleur = new int[regNb];
		NasmRegister r;
		for (NasmInst inst : nasm.sectionText) {
			if(inst.destination != null && inst.source != null) {
				if (inst.source.isGeneralRegister()) {
					r = (NasmRegister) inst.source;
					couleur[r.val] = r.color;
				}
				if (inst.destination.isGeneralRegister()) {
					r = (NasmRegister) inst.destination;
					couleur[r.val] = r.color;
				}
			}
		}
		return couleur;
	}

	private int getRegister(int color) {
		switch (color) {
			case 0:
				return Nasm.REG_EAX;
			case 1:
				return Nasm.REG_EBX;
			case 2:
				return Nasm.REG_ECX;
			case 3:
				return Nasm.REG_EDX;
			default:
				return -1;
		}
	}

    public void allocateRegisters(){
		int[] couleur = new ColorGraph(graph, 4, getPrecoloredTemporaries()).color;
		NasmRegister r;
		for (NasmInst inst : nasm.sectionText) {
			if (inst.destination != null && inst.source != null) {
				if (inst.source.isGeneralRegister()) {
					r = (NasmRegister) inst.source;
					r.colorRegister(getRegister(couleur[r.val]));
				}
				if (inst.destination.isGeneralRegister()) {
					r = (NasmRegister) inst.destination;
					r.colorRegister(getRegister(couleur[r.val]));
				}
			}
		}
	}


    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;
	
	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".ig";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	for(int i = 0; i < regNb; i++){
	    Node n = this.int2Node[i];
	    out.print(n + " : ( ");
	    for(NodeList q=n.succ(); q!=null; q=q.tail) {
		out.print(q.head.toString());
		out.print(" ");
	    }
	    out.println(")");
	}
    }
}
	    
    

    
    
