package ReverseWordsinaString;

public class Main {
    public static void main(String[] args)
    {
        Solution sl =new Solution();
        System.out.print(sl.reverseWords(" 1 "));
    }
}
 class Solution {
    public String reverseWords(String s) {
        if(s.trim() == null || s.trim().equals(""))
        {
            return "";
        }
        String[] list = s.split(" ");
        String temp = "";
        for(int i=list.length-1;i>=0;i--)
        {
            temp += list[i]+" ";
        }
        return temp.substring(0,temp.length()-1);
    }
}