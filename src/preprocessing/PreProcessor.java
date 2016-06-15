package preprocessing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import exceptions.ParseException;

/**
 * Created by poesd_000 on 14/06/2016.
 */
public final class PreProcessor {


    //static String test1 = "\r\nif (a>b):\r\n\t5 -> a.\r\n\tif (a>b):\r\n\t\t6 -> b.\r\n5 -> a.";
    static String test1 = "int[3][400] a.\nint b.\nchar c.\nchar[100][30] weirdsudoku.";


    public static void main(String[] args) throws ParseException {
        System.out.println(betterDeclarations(test1));
    }

    public static String removeTabs(String input) throws ParseException {
        input = input.replaceAll("\r", "");
        String[] splitted = input.split("\n");
        String result = "";
        int indenting = 0;
        for (int i = 0; i<splitted.length; i++) {
            int localindenting = 0;
            while(splitted[i].startsWith("\t")) {
                localindenting++;
                splitted[i] = splitted[i].substring(1);
            }
            while (localindenting>indenting) {
                result+="OPENSCOPE\n";
                indenting++;
            }
            while (localindenting<indenting) {
                result+="CLOSESCOPE\n";
                indenting--;
            }
            result+=splitted[i]+"\n";
        }
        return result.substring(0, result.length()-1);
    }

    public static String betterDeclarations(String input) throws ParseException {
        String[] splitted = input.split("\n");
        String res = "";
        for (int i = 0; i<splitted.length; i++) {

            try {

                if (splitted[i].startsWith("int ")) {
                    splitted[i] = "0 -> " + splitted[i];
                }
                if (splitted[i].startsWith("char ")) {
                    splitted[i] = "\'A\' -> " + splitted[i];
                }

                String type = null;
                if (splitted[i].startsWith("int")) {
                    type = "int";
                } else if (splitted[i].startsWith("char")) {
                    type = "char";
                }


                if (type != null) {
                    List<String> args = new LinkedList<>();
                    String copy = new String(splitted[i]).substring(type.length());
                    while (copy.startsWith("[")) {
                        String arg = copy.substring(1, copy.indexOf("]"));
                        args.add(arg);
                        copy = copy.substring(copy.indexOf("]") + 1);
                    }
                    splitted[i] = " -> " + splitted[i].replaceAll("\\[[0-9]+\\]", "[]");
                    String prepend = null;
                    switch (type) {
                        case "int":
                            prepend = "[0]";
                            break;
                        case "char":
                            prepend = "[\'A\']";
                            break;

                    }
                    for (int p = 0; p < args.size(); p++) {
                        prepend += "*" + args.get(p);
                    }
                    splitted[i] = prepend + splitted[i];
                }
                res += splitted[i] + "\n";
            }catch (ArrayIndexOutOfBoundsException e) {
                throw new ParseException("Invalid shortened declaration in line"+i);
            }
            }
        return res.substring(0, res.length()-1);
    }

}
