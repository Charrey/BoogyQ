package checker;


import exceptions.divider.TypeError;
import javafx.util.Pair;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import parser.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class that checks type use of a BoogyQ program.
 */
public class TypeChecker extends BoogyQBaseListener {

    private static Type INT = Type.INT;
    private static Type BOOL = Type.BOOL;
    private static Type CHAR = Type.CHAR;
    private static Type BQSTRING = Type.BQSTRING;

    private LinkedList<TypeError> errors;
    private ParseTreeProperty<Type> types;
    private SymbolTable<Type> symbols;
    private Map<String, Pair<Type, List<Type>>> functions;
    private int junklines;

    /**
     * Checks a BoogyQ Parse tree for any type errors.
     * @param input The program.
     * @param global A Map of global variables already declared.
     * @return A list of type errors.
     */
    public List<TypeError> check(ParseTree input, Map<String, Type> global) {
        errors = new LinkedList<>();
        types = new ParseTreeProperty<>();
        symbols = new BasicSymbolTable<>();
        functions = new HashMap<>();
        junklines = 0;
        for (String i : global.keySet()) {
            symbols.add(i, global.get(i));
        }

        new ParseTreeWalker().walk(this, input);
        return errors;
    }

    @Override @Deprecated
    public void exitDeclexpr(BoogyQParser.DeclexprContext ctx) {
        switch(ctx.PRIMITIVE().getText()) {
            case "int":
                types.put(ctx, INT);
                symbols.add(ctx.ID().getText(), INT);
                break;
            case "bool":
                types.put(ctx, BOOL);
                symbols.add(ctx.ID().getText(), BOOL);
                break;
            case "char":
                types.put(ctx, CHAR);
                symbols.add(ctx.ID().getText(), CHAR);
                break;
        }
    }

    @Override @Deprecated
    public void exitAndorexpr(BoogyQParser.AndorexprContext ctx) {
        if (!types.get(ctx.getChild(0)).equals(BOOL) || !types.get(ctx.getChild(2)).equals(BOOL)) {
            errors.add(new TypeError("Operation " + ctx.getChild(1).getText() + " not compatible with types " + types.get(ctx.getChild(0)) + " and " + types.get(ctx.getChild(2)), ctx.getStart().getLine() - junklines));
        }
        types.put(ctx, BOOL);
    }

    @Override @Deprecated
    public void exitOpenscope(BoogyQParser.OpenscopeContext ctx) {
        symbols.openScope();
        junklines++;
    }

    @Override @Deprecated
    public void exitClosescope(BoogyQParser.ClosescopeContext ctx) {
        symbols.closeScope();
        junklines++;
    }

    @Override @Deprecated
    public void exitIdenexpr(BoogyQParser.IdenexprContext ctx) {
        types.put(ctx, symbols.get(ctx.ID().getText()));
    }

    @Override @Deprecated
    public void exitTimesexpr(BoogyQParser.TimesexprContext ctx) {
        if (!types.get(ctx.getChild(0)).equals(INT) || !types.get(ctx.getChild(2)).equals(INT)) {
            errors.add(new TypeError("Operation " + ctx.getChild(1).getText() + " not compatible with types " + types.get(ctx.getChild(0)) + " and " + types.get(ctx.getChild(2)), ctx.getStart().getLine() - junklines));
        }
        types.put(ctx, INT);
    }

    @Override @Deprecated
    public void exitPowerexpr(BoogyQParser.PowerexprContext ctx) {
        if (!types.get(ctx.getChild(0)).equals(INT) || !types.get(ctx.getChild(2)).equals(INT)) {
            errors.add(new TypeError("Operation " + ctx.getChild(1).getText() + " not compatible with types " + types.get(ctx.getChild(0)) + " and " + types.get(ctx.getChild(2)), ctx.getStart().getLine() - junklines));
        }
        types.put(ctx, INT);
    }

