package test;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by poesd_000 on 21/06/2016.
 */
public class kloten {

    public static void main(String[] args) {
        Charset set = Charset.forName("UTF-32");
        char[] arr = {'6'};
        ByteBuffer result = set.encode(CharBuffer.wrap(arr));
        System.out.println(result.getInt());
    }

    int ipow(int base, int exp)
    {
        int result = 1;
        while (exp!=0)
        {
            if ((exp & 1) !=0)
                result *= base;
            exp >>= 1;
            base *= base;
        }

        return result;
    }
}
