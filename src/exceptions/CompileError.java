package exceptions;

/**
 * Class used to save an error encountered during compilation.
 */
public class CompileError {

    private String message;
    private int linenumber;

    /**
     * Creates a new CompileError
     * @param message Message given with this error.
     * @param linenumber Line where this error happened.
     */
    public CompileError(String message, int linenumber) {
        this.message = message;
        this.linenumber = linenumber;
    }

    /**
     * Returns the message given with this error.
     * @return The message given with this error.
     */
    public String getMessage() {
        return message;
    }

    /**
     * Returns the line where this error happened.
     * @return The line where this error happened.
     */
    public int getLineNumber() {
        return linenumber;
    }

    public String toString() {
        return message;
    }

}
