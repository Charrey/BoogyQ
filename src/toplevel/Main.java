package toplevel;

import divider.Divider;
import divider.DividerResult;
import exceptions.CompileError;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.*;
import preprocessor.PreProcessor;
import sprocl.Assembler;
import sprocl.model.Program;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Used as I/O class to be used by the user.
 */
public class Main {

    /**
     * Scanner used to gain input from the user.
     */
    private static Scanner scanner = new Scanner(System.in);
    /**
     * List of strings the parser writes to when encountering parse errors.
     */
    private static List<String> parseerrors = new LinkedList<>();
    /**
     * Parser used to parse code from a file.
     */
    private static BoogyQParser parser;

    /**
     * Allows the user to compile a .boog program in a user friendly way.
     * @param args - not used.
     */
    public static void main(String[] args) {
        System.out.println("Reading files...");
        File dir = new File("src/toplevel/.");
        File [] files = dir.listFiles((dir1, name) -> {
            return name.endsWith(".boog");
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
                byte[] encoded;
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

                    if (!parseerrors.isEmpty()) {
                        parseerrors.forEach(System.out::println);
                    } else {
                        DividerResult divresult = new Divider().generate(true, parsed, new HashMap<>());
                        if (divresult.hasErrors()) {
                            for (CompileError err : divresult.getErrors()) {
                                System.out.println(err.getLineNumber() + " - " + err.getMessage());
                            }
                            System.out.println("Could not compile, program had errors.");
                        } else {
                            System.out.println("Program has no errors.");


                            Map<OpListWrapper, Integer> coresassigned = CoreManager.instance.assignCores(divresult.getThreadTree());
                            Map<Integer, Set<OpListWrapper>> coresassigned_good = CoreManager.invert(coresassigned);
                            //NOTE: The MAIN thread runs on the core with the HIGHEST number.
                            OpListWrapper main = divresult.getThreadTree().get();

                            System.out.println("-----MAIN Program:----------");
                            System.out.println(Program.fromOpList(main.getOps()).prettyPrint());
                            String withoutextension = the_file.getName().replace(".boog", "");
                            String bettername = withoutextension.substring(0, 1).toUpperCase() + withoutextension.substring(1);
                            String sproclcode = Assembler.assemble(coresassigned_good, bettername, main, divresult.globalVarCount());
                            System.out.println("-----Sprocl Code:---------------");
                            System.out.println(sproclcode);
                            System.out.println("----------------------------");
                            writeToFile(sproclcode, bettername + ".hs");
                            ProcessBuilder builder = new ProcessBuilder(
                                    "cmd.exe", "/c", " runhaskell " + bettername + ".hs");
                            builder.redirectErrorStream(true);

                            Process p = builder.start();
                            BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                            String read = stdInput.readLine();
                            while (read != null) {
                                System.out.println(read);
                                read = stdInput.readLine();
                            }
                            p.destroy();

                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error while reading file.");

                }

                label:
                while (true) {
                    System.out.println("Awaiting input...");
                    String input = scanner.nextLine();
                    switch (input) {
                        case ":r":
                            break label;
                        case "exit":
                            exit = true;
                            break;
                        default:
                            System.out.println("Unknown input.");
                            break;
                    }
                }
            }
        }
    }

    /**
     * Gets information from the user which file to compile.
     * @param files All possible files to choose from.
     * @return A file which the user chose.
     */
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

    /**
     * Writes a string to a file.
     * @param input The content of the file.
     * @param filename The file name.
     * @throws IOException Thrown when no such write can be done.
     */
    private static void writeToFile(String input, String filename) throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(filename);
            out.write(input);
        }
        finally {
            if (out!=null) {
                out.close();
            }
        }
    }

    /**
     * Parses text into a parsetree.
     * @param text The given program.
     * @return A parse tree representing that program.
     */
    private static ParseTree parse(String text) {
        CharStream stream = new ANTLRInputStream(text);
        Lexer lexer = new BoogyQLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);
        parser = new BoogyQParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                parseerrors.add(getRealLine(text, e.getOffendingToken().getLine()) + " - Syntax error at input: " + e.getOffendingToken().getText());
            }

            private int getRealLine(String text, int i) {
                while(text.contains("OPENSCOPE")) {
                    text = text.replaceFirst("OPENSCOPE", "");
                    i--;
                }
                while(text.contains("CLOSESCOPE")) {
                    text = text.replaceFirst("CLOSESCOPE", "");
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
