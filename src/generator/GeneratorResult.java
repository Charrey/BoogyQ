package generator;

import checker.OffsetSymbolTable;
import sprocl.model.Flag;
import toplevel.OpListWrapper;

/**
 * Created by poesd_000 on 30/06/2016.
 */
public class GeneratorResult {

    private final OpListWrapper result;
    private final OffsetSymbolTable symbolTable;
    private final Flag flag;


    protected GeneratorResult(OpListWrapper result, OffsetSymbolTable symbolTable, Flag flag) {
        this.result = result;
        this.symbolTable = symbolTable;
        this.flag = flag;
    }


    public OpListWrapper getResult() {
        return result;
    }

    public OffsetSymbolTable getSymbolTable() {
        return symbolTable;
    }

    public Flag getFlag() {
        return flag;
    }
}
