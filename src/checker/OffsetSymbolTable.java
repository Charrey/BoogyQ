package checker;

import javafx.util.Pair;

import java.util.*;

public class OffsetSymbolTable extends BasicSymbolTable<Integer> {

    Stack<Integer> offsets = new Stack<>();

    public static final int LOCAL_OFFSET_START = 1;
    public static final int GLOBAL_OFFSET_START = 1;

    int currentoffset = LOCAL_OFFSET_START;
    int globaloffset = GLOBAL_OFFSET_START;

    Set<String> global = new HashSet<>();

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
    public Pair<Integer, Boolean> get(String id) {
        return new Pair<>((Integer) super.get(id), global.contains(id));
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
