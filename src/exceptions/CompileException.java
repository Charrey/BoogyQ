package exceptions;

/**
 * Created by poesd_000 on 14/06/2016.
 */
public class CompileException {

    private String message;
    private int linenumber;

    public CompileException(String message, int linenumber) {
        this.message = message;
        this.linenumber = linenumber;
    }

    public String getMessage() {
        return message;
    }

    public int getLineNumber() {
        return linenumber;
    }

    public String toString() {
        return message;
    }

}
