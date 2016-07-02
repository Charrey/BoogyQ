package checker;

import javafx.util.Pair;

import java.util.*;

/**
 * SymbolTable that keeps track of an offset for each variable.
 */
public class OffsetSymbolTable extends BasicSymbolTable<Integer> {

    /**
     * Stack of offsets used to reuse addresses through scopes.
     */
    private Stack<Integer> offsets = new Stack<>();

    /**
     * First available address in the local memory.
     */
    public static final int LOCAL_OFFSET_START = 1;
    /**
     * First available address in the global memory.
     */
    public static final int GLOBAL_OFFSET_START = 1;

    /**
     * Next available local address to declare a variable at.
     */
    private int currentoffset = LOCAL_OFFSET_START;
    /**
     * * Next available global address to declare a global variable at.
     */
    private int globaloffset = GLOBAL_OFFSET_START;

    /**
     * Set of Strings that are in this symboltable that are global.
     */
    private Set<String> global = new HashSet<>();

    /**
     * Opens a scope in this symboltable.
     */
    @Override
    public void openScope() {
        super.openScope();
        offsets.push(currentoffset);
    }

    /**
     * Closes the scope of this symboltable.
     */
    @Override
    public void closeScope() {
        super.closeScope();
        currentoffset = offsets.pop();
    }

    @Override @Deprecated
    public boolean add(String id, Object rec) {
        return super.add(id, rec);
    }

    /**
     * Adds a variable to this symboltable with appropiate offset.
     * @param id The variable identifier.
     * @param global Whether the variable should be global.
     * @return Whether the adding was successful.
     */
    public boolean add(String id, boolean global) {
        boolean res;
        if (!global) {
            res = super.add(id, currentoffset);
        } else {
            res = super.add(id, globaloffset);
        }
        if(res) {
            if (global) {
                this.global.add(id);
                globaloffset++;
            } else {
                currentoffset++;
            }
        }
        return res;

    }
}
