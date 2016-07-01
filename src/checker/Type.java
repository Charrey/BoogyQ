package checker;


/** Pascal data type. */
abstract public class Type {
	/** The singleton instance of the {@link Bool} type. */
	static final Type BOOL = new Bool();
	/** The singleton instance of the {@link Int} type. */
	static final Type INT = new Int();
	/** The singleton instance of the {@link Char} type. */
	static final Type CHAR = new Char();
	/** The singleton instance of the {@link String} type. */
	static final Type BQSTRING = new BQString();


	/** Constructor for subclasses. */
			private Type() {
			}


		/** Representation of the BoogyQ Boolean type. */
		private static class Bool extends Type {
			private Bool() {
				super();
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
		private static class Int extends Type {

			public int size() {
				return 4;
			}

			@Override
			public java.lang.String toString() {
				return "Integer";
			}
		}

		/** Representation of the BoogyQ Char type. */
		private static class Char extends Type {

			public int size() {
				return 4;
			}

			@Override
			public java.lang.String toString() {
				return "Char";
			}
		}

	/** Representation of the BoogyQ Char type. */

	private static class BQString extends Type {

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
			return this == obj || obj instanceof BQString;
		}
	}


	/** Representation of BoogyQ Array types. */
	static class Array extends Type {
		private final Type elemType;

		Array(Type elemType) {
			this.elemType = elemType;
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
			return this.elemType.equals(other.elemType);
		}

	}
}
