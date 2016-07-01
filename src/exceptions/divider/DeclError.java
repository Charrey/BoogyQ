package exceptions.divider;

import exceptions.CompileError;

/**
 *  Error given when a declaration mistake has been found.
 */
public class DeclError extends CompileError {


    /**
     * Creates a new DeclError.
     * @param message Message to the user what went wrong.
     * @param linenumber Line where something went wrong.
     */
    public DeclError(String message, int linenumber) {
        super(message, linenumber);
    }
}
