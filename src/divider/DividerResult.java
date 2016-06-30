package divider;

import checker.OffsetSymbolTable;
import checker.Type;
import exceptions.CompileException;
import toplevel.OpListWrapper;
import toplevel.Tree;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DividerResult {


    private final OffsetSymbolTable symbolTable;
    private int globalVars;
    Tree<OpListWrapper> threadTree;
    List<CompileException> exceptions;

    public DividerResult(Tree<OpListWrapper> concurrencyTree, List<CompileException> exceptions, OffsetSymbolTable symbolTable, Map<String, Type> globalVars) {
        this.symbolTable = symbolTable;
        this.threadTree = concurrencyTree;
        this.exceptions = exceptions;
        Set<String> non_cp = new HashSet<>();
        for (String i : globalVars.keySet()) {
            if (!i.startsWith("_")) {
                non_cp.add(i);
            }
        }
        this.globalVars = non_cp.size();
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

    public OffsetSymbolTable getSymbolTable() {
        return symbolTable;
    }

    public int globalVarCount() {
        return globalVars;
    }
}
