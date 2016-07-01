package toplevel;

import sprocl.model.Flag;
import sprocl.model.Op;

import java.util.LinkedList;
import java.util.List;

/**
 * Class used to wrap around Lists of Op-objects for readability and data storage purposes.
 */
public class OpListWrapper {

    private final List<Op> ops;
    private Flag memLocation;

    /**
     * Creates a new OpListWrapper.
     * @param ops The List of Operations being wrapped.
     * @param flag The flag of this List of Operations.
     */
    public OpListWrapper(List<Op> ops, Flag flag) {
        this.ops = ops;
        memLocation = flag;
    }

    /**
     * Returns the List of Operations contained by this wrapper.
     * @return That list.
     */
    public List<Op> getOps() {return ops;}

    public String toString() {
        return  "<"+this.hashCode()+">";
    }

    /**
     * Returns the current flag.
     * @return The flag.
     */
    public Flag getMemLocation() {
        return memLocation;
    }

    /**
     * Sets a new flag for the memory location.
     * @param memLocation The new flag.
     */
    public void setMemLocation(Flag memLocation) {
        this.memLocation = memLocation;
    }
}
