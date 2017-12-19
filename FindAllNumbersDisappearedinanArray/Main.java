package FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(sl.findDisappearedNumbers(nums));

    }
}
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;)
        {
            if(nums[i] != i+1)
            {
                if(nums[nums[i]-1] != nums[i])
                {
                    swap(nums,i,nums[i]-1);
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] != i+1)
            {
                list.add(i+1);
            }
        }
        return list;
    }
    void swap(int[] nums,int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}