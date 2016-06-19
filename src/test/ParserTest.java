package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.BitSet;

import exceptions.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import parser.*;
import preprocessing.PreProcessor;


@SuppressWarnings("javadoc")
public class ParserTest {

    @Test
    public void basictest(){
        System.out.println("----" + new Object(){}.getClass().getEnclosingMethod().getName() + "----");
        parse("a -> b.");
        parse("5 -> int b.");
        parse("int b.");
        parse("5 -> a -> int b.");
        parse("5 -> int c -> int b.");
        System.out.println();
    }

   @Test
    public void operatortest(){
       System.out.println("----" + new Object(){}.getClass().getEnclosingMethod().getName() + "----");
        parse("-5 -> a.");
        parse("5.");
        parse("!a.");
        parse("2*2+(4/1).");
        parse("(2+2) >= (a^2).");
       System.out.println();
    }

    @Test
    public void arraytest(){
        System.out.println("----" + new Object(){}.getClass().getEnclosingMethod().getName() + "----");
        parse("{0}*4 -> int[] a.");
        parse("{0}*4*6 -> a.");
        parse("[1,2,3] -> a.");
        System.out.println();
    }

    @Test
    public void declarationtest() {
        System.out.println("----" + new Object(){}.getClass().getEnclosingMethod().getName() + "----");
        parse("int a.");
        parse("2 -> int a.");
        parse("{0}*5 -> int[] a.");
        parse("int[3][5] a.");
        parse("int a -> int b.");
        System.out.println();
    }

    @Test
    public void looptest() {
        System.out.println("----" + new Object(){}.getClass().getEnclosingMethod().getName() + "----");
        parse("if (4>3):\n\t5 -> int a\n\t<loop.");
        System.out.println();
    }

    private void parse(String text) {

        try {
            text = PreProcessor.process(text);
            System.out.println(text);
        } catch (ParseException e) {
            fail();
        }

        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new BoogyQLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        BoogyQParser parser = new BoogyQParser(tokens);

        //parser.removeErrorListeners();
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                fail();
            }
            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {}
            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {}
            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {}
        });
        ParseTree tree = parser.program();
        System.out.println(tree.toStringTree(parser));
    }
}
