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
	computeINCR(4, Operation.INCR, REG, REG, REG),
	computeDECR(4, Operation.DECR, REG, NUM, REG),
	computeADD(4, Operation.ADD, REG, NUM, REG),
	computeSUB(4, Operation.SUB, REG, REG, REG),
	computeMUL(4, Operation.MUL, REG, REG, REG),
	computeEQUAL(4, Operation.EQUAL, REG, REG, REG),
	computeNEQ(4, Operation.NEQ, REG, REG, REG),
	computeGT(4, Operation.GT, REG, REG, REG),
	computeGTE(4, Operation.GTE, REG, REG, REG),
	computeLT(4, Operation.LT, REG, REG, REG),
	computeLTE(4, Operation.LTE, REG, REG, REG),
	computeAND(4, Operation.AND, REG, REG, REG),
	computeOR(4, Operation.OR, REG, REG, REG),
	computeLSHIFT(4, Operation.LSHIFT, REG, REG, REG),
	computeRSHIFT(4, Operation.RSHIFT, REG, REG, REG),

	//The load functions
	ldConst(2, NUM, REG),
	loadAddr(2, NUM, REG),
	//TODO: Load (Defer p) toReg

	//The jump statements
	jumpABS(1,NUM),
	jumpREL(1,NUM),
	jumpIND(1,REG),

	//The branch statements
	branchABS(2, REG, NUM),
	branchREL(2, REG, NUM),
	branchIND(2, REG, REG),

	//The store statements
	//TODO:Store fromReg (DirAddr a)
	//TODO:Store fromReg (IndAddr p)

	//The stack operations
	push(1, REG),
	pop(1, REG),

	//I DONT KNOW WHAT THIS DOES. TODO: Figure this out
	receive(1,REG);

	//Read (DirAddr a)                |   -           |   -           |
	//Read (IndAddr p)

	//TestAndSet (DirAddr a)
	//TestAndSet (IndAddr p)

	//Write fromReg (DirAddr a)
	//Write fromReg (IndrAddr p)

	/** The class that this opcode falls into. */
	private final OpClaz claz;

	/** The function that this opcode uses. */
	private final Operation opr;

	/** The source operand types. */
	private final List<Operand.Type> sourceSig;

	/** The target operand types. */
	private final List<Operand.Type> targetSig;

	/** The operand types. */
	private final List<Operand.Type> sig;


	private OpCode(int sourceCount, Operand.Type... sig) {
		this(CONTROL, sourceCount, null, sig);
	}

	private OpCode(int sourceCount, Operation opr, Operand.Type... sig) {
		this(NORMAL, sourceCount, opr, sig);
	}

	private OpCode(OpClaz claz, int sourceCount, Operation opr, Operand.Type... sig) {
		this.claz = claz;
		this.opr = opr;
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
