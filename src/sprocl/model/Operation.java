package sprocl.model;

/**
 * Created by Hans on 20-6-2016.
 */
public enum Operation {

    INCR("Incr"),
    DECR("Decr"),
    ADD("Add"),
    SUB("Sub"),
    MUL("Mul"),
    EQUAL("Equal"),
    NEQ("NEq"),
    GT("GT"),
    GTE("GtE"),
    LT("Lt"),
    LTE("LtE"),
    AND("And"),
    OR("Or"),
    LSHIFT("LShift"),
    RSHIFT("RShift"),
    XOR("Xor");


    private final String stringValue;

    public String toString(){
        return stringValue;
    }

    private Operation(String stringValue){
        this.stringValue = stringValue;
    }

}
