package checker;

/**
 * Created by Hans on 23-6-2016.
 */
public class t {
    private static t ourInstance = new t();

    public static t getInstance() {
        return ourInstance;
    }

    private t() {
    }
}
