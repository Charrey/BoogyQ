package exceptions.divider;

import exceptions.CompileError;

/**
 *  Error given when a jump mistake has been found.
 */
public class JumpError extends CompileError {

    /**
     * Creates a new JumpError.
     * @param message Message to the user what went wrong.
     * @param linenumber Line where something went wrong.
     */
    public JumpError(String message, int linenumber) {
        super(message, linenumber);
    }
}
