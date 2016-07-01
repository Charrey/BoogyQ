package sprocl.model;

/** Numeric operand.
 * A numeric operand can be a literal or a (symbolic) constant.
 * @author Arend Rensink
 */
public class Num extends Operand {
	/** Value of the numeric operand. */
	private int value;

	/** Constructs a literal numeric operand.
	 * @param value Value of this operand.
	 **/
	public Num(int value) {
		super(Type.NUM);
		this.value = value;
	}

	/** Returns the value of this numeric operand.
	 * @return The value of this operand.
	 **/
	public int getValue() {
		return this.value;
	}

	/**
	 * Sets the value of this Num.
	 * @param value The new value.
	 */
	protected void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(getValue());
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
}