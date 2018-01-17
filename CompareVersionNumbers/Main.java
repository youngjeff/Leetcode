package CompareVersionNumbers;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.compareVersion("1","1.00"));
    }
}
class Solution {
    public int compareVersion(String version1, String version2) {

        String[] a = version1.split("\\.");
        String[] b = version2.split("\\.");
        for (int i = 0,j = 0;i<a.length || j<b.length;)
        {
            int inta = Integer.parseInt(fun(a,i));
            int intb = Integer.parseInt(fun(b,j));
            if (inta > intb)
            {
                return 1;
            }
            else if (inta < intb)
            {
                return -1;
            }
            else{
                i++;j++;continue;
            }
        }
       return 0;

    }
    private String fun(String[] str,int j)
    {
        int i=0;
        if (j>=str.length)
        {
            return "0";
        }
        while (i < str[j].length() && str[j].charAt(i) == '0')
        {
            i++;
        }
        if (i >= str[j].length())
        {
            return "0";
        }
        return str[j].substring(i,str[j].length());
    }
}