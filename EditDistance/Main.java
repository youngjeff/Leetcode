package EditDistance;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static  void main(String[] args)
    {
        String line = "[00000服务异常]>00000000";
        String pattern = "\\d+";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            System.out.println(m.group(0));
        }

    }
}

