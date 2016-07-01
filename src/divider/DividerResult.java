package divider;

import checker.Type;
import exceptions.CompileError;
import toplevel.OpListWrapper;
import toplevel.Tree;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Wrapper for useful output of the Divider's <code>generate</code> method.
 */
public class DividerResult {


    private int globalVars;
    private Tree<OpListWrapper> threadTree;
    private List<CompileError> exceptions;

    DividerResult(Tree<OpListWrapper> concurrencyTree, List<CompileError> exceptions, Map<String, Type> globalVars) {
        this.threadTree = concurrencyTree;
        this.exceptions = exceptions;
        Set<String> non_cp = globalVars.keySet().stream().filter(i -> !i.startsWith("_")).collect(Collectors.toSet());
        this.globalVars = non_cp.size();
    }


    /**
     * Returns a tree denoting all operations and internatl threads.
     * @return A tree denoting all operations and internatl threads.
     */
    public Tree<OpListWrapper> getThreadTree() {
        return threadTree;
    }

    public List<CompileError> getErrors() {
        return exceptions;
    }

    /**
     * Returns whether the Divider encountered errors.
     * @return Whether the Divider encountered errors.
     */
    public boolean hasErrors() {
        return !exceptions.isEmpty();
    }

    /**
     * Returns the total number of global variables.
     * @return The total number of global variables.
     */
    public int globalVarCount() {
        return globalVars;
    }
}
