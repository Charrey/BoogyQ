package exceptions.divider;

import exceptions.CompileException;

/**
 * Created by Hans on 23-6-2016.
 */
public class TypeException extends CompileException {

    public TypeException(String message, int lineNumber) {
        super(message,lineNumber);
    }
}
