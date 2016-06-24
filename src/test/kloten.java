package test;

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
        System.out.println(ByteBuffer.wrap("A".getBytes("UTF-32")).getInt());
    }
}
