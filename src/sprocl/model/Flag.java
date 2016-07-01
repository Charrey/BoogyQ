package sprocl.model;

import javax.swing.*;

public class Flag extends Num {

    private boolean set = false;
    private static Flag mainFlag = new Flag();

    public Flag() {
        super();
    }

    public String toString() {
        if (!set) {
            return "unset_flag";
        } else {
            return "" + getValue();
        }
    }

    public void setFlag(int set) {
        setValue(set);
        this.set = true;
    }

    public static Flag mainFlag() {
        return mainFlag;
    }
}
