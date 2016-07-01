package sprocl.model;
import java.util.*;

import sprocl.model.Operand.Type;

/**
 * ILOC operation
 * @author Arend Rensink
 */
public class Op extends Instr {
	/** Operand separator. */
	private final static String OP_SEP = ",";

	/** The operation code. */
	private OpCode opCode;
	/** The list of arguments of this operation. */
	private final List<Operand> args;
	/** The optional comment for this operation. */

	private String ifstartlabel = "";
	private List<String> ifendlabels = new LinkedList<>();


	/** Constructs an unlabelled operation with a given opcode and arguments. */
	public Op(OpCode opCode, Operand... args) {
		this(opCode, Arrays.asList(args));
	}

	/** Constructs a labelled operation with a given opcode and arguments.
	 * @throws IllegalArgumentException if one of the arguments
	 * is not of the expected type 
	 */
	public Op(OpCode opCode, List<Operand> args)
			throws IllegalArgumentException {
		this.opCode = opCode;
		int argsCount = opCode.getSigSize();
		if (args.size() != argsCount) {
			throw new IllegalArgumentException(String.format(
					"Operation '%s' expects %d arguments but has %d", opCode,
					argsCount, args.size()));
		}
		for (int i = 0; i < argsCount; i++) {
			Operand arg = args.get(i);
			Type expected = opCode.getSig().get(i);
			if (arg.getType() != expected) {throw new IllegalArgumentException(
						String.format(
								"Operation '%s' argument %d should be '%s' but is '%s'",
								this.opCode, i, expected, arg.getType()));
			}
		}
		this.args = new ArrayList<>(args);
	}

	/** Returns the class of operation (normal or control flow). */
	private OpClaz getClaz() {
		return this.opCode.getClaz();
	}

	/** Returns the opcode of this operation. */
	public OpCode getOpCode() {
		return this.opCode;
	}

	/** Returns the list of all (source + target) arguments. */
	public List<Operand> getArgs() {
		return this.args;
	}

	@Override
	public int size() {
		return 1;
	}

	@Override
	public Iterator<Op> iterator() {
		return Collections.singleton(this).iterator();
	}

	@Override
	public String prettyPrint(int labelSize, int sourceSize, int targetSize) {
		StringBuilder result = new StringBuilder();
		int arrowSize = 4;
		result.append(String.format("%-8s", getOpCode().name() + " "));
		if (sourceSize > 0) {
			result.append(String.format("%-" + sourceSize + "s",
					toSourceString()));
		}
		result.append(String
				.format("%-" + arrowSize + "s", toArrowString()));
		if (targetSize > 0) {
			result.append(String.format("%-" + targetSize + "s ",
					toTargetString()));
		}
		result.append('\n');
		return result.toString();
	}


	/** Returns the string representation of the arrow symbol. */
	private String toArrowString() {
		if (getOpCode().getTargetCount() > 0) {
			return ' ' + getClaz().getArrow() + ' ';
		} else {
			return "";
		}
	}

	/** Returns the string representation of the source operands. */
	String toSourceString() {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (int i = 0; i < getOpCode().getSourceCount(); i++) {
			Operand o = getArgs().get(i);
			if (first) {
				first = false;
			} else {
				result.append(OP_SEP);
			}
			result.append(o);
		}
		return result.toString();
	}

	/** Returns the string representation of the target operands. */
	String toTargetString() {
		StringBuilder result = new StringBuilder();
		boolean first = true;
		for (int i = getOpCode().getSourceCount(); i < getOpCode()
				.getSigSize(); i++) {
			Operand o = getArgs().get(i);
			if (first) {
				first = false;
			} else {
				result.append(OP_SEP);
			}
			result.append(o);
		}

		String toreturn = result.toString();

		if (!getIfStartLabel().equals("")) {
			toreturn += " (ifstart="+ifstartlabel+")";
		}
		if (!getIfEndLabels().isEmpty()) {
			toreturn += " (ifend="+getIfEndLabels()+")";
		}
		return toreturn;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		Op other = (Op) obj;
		if (this.opCode != other.opCode) {
			return false;
		}
		if (!this.args.equals(other.args)) {
			return false;
		}
		if (!this.ifstartlabel.equals(other.ifstartlabel)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the optional label set as start of if-statement.
	 * @return The optional label set as start of if-statement.
	 */
	public String getIfStartLabel() {
		return ifstartlabel;
	}

	/**
	 * Sets the optional label as start of an if-statement
	 * @param set The label.
	 */
	public void setIfStartLabel(String set) {
		ifstartlabel = set;
	}

	/**
	 * Returns all end-labels this Op has.
	 * @return all end-labels.
	 */
	public List<String> getIfEndLabels() {
		return ifendlabels;
	}

	/**
	 * Add an end-label to this Op, if it's the end of an if-statement.
	 * @param input the end-label.
	 */
	public void addIfendlabel(String input) {
		ifendlabels.add(input);
	}

	/**
	 * Change an argument of this Op to another.
	 * @param index The index of the argument.
	 * @param op The new argument.
	 */
	public void setArg(int index, Operand op) {
		args.set(index, op);
	}

	/**
	 * Changes the OpCode of this Op.
	 * @param input The new OpCode.
	 */
	public void setOpCode(OpCode input) {
		opCode = input;
	}
}
