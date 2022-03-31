package ig;

import fg.*;
import nasm.*;
import util.graph.*;
import util.intset.*;
import java.util.*;
import java.io.*;
import java.util.stream.Stream;

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
	private void colorat(int[] colors, NasmOperand operand) {
		if (operand == null) return;
		if (operand instanceof NasmAddress) {
			NasmAddress address = (NasmAddress) operand;
			colorat(colors, address.base);
			colorat(colors, address.offset);
		}
		if (operand.isGeneralRegister()) {
			NasmRegister register = (NasmRegister) operand;
			colors[register.val] = register.color;
		}
	}

    public int[] getPrecoloredTemporaries() {
		int[] couleur = new int[regNb];
		nasm.sectionText.stream()
				.flatMap(instruction -> Stream.of(instruction.source, instruction.destination))
				.forEach(operand -> colorat(couleur, operand));
		return couleur;

	}


    public void allocateRegisters(){
		int[] couleur = new ColorGraph(graph, 4, getPrecoloredTemporaries()).color;
		for (NasmInst inst: nasm.sectionText) {
			allocateRegister(couleur, inst.source);
			allocateRegister(couleur, inst.destination);
		}

	}
	private void allocateRegister(int[] colors, NasmOperand operand) {
		if (operand == null) return;

		if (operand instanceof NasmAddress) {
			NasmAddress address = (NasmAddress) operand;
			allocateRegister(colors, address.base);
			allocateRegister(colors, address.offset);
		}

		if (operand.isGeneralRegister()){
			NasmRegister register = (NasmRegister) operand;
			if (register.color == Nasm.REG_UNK) register.colorRegister(colors[register.val]);
		}

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
	    
    

    
    
