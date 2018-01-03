//f(x) = f(x-1) + f(x-2)
package DecodeWays;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        String temp = "aaaaaaaa";
        System.out.println(temp.substring(0,1));
        System.out.print(sl.numDecodings("11"));
    }
}
class Solution {
    int num = 0;
    public int numDecodings(String s) {
        if(s.length() == 0)
        {
            return 0;
        }
        if(Integer.valueOf(s.substring(0,1))==0)
        {
            return 0;
        }
        int[] result = new int[s.length()+1];
        result[0]=result[1]=1;
        for(int i=2;i<=s.length();i++)
        {
            int sum = 0;
            if(Integer.valueOf(s.substring(i-1,i))>0 )
            {
                sum += result[i-1];
            }
            if(Integer.valueOf(s.substring(i-2,i-1))>0)
            {
                if(Integer.valueOf(s.substring(i-2,i))<=26)
                {
                    sum += result[i-2];
                }
            }
            result[i] = sum;
        }
        return result[s.length()];
    }


}