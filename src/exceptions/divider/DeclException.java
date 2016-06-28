package exceptions.divider;

import exceptions.CompileException;

public class DeclException extends CompileException {


    public DeclException(String message, int linenumber) {
        super(message, linenumber);
    }
}
