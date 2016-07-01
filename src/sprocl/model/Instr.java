package sprocl.model;

import java.util.Iterator;

/**
 * Instruction for a Program.
 * @author Arend Rensink
 */
public abstract class Instr implements Iterable<Op> {
	/** The line number of this instruction. */
	private int line = -1;
	/** The program in which this instruction occurs. */
	private Program prog;
	/** Returns the number of operations in this instruction.
	 * @return The number of operations in this instruction.
	 **/
	public abstract int size();

	/** Returns an iterator over the operations in this instruction. */
	@Override
	public abstract Iterator<Op> iterator();


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
	 * @param prog The program to be set.
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
}
