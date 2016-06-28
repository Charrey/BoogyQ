package divider;

import exceptions.CompileException;
import sprocl.model.Op;
import toplevel.Tree;

import java.util.List;

public class DividerResult {


    Tree<List<Op>> threadTree;
    List<CompileException> exceptions;

    public DividerResult(Tree<List<Op>> concurrencyTree, List<CompileException> exceptions) {
        this.threadTree = concurrencyTree;
        this.exceptions = exceptions;
    }


    public Tree<List<Op>> getThreadTree() {
        return threadTree;
    }

    public List<CompileException> getErrors() {
        return exceptions;
    }

    public boolean hasErrors() {
        return !exceptions.isEmpty();
    }


}
