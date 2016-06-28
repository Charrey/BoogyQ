package exceptions.generator;

import exceptions.CompileException;

public class RegisterException extends Exception {

    public RegisterException(String message) {
        super(message);
    }
}
