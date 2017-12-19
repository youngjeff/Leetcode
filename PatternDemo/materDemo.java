package PatternDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class materDemo {
    public static void main(String[] args)
    {
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        Matcher isNum = pattern.matcher("123123121fg3");
        if (!isNum.matches()) {
            System.out.println("no");
        }
        else{
            System.out.println("Yes");
        }

    }
   ;
}
