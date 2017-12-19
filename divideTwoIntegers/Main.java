package nod.divideTwoIntegers;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.divide(15,1));
    }
}
class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1))
        {
            return Integer.MAX_VALUE;
        }
        long dividendLong = Math.abs((long) dividend);
        long divisoLong = Math.abs((long) divisor);
        int result = 0;
        while(dividendLong >= divisoLong)
        {
            int i = 0;
            while(dividendLong >= divisoLong << i)
            {
                i++;
            }
            dividendLong = dividendLong - (divisoLong << (--i));
            result+= 1<<(i);
        }
        if(dividend > 0 && divisor <0 || dividend < 0 && divisor > 0)
        {
            return -result;
        }
        else{
            return result;
        }
    }
}