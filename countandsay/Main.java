package nod.countandsay;

import java.lang.String;
public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.countAndSay(4));
    }
}
class Solution {
    public String countAndSay(int n) {
        if(n == 1)
        {
            return "1";
        }
        else{
            String str = countAndSay(n-1)+"*";
            int count = 1;
            String result = "";
            for(int i=0;i<str.length()-1;i++)
            {
                if(str.charAt(i) == str.charAt(i+1)){
                    count++;
                }
                else{
                    result = result + String.valueOf(count) + str.charAt(i);
                    count = 1;
                }
            }
            return result;
        }
    }
}