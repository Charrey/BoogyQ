package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import parser.*;


@SuppressWarnings("javadoc")
public class ParserTest {

    @Test
    public void basictest(){
        parse("a -> b.");
        parse("5 -> int b.");
        parse("int b.");
        parse("5 -> a -> int b.");
        parse("5 -> int c -> int b.");
    }

    @Test
    public void operatortest(){
        parse("-5 -> a.");
        parse("5.");
        parse("!a.");
        parse("2*2+(4/1).");
        parse("(2+2) >= (a^2).");
    }

    @Test
    public void arraytest(){
        parse("{0}*4 -> int[] a.");
        parse("{0}*4*6 -> a.");
        parse("[1,2,3] -> a.");
    }

    private void parse(String text) {
        // Convert the input text to a character stream
        CharStream stream = new ANTLRInputStream(text);
        // Build a lexer on top of the character stream
        Lexer lexer = new BoogyQLexer(stream);
        // Extract a token stream from the lexer
        TokenStream tokens = new CommonTokenStream(lexer);
        // Build a parser instance on top of the token stream
        BoogyQParser parser = new BoogyQParser(tokens);
        // Get the parse tree by calling the start rule
        ParseTree tree = parser.program();
        // Print the (formatted) parse tree
        System.out.println(tree.toStringTree(parser));
    }
}
