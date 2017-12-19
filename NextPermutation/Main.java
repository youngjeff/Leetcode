package nod.NextPermutation;

import java.util.Arrays;

public class Main {
    public static int nums[] = {2,3,1};
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        sl.nextPermutation(nums);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]);
        }
    }
}
class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 ||nums.length == 1)
        {
            return;
        }
        int i,j;
        for(i=nums.length-1;i>=1;i--)
        {
            if(nums[i] > nums[i-1])
            {
                break;
            }
        }
        if(i==0)
        {
            Arrays.sort(nums);
            return ;
        }
        else{
            i--;
                for(j=nums.length-1;j>i;j--)
                {
                    if(nums[j] > nums[i])
                    {
                        int temp = nums[j];
                        nums[j] = nums[i];
                        nums[i] = temp;
                        break;
                    }

                }
            Arrays.sort(nums,i+1,nums.length);//前一个指数能到达，后一个指数不能达到
        }
    }
}