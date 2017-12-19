package com.jeff.lang;

import java.util.Map;

public class GetOptDemoNew {
    public static void main(String[] argv){
        boolean numeric_option = false;
        boolean errs = false;
        String ouputFileName = null;

        GetOptDesc[] options = {
                new GetOptDesc('n', "numeric", false),
                new GetOptDesc('o', "output-file", true),
        };
        GetOpt parser = new GetOpt(options);
        Map<String, String> optionsFound = parser.parseArguments(argv);
        for(String key : optionsFound.keySet()){
            char c = key.charAt(0);
            switch(c){
                case 'n':
                    numeric_option = true;
                    break;
                case 'o':
                    ouputFileName = (String)optionsFound.get(key);
                    break;
                default:
                    throw new IllegalStateException(
                            "Unexpected option character: " + c
                    );
            }
        }
        if(errs){
            System.err.println("Usage: GetOptDemo [-n][-o file][file...]");
        }
        System.out.println("options; ");
        System.out.println("Numeric: "+ numeric_option + ' ');
        System.out.println("Output: "+ ouputFileName + "; ");
        System.out.println("Input files: ");
        for(String fileName : parser.getFilenameList()){
            System.out.print(fileName);
            System.out.println(' ');
        }
    }
}
