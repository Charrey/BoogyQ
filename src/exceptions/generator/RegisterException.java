package exceptions.generator;

/**
 * Exception used when something goes wrong related to registers.
 */
public class RegisterException extends Exception {

    /**
     * Exception thrown when there's a shortage of regisgters.
     * @param message The message given when this exception is thrown.
     */
    public RegisterException(String message) {
        super(message);
    }
}
