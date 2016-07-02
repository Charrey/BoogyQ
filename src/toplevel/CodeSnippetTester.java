package toplevel;

import divider.Divider;
import divider.DividerResult;
import exceptions.CompileError;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
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

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 28-6-2016.
 */
public class CodeSnippetTester {


    private static List<String> parseerrors = Main.parseerrors;

    private String getLocalMem(String input) {
        return input.split("localMem = ")[1].split("}")[0];
    }

    @Test
    public void test1() throws IOException {
        String filename = "src/toplevel/test1.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,5,1,0,97,5,0,0,0,0,0,0,0,0,0,5]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test2() throws IOException {
        String filename = "src/toplevel/test2.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,5,5,1,1,97,97,97,97,0,0,0,0,0,0,97]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test3() throws IOException {
        String filename = "src/toplevel/test3.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,14,-11,0,0,-75,-4802,8,0,0,0,0,5,-11,3,8]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test5() throws IOException {
        String filename = "src/toplevel/test5.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test19() throws IOException {
        String filename = "src/toplevel/test19.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test6() throws IOException {
        String filename = "src/toplevel/test6.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,65,98,0,98,98,1,1,1,1,98,1,1,0,65,0]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test7() throws IOException {
        String filename = "src/toplevel/test7.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,2,5,1,1,0,0,0,0,0,0,0,0,2,1,5]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test9() throws IOException {
        String filename = "src/toplevel/test9.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,5,5,5,0,0,0,0,0,0,0,0,0,0,0,1]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test17() throws IOException {
        String filename = "src/toplevel/test17.boog";
        List<String> result = getResult(filename);
        String expectedMem = "[0,1,1,1,1,1,1,1,0,0,0,0,0,3,9765625,1]";
        String actualMem = getLocalMem(result.get(0));
        assertEquals(expectedMem, actualMem);
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
