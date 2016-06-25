package sprocl.model;

import static sprocl.model.OpClaz.COMMENT;
import static sprocl.model.OpClaz.CONTROL;
import static sprocl.model.OpClaz.NORMAL;
import static sprocl.model.Operand.Type.LABEL;
import static sprocl.model.Operand.Type.NUM;
import static sprocl.model.Operand.Type.REG;
import static sprocl.model.Operand.Type.STR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Code defining the type of a (non-control flow) operation.
 * @author Arend Rensink
 */
public enum OpCode {

	//All the compute operations. They all need 2 registers.
	computeINCR(2, REG, REG, REG),
	computeDECR(2, REG, REG, REG),
	computeADD(2, REG, REG, REG),
	computeSUB(2, REG, REG, REG),
	computeMUL(2, REG, REG, REG),
	computeEQUAL(2, REG, REG, REG),
	computeNEQ(2,  REG, REG, REG),
	computeGT(2, REG, REG, REG),
	computeGTE(2, REG, REG, REG),
	computeLT(2, REG, REG, REG),
	computeLTE(2, REG, REG, REG),
	computeAND(2, REG, REG, REG),
	computeOR(2, REG, REG, REG),
	computeLSHIFT(2, REG, REG, REG),
	computeRSHIFT(2, REG, REG, REG),
	computeXOR(2, REG, REG, REG),

	//The load functions
	loadCONST(1, NUM, REG),
	loadDIRA(1, REG, REG),
	loadINDA(1, REG, REG),
	//TODO: Load (Defer p) toReg

	//The jump statements
	jumpABS(CONTROL, 0, NUM),
	jumpREL(CONTROL, 0, NUM),
	jumpIND(CONTROL, 0, REG),
	jumpLABEL(CONTROL, 0, NUM),

	//The branch statements
	branchABS(CONTROL, 0, REG, NUM),
	branchREL(CONTROL, 0, REG, NUM),
	branchIND(CONTROL, 0, REG, REG),

	//The store statements
	storeCONST(1, NUM, REG),
	storeDIRA(1,REG,REG),
	storeINDA(1,REG,REG),

	//The stack operations
	push(1, REG),
	pop(0, REG),

	//I DONT KNOW WHAT THIS DOES. TODO: Figure this out
	receive(0,REG),

	//All the read functions
	readDIRA(1,REG),
	readINDA(1,REG),

	testAndSetDIRA(1,REG),
	testAndSetINDA(1,REG),

	writeDIRA(2,REG,REG),
	writeINDA(2,REG,REG);



	/** The class that this opcode falls into. */
	private final OpClaz claz;

	/** The source operand types. */
	private final List<Operand.Type> sourceSig;

	/** The target operand types. */
	private final List<Operand.Type> targetSig;

	/** The operand types. */
	private final List<Operand.Type> sig;


	private OpCode(int sourceCount, Operand.Type... sig) {
		this(NORMAL, sourceCount, sig);
	}

	private OpCode(OpClaz claz, int sourceCount, Operand.Type... sig) {
		this.claz = claz;
		this.sourceSig = new ArrayList<>(sourceCount);
		for (int i = 0; i < sourceCount; i++) {
			this.sourceSig.add(sig[i]);
		}
		this.targetSig = new ArrayList<>(sig.length - sourceCount);
		for (int i = sourceCount; i < sig.length; i++) {
			this.targetSig.add(sig[i]);
		}
		this.sig = new ArrayList<>(Arrays.asList(sig));
	}

	/** Returns the class of this opcode (normal or control flow). */
	public OpClaz getClaz() {
		return this.claz;
	}

	/** Returns the number of operands. */
	public int getSigSize() {
		return getSourceCount() + getTargetCount();
	}

	/** Returns the list of expected operand types. */
	public List<Operand.Type> getSig() {
		return this.sig;
	}

	/** Returns the number of source operands. */
	public int getSourceCount() {
		return getSourceSig().size();
	}

	/** Returns the list of expected source operand types. */
	public List<Operand.Type> getSourceSig() {
		return this.sourceSig;
	}

	/** Returns the number of target operands. */
	public int getTargetCount() {
		return getTargetSig().size();
	}

	/** Returns the list of expected target operand types. */
	public List<Operand.Type> getTargetSig() {
		return this.targetSig;
	}

	/** Returns the {@link OpCode} for a given string, if any. */
	public static OpCode parse(String code) {
		return codeMap.get(code);
	}

	private static final Map<String, OpCode> codeMap = new HashMap<>();
	static {
		for (OpCode op : values()) {
			if (op.getClaz() != OpClaz.COMMENT) {
				codeMap.put(op.name(), op);
			}
		}
	}
}
