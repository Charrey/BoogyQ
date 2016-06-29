package toplevel;

import sprocl.model.Op;

import java.util.*;

/**
 * Created by Administrator on 28-6-2016.
 */
public enum CoreManager {
    instance;

    public static final int CORE_AMOUNT = 400;



    //toplevel ONLY. No recursion.
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

    public Tree<OpListWrapper> wrap(Tree<List<Op>> input) {
        Tree<OpListWrapper> res = new Tree<>(new OpListWrapper(input.get()));
        for (Tree<List<Op>> t : input.getChildren()) {
            Tree<OpListWrapper> newchild = wrap(t);
            res.addChild(newchild);
        }
        return res;
    }

    public void giveIdentifiers(Set<OpListWrapper> ops, int startingfrom) {
        for (OpListWrapper i: ops) {
            i.setIdentifier(startingfrom);
            startingfrom++;
        }
    }

    public class OpListWrapper {
        private final List<Op> ops;
        private int identifier;

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
    }
}
