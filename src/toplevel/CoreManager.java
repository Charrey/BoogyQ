package toplevel;

import sprocl.model.Op;

import java.util.*;

/**
 * Singleton responsible for any Core-related jobs.
 */
public enum CoreManager {
    instance;

    /**
     * The number of cores the machine has.
     */
    public static final int CORE_AMOUNT = 4;


    /**
     * Assign cores to a Tree of Lists of Operations, in a fair way.
     * @param input The Tree of Lists of Operations.
     * @return A map, assigning each List of Operations to a specific core.
     */
    public Map<OpListWrapper, Integer> assignCores(Tree<OpListWrapper> input) {
        int maincore = CORE_AMOUNT-1;
        List<Set<OpListWrapper>> levels = input.getLevels();
        Map<OpListWrapper, Integer> res = new HashMap<>();
        res.put(input.get(), maincore);
        int counter = 0;
        boolean toplevel = true;
        for (Set<OpListWrapper> layer : levels) {
            if (toplevel) {
                toplevel = false;
                continue;
            }
            for (OpListWrapper oplist : layer) {
                res.put(oplist, counter);
                counter = (counter+1)%(CORE_AMOUNT-1);
            }
        }
        assert levels.get(0).size()==1;
        return res;
    }

    public static Map<Integer, Set<OpListWrapper>> invert(Map<OpListWrapper, Integer> input) {
        Map<Integer, Set<OpListWrapper>> res = new HashMap<>();
        for (Map.Entry<OpListWrapper, Integer> i : input.entrySet()) {
            if (!res.containsKey(i)) {
                res.put(i.getValue(), new HashSet<>());
            }
            res.get(i.getValue()).add(i.getKey());
        }
        return res;
    }
}
