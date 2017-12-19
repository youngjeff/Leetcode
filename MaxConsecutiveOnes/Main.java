package MaxConsecutiveOnes;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {1,1,0,1,1,1,1,1,0,0,0,0,0,0,0};
        System.out.println(sl.findMaxConsecutiveOnes(nums));
    }
}


class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0,count = 0;
        for(int i=0;i<nums.length;i++){
           if(nums[i] == 1)
           {
               sum = sum+1;
               if(count<sum)
                   count = sum;
           }
           else{
               sum = 0;
           }
        }
        return count;
    }
}