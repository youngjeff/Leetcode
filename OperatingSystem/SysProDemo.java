package OperatingSystem;

import java.io.IOException;

public class SysProDemo {
    public static void main(String[] argv) throws IOException{
        if(argv.length == 0)
        {
            System.getProperties().list(System.out);

        }
        else{
            for(String s:argv)
            {
                System.out.println(s+" = "+System.getProperty(s));
            }
        }
    }
}
