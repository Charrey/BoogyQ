package exceptions.divider;

import exceptions.CompileException;

/**
 * Created by Hans on 23-6-2016.
 */
public class ReachException extends TypeException {

    public ReachException(int lineNumber) {
        this("Cannot declare a global variable in this scope", lineNumber);
    }
    public ReachException(String message, int lineNumber) {
        super(message, lineNumber);
    }
}
