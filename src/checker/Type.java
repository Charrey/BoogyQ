package checker;


/** BoogyQ data type. */
abstract public class Type {
	/** The singleton instance of the {@link Bool} type. */
	static final Type BOOL = new Bool();
	/** The singleton instance of the {@link Int} type. */
	static final Type INT = new Int();
	/** The singleton instance of the {@link Char} type. */
	static final Type CHAR = new Char();
	/** The singleton instance of the {@link String} type. */
	static final Type BQSTRING = new BQString();


		/** Representation of the BoogyQ Boolean type. */
		private static class Bool extends Type {
			private Bool() {
				super();
			}

			@Override
			public java.lang.String toString() {
				return "Boolean";
			}
		}

		/** Representation of the BoogyQ Integer type. */
		private static class Int extends Type {

			@Override
			public java.lang.String toString() {
				return "Integer";
			}
		}

		/** Representation of the BoogyQ Char type. */
		private static class Char extends Type {

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
		public boolean equals(Object obj) {
			return this == obj || obj instanceof BQString;
		}
	}


	/** Representation of BoogyQ Array types. */
	static class Array extends Type {
		private final Type elemType;

		/**
		 * Creates a new array.
		 * @param elemType Type contained by this array.
		 */
		Array(Type elemType) {
			this.elemType = elemType;
		}

		@Override
		public String toString() {
			return "Array of " + this.elemType;
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
