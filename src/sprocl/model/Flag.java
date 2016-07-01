package sprocl.model;

/**
 * Replacement for a number in a <code>Program</code> when its value is yet unknown.
 */
public class Flag extends Num {

    /**
     * Boolean remembering whether the value was manually set.
     */
    private boolean set = false;
    /**
     * Flag to be given to the Main Thread, as data filler.
     */
    private static Flag mainFlag = new Flag();

    /**
     * Creates a new Flag.
     */
    public Flag() {
        super(-1);
    }

    public String toString() {
        if (!set) {
            return "unset_flag";
        } else {
            return "" + getValue();
        }
    }

    /**
     * Set the value of a Flag.
     * @param set The new value.
     */
    public void setFlag(int set) {
        setValue(set);
        this.set = true;
    }

    /**
     * Returns a flag to be used for OpListWrappers that do not need flags, but yet require one for data saving purposes.
     * @return That flag.
     */
    public static Flag mainFlag() {
        return mainFlag;
    }
}
