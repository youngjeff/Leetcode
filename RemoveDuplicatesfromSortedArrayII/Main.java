package RemoveDuplicatesfromSortedArrayII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {1,1,1,2};
        System.out.println(sl.removeDuplicates(nums));
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int length = 0;
        int[] data = new int[nums.length];
        for(int i=0,j=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {

                if(map.get(nums[i]) == 1)
                {
                    map.put(nums[i],2);
                    length++;
                    data[j]=nums[i];
                    j++;
                }

            }
            else
            {
                map.put(nums[i],1);
                length++;
                data[j]=nums[i];
                j++;
            }
        }
        nums = data;
        return length;
    }
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}