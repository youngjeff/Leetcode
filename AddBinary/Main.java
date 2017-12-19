package AddBinary;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.addBinary("11","1"));
    }

}

class Solution {
    public String addBinary(String a, String b) {
        List<String> data = new ArrayList<>();
        int temp = 0;
        int i=0;
        for(;i<a.length() && i<b.length();i++)
        {
            int sum = (a.charAt(a.length()-1-i)-'0' + b.charAt(b.length()-1-i)-'0' + temp) % 2;
            temp = (a.charAt(a.length()-1-i)-'0' + b.charAt(b.length()-1-i)-'0' + temp) / 2;
            data.add(String.valueOf(sum));
        }
        String str = a.length()-i>b.length()-i?a.substring(0,a.length()-i):b.substring(0,b.length()-i);
        for(int j=0;j<str.length();j++)
        {
            int sum = (str.charAt(str.length()-1-j) - '0' + temp) % 2;
            temp = (str.charAt(str.length()-1-j) - '0' + temp) / 2;
            data.add(String.valueOf(sum));
        }
        if(temp != 0)
        {
            data.add(String.valueOf(temp));
        }
        Collections.reverse(data);
        String result = "";
        for(int j=0;j<data.size();j++)
        {
            result += data.get(j);
        }
        return result;
    }
}
