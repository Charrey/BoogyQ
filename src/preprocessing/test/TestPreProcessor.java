package preprocessing.test;

import exceptions.ParseException;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.Assert;
import preprocessing.PreProcessor;

/**
 * Created by poesd_000 on 14/06/2016.
 */
public class TestPreProcessor extends TestCase {

    @Test
    public void testRemoveTabs() throws ParseException {
        String test = "\r\nif (a>b):\r\n\t5 -> a.\r\n\tif (a>b):\r\n\t\t6 -> b.\r\n5 -> a.";
        String expected = "\nif (a>b):\nOPENSCOPE\n5 -> a.\nif (a>b):\nOPENSCOPE\n6 -> b.\nCLOSESCOPE\nCLOSESCOPE\n5 -> a.";
        assertEquals(expected, PreProcessor.removeTabs(test));
    }

    @Test
    public void testDeclarations() throws ParseException {
        String test = "int a.";
        String expected = "0 -> int a.";
        assertEquals(expected, PreProcessor.betterDeclarations(test));
        test = "char b.";
        expected = "'A' -> char b.";
        assertEquals(expected, PreProcessor.betterDeclarations(test));
        test = "int[4][9] sudoku.";
        expected = "[0]*4*9 -> int[][] sudoku.";
        assertEquals(expected, PreProcessor.betterDeclarations(test));
        test = "char[4][9] weirdsudoku.";
        expected = "['A']*4*9 -> char[][] weirdsudoku.";
        assertEquals(expected, PreProcessor.betterDeclarations(test));
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
