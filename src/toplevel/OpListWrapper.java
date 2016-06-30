package toplevel;

import sprocl.model.Flag;
import sprocl.model.Op;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Hans on 29-6-2016.
 */
public class OpListWrapper {

    private final List<Op> ops;
    private int identifier;
    private Flag memLocation;

    public OpListWrapper(){ops = new LinkedList<>();}
    public OpListWrapper(List<Op> ops, Flag flag) {
        this.ops = ops;
        memLocation = flag;
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

    public Flag getMemLocation() {
        return memLocation;
    }

    public void setMemLocation(Flag memLocation) {
        this.memLocation = memLocation;
    }
}
