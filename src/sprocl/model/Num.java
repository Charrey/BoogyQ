package sprocl.model;

/** Numeric operand.
 * A numeric operand can be a literal or a (symbolic) constant.
 * @author Arend Rensink
 */
public class Num extends Operand {
	/** Value of the numeric operand, if it is a literal. */
	private int value;
	/** Name of the numeric operand, if it is a symbolic constant. */

	protected Num() {
		super(Type.NUM);
	}

	/** Constructs a literal numeric operand. */
	public Num(int value) {
		super(Type.NUM);
		this.value = value;
	}

	/** Returns the value of this numeric operand, if it is a literal. */
	public int getValue() {
		return this.value;
	}

	protected void setValue(int value) {
		this.value = value;
	}



	@Override
	public String toString() {
		return String.valueOf(getValue());
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = prime * NumKind.LIT.hashCode();
		result += getValue();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Num)) {
			return false;
		}
		Num other = (Num) obj;
		return getValue() == other.getValue();
	}


	/** Type class for numeric operands. */
	public static enum NumKind {
		/** Literal constant. */
		LIT
	}
}