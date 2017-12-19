package StrTok;

import java.util.StringTokenizer;

public class StrTokDemo {
    public final static int MAXFILELDS = 5;
    public final static String DELIM = "|";

    public static String[] process(String line){
        String[] results = new String[MAXFILELDS];

        StringTokenizer st = new StringTokenizer(line, DELIM, true);

        int i = 0;
        while (st.hasMoreTokens()){
            String s = st.nextToken();
            if (s.equals(DELIM)){
                if(i++>=MAXFILELDS){
                    throw new IllegalArgumentException("Input line "+ line + " has too many fields");
                }
                continue;
            }
            results[i] = s;
        }
        return results;
    }

    public static void printResult(String input, String[] outputs){
        System.out.println("Input:" + input);
        for(String s : outputs){
            System.out.println("Output " + s + " was " + s);
        }
    }

    public static void main(String[] a){
        printResult("A|B|C|D", process("A|B|C|D"));
        printResult("A||C|D", process("A||C|D"));
        printResult("A}}}D|E", process("A|||D|E"));
    }
}
