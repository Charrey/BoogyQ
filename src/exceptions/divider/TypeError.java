package exceptions.divider;

import exceptions.CompileError;

/**
 *  Error given when a type mistake has been found.
 */
public class TypeError extends CompileError {

    /**
     * Creates a new JumpError.
     * @param message Message to the user what went wrong.
     * @param lineNumber Line where something went wrong.
     */
    public TypeError(String message, int lineNumber) {
        super(message,lineNumber);
    }
}
