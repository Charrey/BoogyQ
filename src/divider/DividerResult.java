package divider;

import exceptions.CompileException;
import sprocl.model.Op;
import toplevel.OpListWrapper;
import toplevel.Tree;

import java.util.List;

public class DividerResult {


    Tree<OpListWrapper> threadTree;
    List<CompileException> exceptions;

    public DividerResult(Tree<OpListWrapper> concurrencyTree, List<CompileException> exceptions) {
        this.threadTree = concurrencyTree;
        this.exceptions = exceptions;
    }


    public Tree<OpListWrapper> getThreadTree() {
        return threadTree;
    }

    public List<CompileException> getErrors() {
        return exceptions;
    }

    public boolean hasErrors() {
        return !exceptions.isEmpty();
    }


}
