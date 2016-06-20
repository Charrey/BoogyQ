package preprocessing.test;

import exceptions.ParseException;
import org.junit.Test;
import preprocessing.PreProcessor;
import static org.junit.Assert.*;

public class TestPreProcessor {

    @Test
    public void testRemoveTabs() throws ParseException {
        String test = "\r\nif (a>b):\r\n\t5 -> a.\r\n\tif (a>b):\r\n\t\t6 -> b.\r\n5 -> a.";
        String expected = "\nif (a>b):\nOPENSCOPE\n5 -> a.\nif (a>b):\nOPENSCOPE\n6 -> b.\nCLOSESCOPE\nCLOSESCOPE\n5 -> a.";
        assertEquals(expected, PreProcessor.removeTabs(test));
        test = "\r\nif (a>b):\r\n\t5 -> a.\r\n\tif (a>b):\r\n\t<-  loop;\t\r\n5 -> a.";
        System.out.println(test);
        System.out.println(PreProcessor.removeTabs(test));
    }

    @Test
    public void testDeclarations() throws ParseException {
        String test = "int a.";
        String expected = "0 -> int a.";
        assertEquals(expected, PreProcessor.process(test));
        test = "char b.";
        expected = "'A' -> char b.";
        assertEquals(expected, PreProcessor.process(test));
        test = "int[4][9] sudoku.";
        expected = "{0}*4*9 -> int[][] sudoku.";
        assertEquals(expected, PreProcessor.process(test));
        test = "char[4][9] weirdsudoku.";
        expected = "{'A'}*4*9 -> char[][] weirdsudoku.";
        assertEquals(expected, PreProcessor.process(test));
    }

    @Test
    public void testFixLoops() throws ParseException {
        System.out.println("------------------------");
        String a = "<-  \t\t\tbreak.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t<-  \t\tbreak.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t\t<-  \tbreak.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t\t\t<-  break.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t\t\t\t<loop.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");

        System.out.println("Tabs instead of spaces:");
        System.out.println("------------------------");

        a = "<-\t\t\t\tbreak.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t<-\t\t\tbreak.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t\t<-\t\tbreak.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t\t\t<-\tbreak.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
        a = "\t\t\t\t<loop.";
        System.out.println(a + "\nbecomes\n" + PreProcessor.fixLoops(a) + "\n------------------------");
    }

    @Test
    public void testComments() throws ParseException {
        String test = "if(4>3):\n\t5->a.\n\t\t\t//Good day there!\n\t6->b.";
        System.out.println(test + "\n");
        System.out.println(PreProcessor.removeTabs(test));
    }

    public static void fails(String s) {
        try {
            PreProcessor.removeTabs(s);
        } catch(ParseException e) {
            return;
        }
        fail();
    }
}
