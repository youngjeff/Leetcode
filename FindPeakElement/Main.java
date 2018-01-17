package FindPeakElement;

import java.util.Arrays;

public class Main {
}
class Solution {
    public int findPeakElement(int[] nums)
    {
        int max=Integer.MIN_VALUE, index=0;
        for (int i=0;i< nums.length;i++)
        {
            if (nums[i]>max)
            {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}