    @Override @Deprecated
    public void exitFunctionvars(BoogyQParser.FunctionvarsContext ctx) {
        List<Type> types =  new LinkedList<>();
        List<String> identifiers = new LinkedList<>();

        for (BoogyQParser.TypeContext i : ctx.type()) {
            types.add(fromString(i.getText()));
        }
        for (TerminalNode i : ctx.ID()) {
            identifiers.add(i.getText());
        }
        assert types.size()==identifiers.size();

        for (int i = 0; i<types.size(); i++) {
            symbols.add(identifiers.get(i), types.get(i));
        }
    }

    @Override @Deprecated
    public void exitFunctiondecl(BoogyQParser.FunctiondeclContext ctx) {
        BoogyQParser.FunctionvarsContext a = ctx.functionvars();
        List<Type> types =  new LinkedList<>();
        List<String> identifiers = new LinkedList<>();

        for (BoogyQParser.TypeContext i : a.type()) {
            types.add(fromString(i.getText()));
        }
        for (TerminalNode i : a.ID()) {
            identifiers.add(i.getText());
        }
        assert types.size()==identifiers.size();

        for (int i = 0; i<types.size(); i++) {
            symbols.add(identifiers.get(i), types.get(i));
        }
        Type lasttype = types.get(types.size() - 1);
        types.remove(types.get(types.size()-1));

        Pair<Type, List<Type>> result = new Pair<>(lasttype, types);
        String functionname = ctx.ID().getText();
        if (functions.containsKey(functionname)) {
            errors.add(new TypeError("Duplicate function " + functionname, ctx.getStart().getLine() - junklines));
        }
        functions.put(functionname, result);
    }

    @Override @Deprecated
    public void exitPlusexpr(BoogyQParser.PlusexprContext ctx) {
        if (ctx.PLUS()!=null) {
            if (types.get(ctx.getChild(0)).equals(INT)            && types.get(ctx.getChild(2)).equals(INT)) {
                types.put(ctx, INT);
            } else if (types.get(ctx.getChild(0)).equals(CHAR)    && types.get(ctx.getChild(2)).equals(CHAR)) {
                types.put(ctx, CHAR);
            } else if (types.get(ctx.getChild(0)).equals(BQSTRING) && types.get(ctx.getChild(2)).equals(CHAR)) {
                types.put(ctx, BQSTRING);
            } else if (types.get(ctx.getChild(0)).equals(BQSTRING) && types.get(ctx.getChild(2)).equals(BQSTRING)) {
                types.put(ctx, BQSTRING);
            } else {
                errors.add(new TypeError("Operation + not compatible with types " + types.get(ctx.getChild(0)) + " and " + types.get(ctx.getChild(2)), ctx.getStart().getLine() - junklines));
                types.put(ctx, INT);
            }

        } else {
            if (!types.get(ctx.getChild(0)).equals(INT) || !types.get(ctx.getChild(2)).equals(INT)) {
                errors.add(new TypeError("Operation - not compatible with types " + types.get(ctx.getChild(0)) + " and " + types.get(ctx.getChild(2)), ctx.getStart().getLine() - junklines));
            }
            types.put(ctx, types.get(ctx.getChild(0)));
        }
    }

    @Override @Deprecated
    public void exitNumberexpr(BoogyQParser.NumberexprContext ctx) {
        types.put(ctx, INT);
    }

    @Override @Deprecated
    public void exitBoolexpr(BoogyQParser.BoolexprContext ctx) {
        types.put(ctx, BOOL);
    }

    @Override @Deprecated
    public void exitNotexpr(BoogyQParser.NotexprContext ctx) {
        if (!types.get(ctx.getChild(1)).equals(BOOL)) {
            errors.add(new TypeError("Operation ! not compatible with type " + types.get(ctx.getChild(1)), ctx.getStart().getLine() - junklines));
        }
        types.put(ctx, BOOL);
    }

    @Override @Deprecated
    public void exitMinusexpr(BoogyQParser.MinusexprContext ctx) {
        if (!types.get(ctx.getChild(1)).equals(INT)) {
            errors.add(new TypeError("Operation - not compatible with type " + types.get(ctx.getChild(1)), ctx.getStart().getLine() - junklines));
        }
        types.put(ctx, INT);
    }

