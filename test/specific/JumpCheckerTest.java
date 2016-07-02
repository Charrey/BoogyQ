package specific;

import checker.JumpChecker;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import parser.BoogyQLexer;
import parser.BoogyQParser;
import preprocessor.PreProcessor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 19-6-2016.
 */
public class JumpCheckerTest {


    JumpChecker checker;

    @Before
    public void init() {
        checker = new JumpChecker();
    }

    @Test
    public void basicDeclarations() {
        assertEquals(checker.check(parse("if (1>1):\n\tint a.")).size(), 0);
        assertEquals(checker.check(parse("if (1>1):\n\t<loop.")).size(), 0);
        assertEquals(checker.check(parse("if (1>1):\n<-  loop.")).size(), 1);
        assertEquals(checker.check(parse("if (1>1):\n<-  loop.")).size(), 1);
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
