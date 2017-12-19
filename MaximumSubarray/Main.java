package MaximumSubarray;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int temp = 0;
            for(int j=i;j<nums.length;j++)
            {
                temp+=nums[j];
                if(temp>sum)
                {
                    sum=temp;
                }
            }
        }
        return sum;
    }
}