package SingleNumberII;

import java.util.Arrays;

public class Main {
}
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;)
        {
            if(nums[i] == nums[i+1] && nums[i] == nums[i+2])
            {
                i=i+3;
            }
            else{
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}