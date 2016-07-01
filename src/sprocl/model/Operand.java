package sprocl.model;

/** Abstract supertype of all kinds of operands. */
abstract public class Operand {
	private final Type type;

	/**
	 * Creates a new Operand.
	 * @param type Type of this operand.
	 */
	Operand(Type type) {
		this.type = type;
	}

	/** Returns the type of this operand.
	 * @return That type.
	 **/
	public Type getType() {
		return this.type;
	}

	/** Enumeration of all available operand types. */
	public enum Type {
		/** Register-type operand; class {@link Reg}. */
		REG,
		/** Numeric operand; class {@link Num} or Symb. */
		NUM,
		/** Literal string operand; class {@link Str}. */
		STR
	}
}
