package checker;

import javafx.util.Pair;

import java.util.*;

/**
 * SymbolTable that keeps track of an offset for each variable.
 */
public class OffsetSymbolTable extends BasicSymbolTable<Integer> {

    private Stack<Integer> offsets = new Stack<>();

    public static final int LOCAL_OFFSET_START = 1;
    public static final int GLOBAL_OFFSET_START = 1;

    private int currentoffset = LOCAL_OFFSET_START;
    private int globaloffset = GLOBAL_OFFSET_START;

    private Set<String> global = new HashSet<>();

    @Override
    public void openScope() {
        super.openScope();
        offsets.push(currentoffset);
    }

    @Override
    public void closeScope() {
        super.closeScope();
        currentoffset = offsets.pop();
    }

    @Override @Deprecated
    public boolean add(String id, Object rec) {
        return super.add(id, rec);
    }

    @Override
    public Integer get(String id) {
        return super.get(id);
    }

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
        } else {
            //throw new IllegalArgumentException("WTF HAPPENED???");
        }
        return res;

    }
}
