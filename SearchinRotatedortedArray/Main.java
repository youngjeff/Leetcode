package SearchinRotatedortedArray;


public class Main {
    public static void main(String[] args)
    {
        int[] nums = {7,8,9,10,1,2,3,4,5,6};
        Solution sl = new Solution();
        System.out.println(sl.search(nums, 5));
    }
}


class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int i = dfs(0,right, nums, target);
        return i;

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