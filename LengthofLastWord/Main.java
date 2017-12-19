package LengthofLastWord;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.lengthOfLastWord("  a   "));
    }
}
class Solution {
    public int lengthOfLastWord(String s) {
        if(s.length() == 0)
        {
            return 0;
        }
        int i = s.length()-1;
        while (s.charAt(i) == ' '&&i>0)
        {
           i--;
        }
        if(s.charAt(i) == ' ')
            i--;
        if(i>=0)
        {
            int j = i;
            while (s.charAt(j) != ' ' && j>0)
            {
                j--;
            }
            if(s.charAt(j) != ' ')
                j--;
            return i-j;
        }
        return 0;
    }
}