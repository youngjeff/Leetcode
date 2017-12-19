package SearchinRotatedSortedArrayI;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args)
    {
        int[] nums = {1,3,1,1,1};
        Solution sl = new Solution();
        System.out.println(sl.search(nums, 3));
    }
}


class Solution {
    public boolean search(int[] nums, int target) {

        int[] result = fun(nums);
        int left = 0, right = result.length-1;
        int i = dfs(0,right, result, target);
        if(i == -1)
        {
            return false;
        }
        else{
            return true;
        }

    }
    int[] fun(int[] nums)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!list.contains(nums[i]))
            {
                list.add(nums[i]);
            }
        }

        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            result[i] = list.get(i);
        }
        return result;

    }
    int dfs(int left,int right,int[] nums,int target)
    {
        if(left>right)
        {
            return -1;
        }
        int middle = (left + right) / 2;
        if(nums[middle] == target)
        {
            return middle;
        }
        if(nums[left] <= nums[middle])
        {
            if(target >= nums[left] && target <= nums[middle])
            {

                return dfs(left,middle-1,nums,target);
            }
            else{

                return dfs(middle+1,right,nums,target);
            }
        }
        else{
            if(target >= nums[middle] && target <= nums[right])
            {

                return dfs(middle+1,right,nums,target);
            }
            else{

                return dfs(left,middle-1,nums,target);
            }
        }


    }
}