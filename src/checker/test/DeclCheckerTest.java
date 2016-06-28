package checker.test;

import checker.DeclChecker;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import parser.*;
import preprocessor.PreProcessor;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 19-6-2016.
 */
public class DeclCheckerTest {

    DeclChecker checker;

    @Before
    public void init() {
        checker = new DeclChecker();
    }

    @Test
    public void basicDeclarations() {
        assertEquals(checker.check(parse("int a."), new HashSet<>()).size(), 0);
        assertEquals(checker.check(parse("int a.\nint a."), new HashSet<>()).size(), 1);
        assertEquals(checker.check(parse("int a.\nif (1>1):\nOPENSCOPE\nint a.\nCLOSESCOPE"), new HashSet<>()).size(), 0);
        assertEquals(checker.check(parse("5 -> int a."), new HashSet<>()).size(), 0);
        assertEquals(checker.check(parse("int b -> int a."), new HashSet<>()).size(), 0);
        assertEquals(checker.check(parse("int a -> int a."), new HashSet<>()).size(), 1);
    }



    private ParseTree parse(String text) {

        try {
            text = PreProcessor.process(text);
        } catch (ParseException e) {
            fail();
        }
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new BoogyQLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        BoogyQParser parser = new BoogyQParser(tokens);
        return parser.program();
    }
}