    @Override @Deprecated
    public void exitFlowexpr(BoogyQParser.FlowexprContext ctx) {
        types.put(ctx, types.get(ctx.flow()));
    }

    @Override @Deprecated
    public void exitComparatorexpr(BoogyQParser.ComparatorexprContext ctx) {
        if (ctx.getChild(1) instanceof BoogyQParser.EqualityContext) {
            if (!types.get(ctx.getChild(0)).equals(types.get(ctx.getChild(2)))) {
                errors.add(new TypeError("Operation " + ctx.getChild(1).getText() + " not compatible with types " + types.get(ctx.expr(0)) + " and " + types.get(ctx.expr(1)), ctx.getStart().getLine() - junklines));
            }
        } else if (ctx.getChild(1) instanceof BoogyQParser.InequalityContext) {
            if (types.get(ctx.getChild(0)).equals(INT) && types.get(ctx.getChild(2)).equals(INT)) {
                types.put(ctx, BOOL);
            } else if (types.get(ctx.getChild(0)).equals(CHAR) && types.get(ctx.getChild(2)).equals(CHAR)) {
                types.put(ctx, BOOL);
            } else {
                errors.add(new TypeError("Operation " + ctx.getChild(1).getText() + " not compatible with types " + types.get(ctx.expr(0)) + " and " + types.get(ctx.expr(1)), ctx.getStart().getLine() - junklines));
            }
        }
        types.put(ctx, BOOL);
    }

    @Override @Deprecated
    public void exitArraydecl(BoogyQParser.ArraydeclContext ctx) {
        types.put(ctx, types.get(ctx.array()));
    }

    @Override @Deprecated
    public void exitPresetarray(BoogyQParser.PresetarrayContext ctx) {
        int firstelemtype = ((TerminalNode) ctx.getChild(1)).getSymbol().getType();
        Type arraytype;
        if (firstelemtype == BoogyQParser.ID) {   //ID
            arraytype = symbols.get(ctx.getChild(1).getText());
        } else if (firstelemtype == BoogyQParser.BOOL) { //BOOL
            arraytype = BOOL;
        } else if (firstelemtype == BoogyQParser.CHAR) { //CHAR
            arraytype = CHAR;
        } else if (firstelemtype == BoogyQParser.NUMBER) { //INT
            arraytype = INT;
        } else {
            throw new UnsupportedOperationException("Wat?");
        }
        for (int i = 0; i<ctx.getChildCount(); i++) {
            if (!ctx.getChild(i).getText().equals("[") && !ctx.getChild(i).getText().equals("]") && !ctx.getChild(i).getText().equals(",") &&  (  (TerminalNode)ctx.getChild(i)).getSymbol().getType() != firstelemtype) {
                errors.add(new TypeError("Found inconsistency in explicit array declaration: " + ((TerminalNode)ctx.getChild(i)).getSymbol().getType() + " and " + firstelemtype, ctx.getStart().getLine() - junklines));
            }
        }
        types.put(ctx, new Type.Array(arraytype));
    }

    @Override @Deprecated
    public void exitMultiarray(BoogyQParser.MultiarrayContext ctx) {
        int elemtype = ((TerminalNode) ctx.getChild(1)).getSymbol().getType();
        if (elemtype == BoogyQParser.ID) {   //ID
            types.put(ctx, new Type.Array(symbols.get(ctx.getChild(1).getText())));
        } else if (elemtype == BoogyQParser.BOOL) { //BOOL
            types.put(ctx, BOOL);
        } else if (elemtype == BoogyQParser.CHAR) { //CHAR
            types.put(ctx, CHAR);
        } else if (elemtype == BoogyQParser.NUMBER) { //INT
            types.put(ctx, INT);
        } else {
            throw new UnsupportedOperationException("Wat?");
        }
    }

    @Override @Deprecated
    public void exitIgnoreme(BoogyQParser.IgnoremeContext ctx) {
        types.put(ctx, types.get(ctx.getChild(0)));
    }

