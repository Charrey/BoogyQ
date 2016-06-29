package toplevel;

import checker.DeclChecker;
import checker.JumpChecker;
import checker.TypeChecker;
import divider.Divider;
import divider.DividerResult;
import exceptions.CompileException;
import exceptions.generator.RegisterException;
import exceptions.parser.ParseException;
import generator.Generator;
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

                    DividerResult divresult = new Divider().generate(true, parsed, new HashMap<>()).getKey();
                    if (divresult.hasErrors()) {
                        for (CompileException err : divresult.getErrors()) {
                            System.out.println(err);
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

                        String sproclcode = Assembler.assemble(coresassigned_good, bettername, main);
                        System.out.println("-----Sprocl Code:---------------");
                        System.out.println(sproclcode);
                        System.out.println("----------------------------");
                        writeToFile(sproclcode,bettername + ".hs");
                        ProcessBuilder builder = new ProcessBuilder(
                                "cmd.exe", "/c", " runhaskell " + bettername + ".hs");
                        builder.redirectErrorStream(true);

                        Process p = builder.start();
                        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String read = stdInput.readLine();
                        while (read!=null) {
                            System.out.println(read);
                            read = stdInput.readLine();
                        }
                        p.destroy();

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



    private static void writeToFile(String input, String filename) throws IOException {
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
        //parser.removeErrorListeners();
        parser.addErrorListener(new ANTLRErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e) {
                parseerrors.add("Syntax error at input: " + e.getOffendingToken().getText());
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
