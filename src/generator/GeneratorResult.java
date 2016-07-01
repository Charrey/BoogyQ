package generator;

import checker.OffsetSymbolTable;
import sprocl.model.Flag;
import toplevel.OpListWrapper;

public class GeneratorResult {

    private final OpListWrapper result;
    private final OffsetSymbolTable symbolTable;


    GeneratorResult(OpListWrapper result, OffsetSymbolTable symbolTable) {
        this.result = result;
        this.symbolTable = symbolTable;
    }


    public OpListWrapper getResult() {
        return result;
    }

    public OffsetSymbolTable getSymbolTable() {
        return symbolTable;
    }
}
