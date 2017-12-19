package ClimbingStairs;

public class Main {
}
class Solution {
    public int climbStairs(int n) {
        int[] num = new int[n];
        for(int i=0;i<n;i++)
        {
            num[i] = 0;
        }
        if(n==0)
        {
            return 0;
        }
        if(n==1)
        {
            return 1;
        }
        if(n==2)
        {
            return 2;
        }
        num[0] = 1;num[1] = 2;
        for(int i=2;i<n;i++)
        {
            num[i] = num[i-1]+num[i-2];
        }
        return num[n-1];
    }
}