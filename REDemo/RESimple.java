package REDemo;

import java.util.regex.Pattern;

public class RESimple {
    public static void main(String[] argv){
        String pattern = "^Q[^u]\\d+\\.";
        String[] input = {
                "QA777. is the next flight. It is on time." ,
                "Quack, Quack, Quack!"
        };

        Pattern p = Pattern.compile(pattern);

        for(String in : input){
            boolean found = p.matcher(in).lookingAt();

            System.out.println("'" + pattern + "'" +
                    (found ? "matches '":" doesn't match '") + in + "'");
        }

    }
}
