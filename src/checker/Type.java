package checker;


/** Pascal data type. */
abstract public class Type {
	/** The singleton instance of the {@link Bool} type. */
	public static final Type BOOL = new Bool();
	/** The singleton instance of the {@link Int} type. */
	public static final Type INT = new Int();
	/** The singleton instance of the {@link Char} type. */
	public static final Type CHAR = new Char();
	/** The singleton instance of the {@link String} type. */
	public static final Type BQSTRING = new BQString();


	private final TypeKind kind;

	/** Constructor for subclasses. */
			protected Type(TypeKind kind) {
				this.kind = kind;
			}

			/** Returns the kind of this type. */
		public TypeKind getKind() {
			return this.kind;
		}

		/** Representation of the BoogyQ Boolean type. */
		static public class Bool extends Type {
			private Bool() {
				super(TypeKind.BOOL);
			}

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

			public int size() {
				return 4;
			}

			@Override
			public java.lang.String toString() {
				return "Char";
			}
		}

	/** Representation of the BoogyQ Char type. */

	static public class BQString extends Type {
		private BQString() {
			super(TypeKind.STRING);
		}

		@Override
		public String toString() {
			return "String";
		}

		@Override
			public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Type.BQSTRING.hashCode();
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof BQString)) {
				return false;
			}
			return true;
		}
	}


	/** Representation of BoogyQ Array types. */
	static public class Array extends Type {
		private final Type elemType;

		public Array(Type elemType) {
			super(TypeKind.ARRAY);
			this.elemType = elemType;
		}
		/** Returns the element bound of this array type. */
		public Type getElemType() {
			return this.elemType;
		}

		@Override
		public String toString() {
			return "Array of " + this.elemType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + this.elemType.hashCode();
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
			return true;
		}

	}
}
