package toplevel;

import checker.DeclChecker;
import checker.JumpChecker;
import checker.TypeChecker;
import exceptions.generator.RegisterException;
import exceptions.parser.ParseException;
import generator.Generator;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.BoogyQLexer;
import parser.BoogyQParser;
import preprocessor.PreProcessor;
import sprocl.model.Program;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.fail;

/**
 * Created by poesd_000 on 20/06/2016.
 */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<String> parseerrors = new LinkedList<>();

    private static BoogyQParser parser;

    public static void main(String[] args) {
        System.out.println("Reading files...");
        File dir = new File("src/toplevel/.");
        File [] files = dir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".boog");
            }
        });
        if (files.length==0) {
            System.out.println("No files found!");
        } else {
            String res = "Found: " + files[0].getName();
            for (int i = 1; i<files.length; i++) {
                res += ", " + files[i].getName();
            }
            System.out.println(res);
            boolean exit = false;

            File the_file = getFile(files);
            while (!exit) {
                byte[] encoded = new byte[0];
                try {
                    encoded = Files.readAllBytes(Paths.get(the_file.getAbsolutePath()));
                    String program = new String(encoded, Charset.defaultCharset());
                    System.out.println("-----Compiling program:-----");
                    System.out.println(program);
                    System.out.println("-----Preprocessed:----------");
                    try {
                        program = PreProcessor.process(program);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println(program);
                    parseerrors = new LinkedList<>();
                    ParseTree parsed = parse(program);

                    List<String> errors = getErrors(parsed);

                    if (errors.size()>0) {
                        for (String err : errors) {
                            System.out.println(err);
                        }
                        System.out.println("Could not compile, program had errors.");
                    } else {
                        System.out.println("Program has no errors.");
                        Program prog = Generator.getInstance().generate(parsed);
                        System.out.println("-----Program:---------------");
                        System.out.println(prog.prettyPrint());
                        System.out.println("----------------------------");
                    }

                } catch (IOException e) {
                    System.out.println("Error while reading file.");
                } catch (RegisterException e) {
                    System.out.println(e.getMessage());
                }

                while (true) {
                    System.out.println("Awaiting input...");
                    String input = scanner.nextLine();
                    if (input.equals(":r")) {
                        break;
                    } else if (input.equals("exit")) {
                        System.exit(0);
                    } else {
                        System.out.println("Unknown input.");
                    }
                }
            }
        }
    }

    private static File getFile(File[] files) {
        System.out.println("Which of these would you like to compile?");
        while (true) {
            String get = scanner.nextLine();
            File available = null;
            for (File file : files) {
                if (file.getName().startsWith(get)) {
                    if (available == null) {
                        available = file;
                    } else {
                        System.out.println("Ambiguity in query: " + file.getName() + ", " + available.getName());
                        available = null;
                        break;
                    }
                }
            }
            if (available == null) {
                System.out.println("Could not find the file specified. Try again.");
            } else {
                return available;
            }
        }
    }


    private static int arrayContainsString(String input, File[] files) {
        for (int i = 0; i<files.length; i++) {
            if (files[i].getName().equals(input)) {
                return i;
            }
        }
        return -1;
    }

    public static List<String> getErrors(ParseTree tree) {
        if (!parseerrors.isEmpty()) {
            return parseerrors;
        }
        List<String> errors = null;
        errors = new DeclChecker().check(tree);
        if (!errors.isEmpty()) {
            return errors;
        }
        errors = new JumpChecker().check(tree);
        if (!errors.isEmpty()) {
            return errors;
        }
        errors = new TypeChecker().check(tree);
        return errors;
    }

    public static void writeToFile(String input, String filename) throws IOException {
        PrintWriter out = null;
        try {
            new File(filename).createNewFile();
            out = new PrintWriter(filename);
            out.write(input);
        }
        finally {
            if (out!=null) {
                out.close();
            }
        }
    }



    private static ParseTree parse(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new BoogyQLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        parser = new BoogyQParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                parseerrors.add(s.replace("no viable alternative at input ", "Syntax error a:rt input "));
            }

            private int getRealLine(String text, int i) {
                while(text.contains("OPENSCOPE")) {
                    text.replaceFirst("OPENSCOPE", "");
                    i--;
                }
                while(text.contains("CLOSESCOPE")) {
                    text.replaceFirst("CLOSESCOPE", "");
                    i--;
                }
                return i;
            }

            @Override
            public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {
                //lol i dont care
            }

            @Override
            public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {
                //lol i dont care
            }

            @Override
            public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {
                //lol i dont care
            }
        });
        return parser.program();
    }
}
