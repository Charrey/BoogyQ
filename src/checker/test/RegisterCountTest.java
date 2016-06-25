package checker.test;

import checker.DeclChecker;
import checker.JumpChecker;
import checker.RegisterCounter;
import checker.TypeChecker;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import parser.*;
import preprocessor.PreProcessor;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by poesd_000 on 23/06/2016.
 */
public class RegisterCountTest {

    private RegisterCounter rc;

    @Before
    public void init() {
        rc = new RegisterCounter();
    }



    @Test
    public void testProg() {
        assertEquals(rc.check(parse("5 -> int a.")), 3);
        assertEquals(rc.check(parse("5 -> int a -> int b -> int c.")), 3);
        assertEquals(rc.check(parse("function (int a, int b -> int c) add:\n\ta + b -> c.\n\n5, 3 => add -> int c.")), 4);
        assertEquals(rc.check(parse("5 -> int a.\n10 -> int b.\n\nif (b>a):\n\tb + 1 -> b.\n\t<loop.\n\n5->a.\n10->b.\nif (True):\n\tb-1->b.\n\tif (b<10):\n\t\tb+1->b.\n\t<-  loop.\n\na=>showV.\nb=>showV.")), 3);
    }


    private ParseTree parse(String text) {

        try {
            text = PreProcessor.process(text);
        } catch (ParseException e) {
            fail();
        }
        boolean haserrors = false;
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new BoogyQLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        BoogyQParser parser = new BoogyQParser(tokens);
        BoogyQParser.ProgramContext tree = parser.program();
        
        List<String> errors = null;
        if (!haserrors) {
            errors = new DeclChecker().check(tree);
            if (!errors.isEmpty()) {
                haserrors = true;
                for (String error : errors) {
                    System.out.println(error);
                }
            }
        }

        if (!haserrors) {
            errors = new JumpChecker().check(tree);
            if (!errors.isEmpty()) {
                haserrors = true;
                for (String error : errors) {
                    System.out.println(error);
                }
            }
        }

        if (!haserrors) {
            errors = new TypeChecker().check(tree);
            if (!errors.isEmpty()) {
                haserrors = true;
                for (String error : errors) {
                    System.out.println(error);
                }
            }
        }
        if (haserrors) {
            System.out.println("Could not compile, program had errors.");
        } else {
            System.out.println("Program has no errors.");
        }

        return tree;
    }
}
