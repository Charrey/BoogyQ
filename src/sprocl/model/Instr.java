package sprocl.model;

import java.util.Iterator;

/**
 * ILOC instruction
 * @author Arend Rensink
 */
public abstract class Instr implements Iterable<Op> {
	/** The line number of this instruction. */
	private int line = -1;
	/** The label of this instruction. */
	private Label label;
	/** The program in which this instruction occurs. */
	private Program prog;
	/** Returns the number of operations in this instruction. */
	public abstract int size();

	/** Returns an iterator over the operations in this instruction. */
	@Override
	public abstract Iterator<Op> iterator();

	/** Indicates if the line number of this instruction has been set. */
	boolean hasLine() {
		return getLine() >= 0;
	}

	/** Returns the line number of this instruction.
	 * @return the line number; {@code -1} if the line number has not been set.
	 */
	public int getLine() {
		return this.line;
	}

	/** Sets the line number of this instruction. */
	void setLine(int line) {
		assert this.line < 0 && line >= 0;
		this.line = line;
	}

	/** Sets the program in which this instruction occurs.
	 */
	void setProgram(Program prog) {
		assert this.prog == null & prog != null;
		this.prog = prog;
	}

	/** Returns a string of the form
	 * {@code label? opCode sources (arrow targets)? comment?}
	 * where the widths of the label, sources and targets parts
	 * are predetermined.
	 * @param labelSize width of the {@code label} part
	 * @param sourceSize width of the {@code sources} part
	 * @param targetSize width of the {@code targets} part
	 */
	abstract public String prettyPrint(int labelSize, int sourceSize,
			int targetSize);

	@Override
	public int hashCode() {
		return (this.label == null) ? 0 : this.label.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Instr)) {
			return false;
		}
		Instr other = (Instr) obj;
		if (this.label == null) {
			if (other.label != null) {
				return false;
			}
		} else if (!this.label.equals(other.label)) {
			return false;
		}
		return true;
	}

	/** Label separator. */
	private final static String LABEL_SEP = ": ";
}
