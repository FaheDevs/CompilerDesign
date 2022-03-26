package fg;
import nasm.*;
import util.graph.Node;
import util.graph.NodeList;
import util.intset.*;
import java.io.*;
import java.util.*;

public class FgSolution{
    int iterNum = 0;
    public Nasm nasm;
    Fg fg;
    public Map< NasmInst, IntSet> use;
    public Map< NasmInst, IntSet> def;
    public Map< NasmInst, IntSet> in;
    public Map< NasmInst, IntSet> out;
    
    public FgSolution(Nasm nasm, Fg fg){
	this.nasm = nasm;
	this.fg = fg;
	this.use = new HashMap< NasmInst, IntSet>();
	this.def = new HashMap< NasmInst, IntSet>();
	this.in =  new HashMap< NasmInst, IntSet>();
	this.out = new HashMap< NasmInst, IntSet>();
    }
    
    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;

	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".fgs";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	out.println("iter num = " + iterNum);
	for(NasmInst nasmInst : this.nasm.sectionText){
	    out.println("use = "+ this.use.get(nasmInst) + " def = "+ this.def.get(nasmInst) + "\tin = " + this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
	}
	
    }

    public void FgSolution(Nasm nasm, Fg fg)
    {
		this.nasm = nasm;
		this.fg = fg;

		defUseSets();
		inOutSet();
    }
	private void defUseSets() {
		for (NasmInst inst : nasm.sectionText) {
			defSet(inst);
			useSet(inst);
		}
	}
	private void defSet(NasmInst inst) {
		IntSet defSet = new IntSet(nasm.sectionText.size());
		if (inst.srcDef) addOperand(defSet, inst.source);
		if (inst.destDef) addOperand(defSet, inst.destination);
		def.put(inst, defSet);
	}

	private void useSet(NasmInst inst) {
		IntSet useSet = new IntSet(nasm.sectionText.size());
		if (inst.srcUse) addOperand(useSet, inst.source);
		if (inst.destUse) addOperand(useSet, inst.destination);
		use.put(inst, useSet);
	}
	private void addOperand(IntSet set, NasmOperand operand) {
		if (operand != null) {
			if (operand instanceof NasmAddress) {
				NasmAddress address = (NasmAddress) operand;
				addOperand(set, address.base);
				addOperand(set, address.offset);
			}
			if (operand.isGeneralRegister()) {
				NasmRegister register = (NasmRegister) operand;
				set.add(register.val);
			}
		}
	}

	private void inOutSet() {
		//Set vide.
		for (NasmInst inst : nasm.sectionText) {
			in.put(inst, new IntSet(nasm.sectionText.size()));
			out.put(inst, new IntSet(nasm.sectionText.size()));
		}

		boolean egaux = false;
		while (!egaux) {
			egaux = true;
			iterNum++;
			for (NasmInst inst : nasm.sectionText) {
				IntSet oldIn = in.get(inst).copy();
				IntSet oldOut = out.get(inst).copy();
				IntSet newIn = newIn(inst);
				in.put(inst, newIn);
				IntSet newOut = newOut(inst);
				out.put(inst, newOut);
				if (!oldIn.equal(newIn) || !oldOut.equal(newOut))
					egaux = false;
			}
		}
	}
	private IntSet newIn(NasmInst inst) {
		IntSet out = this.out.get(inst);
		IntSet def = this.def.get(inst);
		IntSet use = this.use.get(inst);
		return use.copy().union(out.copy().minus(def));
	}
	private IntSet newOut(NasmInst inst) {
		Node instNode = fg.inst2Node.get(inst);
		IntSet out = new IntSet(nasm.sectionText.size());
		NodeList node = instNode.succ();
		while(node != null){
			NasmInst nodeInst = fg.node2Inst.get(node.head);
			out.union(in.get(nodeInst));
			node = instNode.succ();
		}
		return out;
	}
}
