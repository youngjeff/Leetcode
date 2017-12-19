package com.jeff.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVRE implements CSVParser{

    public static final String CSV_PATTERN = "\"([^\"]+?)\",?|([^,]+),?|,";
    private final static Pattern csvRE = Pattern.compile(CSV_PATTERN);
    public static void main(final String[] argv) throws IOException{
        System. out. println(CSV_PATTERN);
        new CSVRE().process(
                new BufferedReader(new InputStreamReader(System.in)));
    }

    public void process(final BufferedReader input) throws IOException {
        String line;

        while ((line = input.readLine()) != null){
            System.out.println("line = '" + line + "'");
            final List<String> list = parse(line);
            System.out.println("Found "+ list.size() + " items.");
            for (String str : list){
                System.out.println(str + ",");
            }
            System.out.println();
        }
    }

    @Override
    public List<String> parse(String line) {
        final List<String> list = new ArrayList<>();
        final Matcher m = csvRE.matcher(line);

        while (m.find()){
            String match = m.group();
            if(match == null){
                break;
            }
            if(match.endsWith(",")){
                match = match.substring(0, match.length() - 1);
            }
            if(match.startsWith("\"")){
                if(!match.endsWith("\"")){
                    throw new IllegalArgumentException("Quoted column missing end quote: " + line);
                }
                match = match.substring(1, match.length() -1);
            }
            if(match.length() == 0){
                match = "";
            }
            list.add(match);
        }
        return list;
    }


}
