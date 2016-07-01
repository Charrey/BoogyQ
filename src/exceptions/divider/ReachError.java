package exceptions.divider;

/**
 *  Error given when global variables have been used incorrectly.
 */
public class ReachError extends TypeError {

    /**
     * Creates a new JumpError with a standard message.
     * @param lineNumber Line where something went wrong.
     */
    public ReachError(int lineNumber) {
        this("Cannot declare a global variable in this scope", lineNumber);
    }

    /**
     * Creates a new JumpError.
     * @param lineNumber Line where something went wrong.
     * @param message Message given with this error.
     */
    public ReachError(String message, int lineNumber) {
        super(message, lineNumber);
    }
}
