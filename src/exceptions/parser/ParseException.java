package exceptions.parser;

/**
 * Exception thrown when something goes wrong during the parsing stage.
 */
public class ParseException extends Exception {

    /**
     * Creates a new ParseException.
     * @param message Message given with this exception.
     */
    public ParseException(String message) {
        super(message);
    }
}
