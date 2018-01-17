package FindMinimuminRotatedSortedArray;

public class Man {
}
class Solution {
    public int findMin(int[] nums) {
        if (nums == null ||nums.length == 0)
        {
            return 0;
        }
        int result = nums[0];
        for (int i=0;i<nums.length;i++)
        {
            if (result>nums[i])
            {
                return nums[i];
            }
        }
        return nums[0];
    }
}