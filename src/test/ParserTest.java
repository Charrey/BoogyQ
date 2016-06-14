import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import parser.BoogyQLexer;
import parser.BoogyQParser;


@SuppressWarnings("javadoc")
public class ParserTest {

    @Test
    public void basictest(){
        parse("a -> b.");
        parse("5 -> int b.");
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