    @Override @Deprecated
    public void exitDeclstandardflow(BoogyQParser.DeclstandardflowContext ctx) {
        Type decltype = fromString(ctx.type().getText());
        symbols.add(ctx.ID().getText(), decltype);
        types.put(ctx, decltype);
        if (!decltype.equals(types.get(ctx.flow()))) {
            errors.add(new TypeError("Attempting to flow from type " + types.get(ctx.flow()) + " to type "+ decltype, ctx.getStart().getLine() - junklines));
        }
    }

    @Override @Deprecated
    public void exitCharexpr(BoogyQParser.CharexprContext ctx) {
        types.put(ctx, CHAR);
    }

    @Override @Deprecated
    public void exitAssignstandardflow(BoogyQParser.AssignstandardflowContext ctx) {
        Type foundtype = symbols.get(ctx.ID().getText());
        types.put(ctx, foundtype);
        if (!foundtype.equals(types.get(ctx.flow()))) {
            errors.add(new TypeError("Attempting to flow from type " + types.get(ctx.flow()) + " to type "+ foundtype, ctx.getStart().getLine() - junklines));
        }
    }

    @Override @Deprecated
    public void exitAssigngeneratorflow(BoogyQParser.AssigngeneratorflowContext ctx) {
        Pair<Type, List<Type>> res = functions.get(ctx.ID().getText());
        if (res==null) {
            errors.add(new TypeError("Undefined generator function " + ctx.ID().getText(), ctx.getStart().getLine() - junklines));
            types.put(ctx, INT);
        } else {
            if (res.getValue().size()!=0) {
                errors.add(new TypeError("No arguments given to non-generator function " + ctx.ID().getText(), ctx.getStart().getLine() - junklines));
            }
            types.put(ctx, res.getKey());
        }
    }

    @Override @Deprecated
    public void exitAssignfunctionflow(BoogyQParser.AssignfunctionflowContext ctx) {
        Pair<Type, List<Type>> res = functions.get(ctx.ID().getText());

        if (res==null) {
            errors.add(new TypeError("Undefined function " + ctx.ID().getText(), ctx.getStart().getLine() - junklines));
            types.put(ctx, types.get(ctx.flow().get(0)));
        } else {
            if (res.getValue().size()!=ctx.flow().size()) {
                errors.add(new TypeError("Wrong number of arguments given to function " + ctx.ID().getText(), ctx.getStart().getLine() - junklines));
            } else {
                for (int i = 0; i<ctx.flow().size(); i++) {
                    if (!types.get(ctx.flow(i)).equals(res.getValue().get(i))) {
                        errors.add(new TypeError(ctx.ID().getText() + " requires for argument " + i + " something of type " + res.getValue().get(i) + " but something was given of type " + types.get(ctx.getChild(i)), ctx.getStart().getLine() - junklines));
                    }
                }
            }
            types.put(ctx, res.getKey());
        }
    }

    //TODO: Check whether this is commented out for a reason
    /*@Override
    public void enterTimesexpr(BoogyQParser.TimesexprContext ctx) {
        if (types.get(ctx.getChild(0)).equals(INT) || types.get(ctx.getChild(2)).equals(INT)) {
            errors.add(ctx.getStart().getLine() - junklines + "-Operation * not compatible with types " + types.get(ctx.getChild(0)) + " and " + types.get(ctx.getChild(2)));
        }
        types.put(ctx, types.get(ctx.getChild(0)));
    }*/

    @Override @Deprecated
    public void exitIfstat(BoogyQParser.IfstatContext ctx) {
        if (!types.get(ctx.expr()).equals(BOOL)) {
            errors.add(new TypeError("If-statement requires boolean condition.", ctx.getStart().getLine() - junklines));
        }
    }

    public static Type fromString(String input) {
        if (input.equals("int")) {
            return INT;
        } else if (input.equals("char")) {
            return CHAR;
        } else if (input.equals("bool")) {
            return BOOL;
        } else if (input.endsWith("[]")) {
            return new Type.Array(fromString(input.substring(0, input.length()-2)));
        } else {
            throw new UnsupportedOperationException("Wat?");
        }
    }
}