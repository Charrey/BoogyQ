package sprocl.model;

/** Abstract supertype of all kinds of operands. */
abstract public class Operand {
	private final Type type;

	Operand(Type type) {
		this.type = type;
	}

	/** Returns the type of this operand. */
	public Type getType() {
		return this.type;
	}

	/** Enumeration of all available operand types. */
	public enum Type {
		/** Register-type operand; class {@link Reg}. */
		REG,
		/** Numeric operand; class {@link Num} or Symb. */
		NUM,
		/** Label operand; class {@link Label}. */
		LABEL,
		/** Literal string operand; class {@link Str}. */
		STR
	}
}
