package PlusOne;

public class Main {
    public static void main(String[] args)
    {
        Solution sl  = new Solution();
        int[] digits = {9,9,9,9,9,8,9};
        int[] result = sl.plusOne(digits);
        for(int i=0;i<result.length;i++)
        {
            System.out.println(result[i]);
        }

    }
}

class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1] += 1;
        for(int i=digits.length-1;i>=1;i--)
        {
            if(digits[i] >= 10)
            {
                digits[i] -= 10;
                digits[i-1]++;
            }
            else
            {
                return digits;
            }
        }
        if(digits[0]>=10)
        {
            int[] nums = new int[digits.length+1];
            for(int i=0;i<nums.length;i++)
            {
                nums[i] = 0;
            }
            nums[0] = 1;
            return nums;
        }
        else{
            return digits;
        }
    }
}