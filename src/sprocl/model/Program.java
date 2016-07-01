package sprocl.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Program.
 * @author Arend Rensink
 */
public class Program {
	/** Indexed list of all instructions in the program. */
	private final List<Instr> instrList;
	/**
	 * Indexed list of all operations in the program.
	 * This is the flattened list of instructions.
	 */
	private final List<Op> opList;

	/** (Partial) mapping from symbolic constants used in the program
	 * to corresponding numeric values. */
	//private final Map<Num, Integer> symbMap;

	/** Creates a program with an initially empty instruction list. */
	public Program() {
		this.instrList = new ArrayList<>();
		this.opList = new ArrayList<>();
	}

	/** Adds an instruction to the instruction list of this program.
	 * @param instr The instruction to be added.
	 * @throws IllegalArgumentException if the instruction has a known label 
	 */
	public void addInstr(Instr instr) {
		instr.setProgram(this);
		instr.setLine(this.opList.size());
		this.instrList.add(instr);
		for (Op op : instr) {
			this.opList.add(op);
		}
	}

	/** Returns the current list of instructions of this program.
	 * @return The current list of instructions of this program.
	 **/
	public List<Instr> getInstr() {
		return Collections.unmodifiableList(this.instrList);
	}

	/** Returns the size of the program, in number of operations.
	 * @return The size of the program, in number of operations.
	 **/
	public int size() {
		return this.opList.size();
	}

	/** Returns a line-by-line printout of this program. */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Instr instr : getInstr()) {
			result.append(instr.toString());
			result.append('\n');
		}
		return result.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Program)) {
			return false;
		}
		Program other = (Program) obj;
		return this.instrList.equals(other.instrList);
	}



	/** Returns a string consisting of this program in a nice layout.
	 * @return That String.
	 */
	public String prettyPrint() {
		StringBuilder result = new StringBuilder();
		int labelSize = 0;
		int sourceSize = 0;
		int targetSize = 0;
		for (Instr i : getInstr()) {
			labelSize = 0;
			if (i instanceof Op) {
			Op op = (Op) i;
			sourceSize = Math.max(sourceSize, op.toSourceString().length());
			targetSize = Math.max(targetSize, op.toTargetString().length());
			}
		}
		for (Instr i : getInstr()) {
			result.append(i.prettyPrint(labelSize, sourceSize, targetSize));
		}
		return result.toString();
	}

	/**
	 * Creates a program given a list of operations.
	 * @param input The list of operations.
	 * @return The created program.
	 */
	public static Program fromOpList(List<Op> input) {
		Program res = new Program();
		for (Op op : input) {
			res.addInstr(op);
		}
		return res;
	}
}
