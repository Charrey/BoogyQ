package checker;

import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.Map;
import java.util.Stack;

public class OffsetSymbolTable extends BasicSymbolTable<Integer> {

    Stack<Integer> offsets = new Stack<>();
    int currentoffset = 1;

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
        return (Integer) super.get(id);
    }

    public boolean add(String id) {
        boolean res = super.add(id, currentoffset);
        if(res) {
            currentoffset += 1;
        } else {
            throw new IllegalArgumentException("WTF HAPPENED???");
        }
        return res;

    }
}
