package preprocessor;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import exceptions.parser.ParseException;

/**
 * Class responsible for fixing several issues with code before parsing.
 */
public final class PreProcessor {

    /**
     * @param input The input BoogyQ program.
     * @return A BoogyQ program with fixed OPENSCOPE and CLOSESCOPE, fixed loop statements and fixed array declarations.
     * @throws ParseException Thrown when indenting is wrong.
     */
      public static String process(String input) throws ParseException {
        return betterDeclarations(removeTabs(fixLoops(input)));
    }

    /**
     * Removes Tabs and replaces them with "OPENSCOPE" whenever a scope is opened and "CLOSESCOPE" whenever a scope is closed.
     * @param input The input BoogyQ program.
     * @return A BoogyQ program with fixed OPENSCOPE and CLOSESCOPE.
     * @throws ParseException Thrown when indenting is wrong.
     */
    public static String removeTabs(String input) throws ParseException {
        input = input.replaceAll("\r", "");
        String[] splitted = (input + "\n ").split("\n");
        String result = "";
        int indenting = 0;
        Pattern pat = Pattern.compile("\t*//.*");
        for (int i = 0; i<splitted.length; i++) {
            int localindenting = 0;

            Matcher mat = pat.matcher(splitted[i]);
            if (mat.matches()) {
                result += splitted[i].substring(splitted[i].indexOf('/')) + "\n";
                continue;
            }

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
        return result.substring(0, result.length()-3);
    }

    /**
     * Replaces arrow-notation of loops- and breaks to alternate, grammar-friendly notations.
     * @param input The input BoogyQ program.
     * @return A BoogyQ program with arrow-notation of loop- and break to alternate, grammar-friendly notation.
     * @throws ParseException Thrown when indenting is wrong.
     */
    public static String fixLoops(String input) throws ParseException {
        String[] splitted = input.replaceAll("\r","").split("\n");
        for (int i = 0; i<splitted.length; i++) {
            if (splitted[i].matches("\t*<break.")) {
                splitted[i] = splitted[i].replace("<break.", "break{0}.");
                continue;
            }
            if (splitted[i].matches("\t*<loop.")) {
                splitted[i] = splitted[i].replace("<loop.", "loop{0}.");
                continue;
            }
            if (splitted[i].matches("\t*<-  \t*break.")) {
                int jumpback = splitted[i].indexOf("break")-splitted[i].indexOf("<-")-3;
                splitted[i] = splitted[i].replace("<-  ", "\t").replace("break.", "break{"+jumpback+"}.");
                continue;
            }
            if (splitted[i].matches("\t*<-  \t*loop.")) {
                int jumpback = splitted[i].indexOf("loop")-splitted[i].indexOf("<-")-3;
                splitted[i] = splitted[i].replace("<-  ", "\t").replace("loop.", "loop{"+jumpback+"}.");
                continue;
            }
            if (splitted[i].matches("\t*<-\t\t*break.")) {
                int jumpback = splitted[i].indexOf("break")-splitted[i].indexOf("<-")-2;
                splitted[i] = splitted[i].replace("<-\t", "\t").replace("break.", "break{"+jumpback+"}.");
                continue;
            }
            if (splitted[i].matches("\t*<-\t\t*loop.")) {
                int jumpback = splitted[i].indexOf("loop")-splitted[i].indexOf("<-")-2;
                splitted[i] = splitted[i].replace("<-\t", "\t").replace("loop.", "loop{"+jumpback+"}.");
            }


        }
        String res = "";
        for (String i : splitted) {
            res += i+"\n";
        }
        return res.substring(0, res.length()-1);
    }

    /**
     * Replaces alternate array-declaration to alternate, grammar-friendly notations.
     * @param input The input BoogyQ program.
     * @return A BoogyQ program with only one form of array notation.
     * @throws ParseException Thrown when indenting is wrong.
     */
    private static String betterDeclarations(String input) throws ParseException {
        String[] splitted = input.split("\n");
        String res = "";
        for (int i = 0; i<splitted.length; i++) {

            try {
                String type = null;
                if (splitted[i].startsWith("int[")) {
                    type = "int";
                } else if (splitted[i].startsWith("char[")) {
                    type = "char";
                }

                if (type != null) {
                    List<String> args = new LinkedList<>();
                    String copy = splitted[i].substring(type.length());
                    while (copy.startsWith("[")) {
                        String arg = copy.substring(1, copy.indexOf("]"));
                        args.add(arg);
                        copy = copy.substring(copy.indexOf("]") + 1);
                    }
                    splitted[i] = " -> " + splitted[i].replaceAll("\\[[0-9]+\\]", "[]");
                    String prepend = null;
                    switch (type) {
                        case "int":
                            prepend = "{0}";
                            break;
                        case "char":
                            prepend = "{\'A\'}";
                            break;

                    }
                    for (String arg : args) {
                        prepend += "*" + arg;
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
