package checker.test;

import checker.TypeChecker;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Before;
import org.junit.Test;
import parser.*;
import preprocessor.PreProcessor;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by poesd_000 on 20/06/2016.
 */
public class TypeCheckerTest {

    private TypeChecker checker;

    @Before
    public void init() {
        checker = new TypeChecker();
    }

    @Test
    public void basicDeclarations() {
        System.out.println(checker.check(parse("char a.\n6 -> a."), new HashMap<>()));
        System.out.println(checker.check(parse("[4,5,6] -> int a.\n6 -> a."), new HashMap<>()));
        System.out.println(checker.check(parse("[4,5,6] -> int[] a.\n6 -> a."), new HashMap<>()));
        System.out.println(checker.check(parse("5 + False -> bool a."), new HashMap<>()));
        System.out.println(checker.check(parse("function (int a -> int b) square:\n\ta -> b.\n(=> square) -> char a."), new HashMap<>()));
        System.out.println(checker.check(parse("function (int a -> int b) square:\n\ta -> b.\n\nfunction (int a -> int b) square:\n\ta -> b."), new HashMap<>()));
        System.out.println(checker.check(parse("function (char a -> int b) square:\n\ta -> b.\n5 => square -> char a."), new HashMap<>()));
        System.out.println(checker.check(parse("!!!!!1 -> char a."), new HashMap<>()));
        System.out.println(checker.check(parse("-True -> char a."), new HashMap<>()));


    }
    private ParseTree parse(String text) {
        try {
            text = PreProcessor.process(text);
            System.out.println(text.replaceAll("\n", "|"));
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
