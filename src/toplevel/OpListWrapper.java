package toplevel;

import sprocl.model.Op;

import java.util.List;

/**
 * Created by Hans on 29-6-2016.
 */
public class OpListWrapper {

    private final List<Op> ops;
    private int identifier;
    private int memLocation;

    public OpListWrapper(List<Op> ops) {
        this.ops = ops;
    }
    public List<Op> getOps() {return ops;}

    public void setIdentifier(int iden) {
        this.identifier = iden;
    }
    public int getIdentiefier() {
        return identifier;
    }
    public String toString() {
        return  "<"+this.hashCode()+">";
    }

    public int getMemLocation() {
        return memLocation;
    }

    public void setMemLocation(int memLocation) {
        this.memLocation = memLocation;
    }
}
