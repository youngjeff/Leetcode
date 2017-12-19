package PropsCompaniesDemo;

import java.util.Properties;

public class PropsCompanies {
    public static void main(String[] argc) throws java.io.IOException{
        Properties props = new Properties();

        props.put("Adobe", "Mountin View ,CA");
        props.load(System.in);
        props.list(System.out);
    }
}
