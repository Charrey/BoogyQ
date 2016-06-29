package test;

import toplevel.Tree;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by poesd_000 on 21/06/2016.
 */
public class kloten {

    public static void main(String[] args) throws UnsupportedEncodingException {
        Tree<Integer> mytree = new Tree<>(4);
        mytree.addChild(5);
        mytree.addChild(5);
    }
}
