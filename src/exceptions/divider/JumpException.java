package exceptions.divider;

import exceptions.CompileException;

public class JumpException extends CompileException {

    public JumpException(String message, int linenumber) {
        super(message, linenumber);
    }
}
