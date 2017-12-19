package com.jeff.lang;

public class GetOptDesc {
    private char argLetter;
    private String argName;
    private boolean takesArgument;

    public GetOptDesc(char ch, String nm, boolean ta){
        if(!Character.isLetter(ch) && !Character.isDigit(ch)){
            throw new IllegalArgumentException(ch + ": not letter or digit");
        }
        argLetter = ch;
        argName = nm;
        takesArgument = ta;
    }

    public char getArgLetter(){
        return argLetter;
    }

    public String getArgName(){
        return argName;
    }
    public boolean takesArgument(){
        return takesArgument;
    }
}
