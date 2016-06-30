package divider;

import checker.OffsetSymbolTable;
import exceptions.CompileException;
import sprocl.model.Op;
import toplevel.OpListWrapper;
import toplevel.Tree;

import java.util.List;

public class DividerResult {


    private final OffsetSymbolTable symbolTable;
    Tree<OpListWrapper> threadTree;
    List<CompileException> exceptions;

    public DividerResult(Tree<OpListWrapper> concurrencyTree, List<CompileException> exceptions, OffsetSymbolTable symbolTable) {
        this.symbolTable = symbolTable;
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


    public OffsetSymbolTable getSymbolTable() {
        return symbolTable;
    }
}
