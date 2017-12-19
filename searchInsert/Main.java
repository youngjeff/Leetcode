package nod.searchInsert;

public class Main {
    public static void main(String[] args)
    {
        int[] a = new int[]{1};
        Solution sl = new Solution();
        System.out.println(sl.searchInsert(a,2));
    }
}
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i;
        for(i=0;i<nums.length;)
        {
            if(nums[i] < target)
            {
                i++;
                continue;
            }
            else if (nums[i] == target)
            {
                return i;
            }
            else{
                return i;
            }
        }
        return i;
    }
}