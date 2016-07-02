package divider;

import divider.Divider;
import divider.DividerResult;
import exceptions.CompileError;
import exceptions.parser.ParseException;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;
import org.testng.annotations.Test;
import parser.*;
import preprocessor.PreProcessor;
import sprocl.Assembler;
import sprocl.model.Program;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrator on 28-6-2016.
 */
public class CodeSnippitTest {

    @Test
    public void test1(){
        String filename = "";
        List<String> result = getResult("");
        String expectedMem = "[0,5,1,0,97,5,0,0,0,0,0,0,0,0,0,5]";
        String actualMem = getLocalMem(result.get(1));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test2(){
        String filename = "";
        List<String> result = getResult("");
        String expectedMem = "[0,5,5,1,1,97,97,97,97,0,0,0,0,0,0,97]";
        String actualMem = getLocalMem(result.get(1));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test3(){
        String filename = "";
        List<String> result = getResult("");
        String expectedMem = "[0,14,-11,0,0,-75,-4802,8,0,0,0,0,5,-11,3,8]";
        String actualMem = getLocalMem(result.get(1));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test5(){
        String filename = "";
        List<String> result = getResult("");
        String expectedMem = "[0,0,1,0,1,1,1,1,1,1,1,1,1,0,0,0]";
        String actualMem = getLocalMem(result.get(1));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test19(){
        String filename = "";
        List<String> result = getResult("");
        String expectedMem = "[0,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1]";
        String actualMem = getLocalMem(result.get(1));
        assertEquals(expectedMem, actualMem);
    }

    @Test
    public void test6(){
        String filename = "";
        List<String> result = getResult("");
        String expectedMem = "[0,65,98,0,98,98,1,1,1,1,98,1,1,0,65,0]";
        String actualMem = getLocalMem(result.get(1));
        assertEquals(expectedMem, actualMem);
    }


    private List<String> getResult(String fileName){
        return null;
    }

    private String getLocalMem(String input){
        return input.split("localMem = ")[1];
    }
}
