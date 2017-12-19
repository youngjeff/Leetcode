package com.jeff.csv;

import java.util.List;

public class CSVSimple {
    public static void main(String[] args){
        CSVImport parser = new CSVImport();
        List<String> list = parser.parse("\"LU\",86.25,\"11/4/1998\",\"2:19PM\",+4.0625" );

        for (String word : list){
            System.out.println(word);
        }

        parser = new CSVImport('|');
        list = parser.parse("\"LU\"|86.25|\"11/4/1998\"|\"2:19PM\"|+4.0625" );
        for(String word : list){
            System.out.println(word);
        }
    }
}
