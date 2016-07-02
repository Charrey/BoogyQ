package toplevel;

import divider.Divider;
import divider.DividerResult;
import exceptions.CompileError;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.tree.ParseTree;
import preprocessor.PreProcessor;
import sprocl.Assembler;
import sprocl.model.Program;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Administrator on 28-6-2016.
 */
public class CodeSnippetTester {


    private static List<String> parseerrors = Main.parseerrors;

    public static void main(String[] args) throws IOException {
        System.out.println(getResult("src/toplevel/gcd.boog"));
    }

    public static List<String> getResult(String Filename) throws IOException {
        File the_file = new File(Filename);

        byte[] encoded;
        encoded = Files.readAllBytes(Paths.get(the_file.getAbsolutePath()));
        String program = new String(encoded, Charset.defaultCharset());
        try {
            program = PreProcessor.process(program);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        parseerrors = new LinkedList<>();
        ParseTree parsed = Main.parse(program);

        if (!parseerrors.isEmpty()) {
            parseerrors.forEach(System.out::println);
        } else {
            DividerResult divresult = new Divider().generate(true, parsed, new HashMap<>());
                Map<OpListWrapper, Integer> coresassigned = CoreManager.instance.assignCores(divresult.getThreadTree());
                Map<Integer, Set<OpListWrapper>> coresassigned_good = CoreManager.invert(coresassigned);
                //NOTE: The MAIN thread runs on the core with the HIGHEST number.
                OpListWrapper main = divresult.getThreadTree().get();

                String withoutextension = the_file.getName().replace(".boog", "");
                String bettername = withoutextension.substring(0, 1).toUpperCase() + withoutextension.substring(1);
                String sproclcode = Assembler.assemble(coresassigned_good, bettername, main, divresult.globalVarCount());
                Main.writeToFile(sproclcode, bettername + ".hs");
                ProcessBuilder builder = new ProcessBuilder(
                        "cmd.exe", "/c", " runhaskell " + bettername + ".hs");
                builder.redirectErrorStream(true);

                Process p = builder.start();
                BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));

                List<String> res = new LinkedList<>();
                String read = stdInput.readLine();
                res.add(read);
                while (read != null) {
                    read = stdInput.readLine();
                    res.add(read);
                }
                p.destroy();
                return res.subList(res.size()-7, res.size()-1);//read.subList(read.size() - 4, read.size());
        }
        return null;
    }
}
