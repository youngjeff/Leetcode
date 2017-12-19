package com.jeff.csv;

import java.util.ArrayList;
import java.util.List;

public class CSVImport implements CSVParser {

    public static final char DEFAULT_SEP = ',';
    protected final char fieldSep;

    public CSVImport(){
        this(DEFAULT_SEP);
    }

    public CSVImport(char sep){
        fieldSep =sep;
    }

    protected List<String> list = new ArrayList<>();



    @Override
    public List<String> parse(String line) {
        StringBuffer sb = new StringBuffer();
        list.clear();
        int i = 0;

        if(line.length() == 0){
            list.add(line);
            return list;
        }

        do{
            sb.setLength(0);
            if( i<line.length() && line.charAt(i) == '"')
                i = advAuoted(line, sb, ++i);
            else{
                i = advPlain(line, sb, i);
            }
            list.add(sb.toString());
            i++;
        }while(i<line.length());
        return list;
    }

    protected int advPlain(String s, StringBuffer sb, int i) {
        int j;

        j = s.indexOf(fieldSep, i);
        if( j==-1){
            sb.append(s.substring(i));
            return s.length();

        }
        else{
            sb.append(s.substring(i,j));
            return j;
        }
    }

    protected int advAuoted(String s, StringBuffer sb, int i) {
        int j;
        int len = s.length();
        for(j=i; j< len; j++){
            if(s.charAt(j) == '"' && j+1 < len){
                if(s.charAt(j+1) == '"'){
                    j++;
                }
                else if(s.charAt(j+1) == fieldSep){
                    j++;
                    break;
                }
            }
            else if(s.charAt(j) == '"' && j+1 ==len){
                j++;
                break;
            }
            sb.append(s.charAt(j));
        }
        return j;
    }
}
