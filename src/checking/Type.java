package checking;


/** Pascal data type. */
abstract public class Type {
	/** The singleton instance of the {@link Bool} type. */
	public static final Type BOOL = new Bool();
	/** The singleton instance of the {@link Int} type. */
	public static final Type INT = new Int();
	/** The singleton instance of the {@link Char} type. */
	public static final Type CHAR = new Char();
	/** The singleton instance of the {@link String} type. */

	private final TypeKind kind;

	/** Constructor for subclasses. */
	protected Type(TypeKind kind) {
		this.kind = kind;
	}

	/** Returns the kind of this type. */
	public TypeKind getKind() {
		return this.kind;
	}

	/** returns the size (in bytes) of a value of this type. */
	abstract public int size();

	/** Representation of the BoogyQ Boolean type. */
	static public class Bool extends Type {
		private Bool() {
			super(TypeKind.BOOL);
		}

		@Override
		public int size() {
			return 4; //TODO: Store all these things somewhere where all the information of the machine is.
		}

		@Override
		public java.lang.String toString() {
			return "Boolean";
		}
	}

	/** Representation of the BoogyQ Integer type. */
	static public class Int extends Type {
		private Int() {
			super(TypeKind.INT);
		}

		@Override
		public int size() {
			return 4;
		}

		@Override
		public java.lang.String toString() {
			return "Integer";
		}
	}

	/** Representation of the BoogyQ Char type. */
	static public class Char extends Type {
		private Char() {
			super(TypeKind.CHAR);
		}

		@Override
		public int size() {
			return 4;
		}

		@Override
		public java.lang.String toString() {
			return "Char";
		}
	}

	/** Representation of the BoogyQ Char type. */
	static public class BString extends Type {
		private final int lower;
		private final int upper;

		private BString(int lower, int upper) {
			super(TypeKind.STRING);
			assert upper >= lower;
			this.lower = lower;
			this.upper = upper;
		}

		/** Returns the lower bound of this String type. */
		public int getLower() {
			return this.lower;
		}

		/** Returns the upper bound of this String type. */
		public int getUpper() {
			return this.upper;
		}

		/** Returns the element bound of this array type. */
		public Type getElemType() {
			return Type.CHAR;
		}

		@Override
		public int size() {
			return (getUpper() - getLower() + 1) * Type.CHAR.size();
		}

		@Override
		public String toString() {
			return "String [" + this.lower + ".." + this.upper + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Type.CHAR.hashCode();
			result = prime * result + this.lower;
			result = prime * result + this.upper;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof BString)) {
				return false;
			}
			BString other = (BString) obj;
			if (this.lower != other.lower) {
				return false;
			}
			if (this.upper != other.upper) {
				return false;
			}
			return true;
		}
	}


	/** Representation of BoogyQ Array types. */
	static public class Array extends Type {
		private final int lower;
		private final int upper;
		private final Type elemType;

		private Array(int lower, int upper, Type elemType) {
			super(TypeKind.ARRAY);
			assert upper >= lower;
			this.lower = lower;
			this.upper = upper;
			this.elemType = elemType;
		}

		/** Returns the lower bound of this array type. */
		public int getLower() {
			return this.lower;
		}

		/** Returns the upper bound of this array type. */
		public int getUpper() {
			return this.upper;
		}

		/** Returns the element bound of this array type. */
		public Type getElemType() {
			return this.elemType;
		}

		@Override
		public int size() {
			return (getUpper() - getLower() + 1) * this.elemType.size();
		}

		@Override
		public String toString() {
			return "Array [" + this.lower + ".." + this.upper + "] of "
					+ this.elemType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.elemType.hashCode();
			result = prime * result + this.lower;
			result = prime * result + this.upper;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Array)) {
				return false;
			}
			Array other = (Array) obj;
			if (!this.elemType.equals(other.elemType)) {
				return false;
			}
			if (this.lower != other.lower) {
				return false;
			}
			if (this.upper != other.upper) {
				return false;
			}
			return true;
		}

	}
}