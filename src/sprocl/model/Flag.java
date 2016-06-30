package sprocl.model;

import javax.swing.*;

/**
 * Created by poesd_000 on 30/06/2016.
 */
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
            return "flag_"+getValue();
        }
    }

    public int getFlag() {
        if (!set) {
            assert false;
            System.err.println("UNCHECKED GETFLAG");
        }
        return getValue();
    }

    public void setFlag(int set) {
        setValue(set);
        this.set = true;
    }

    public static Flag mainFlag() {
        return mainFlag;
    }
}
