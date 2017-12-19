package MultiplyStrings;

import javax.swing.plaf.SliderUI;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.multiply("5","12"));
    }
}
class Solution {
    public String multiply(String num1, String num2) {
        int[] nums = new int[num1.length()+num2.length()];
        for(int i=0;i<nums.length;i++)
        {
            nums[i] = 0;
        }
        for(int i=num1.length()-1;i>=0;i--)
        {
            for(int j=num2.length()-1;j>=0;j--)
            {
                int temp = num1.length()-1-i+num2.length()-1-j;
                nums[temp] = nums[temp] + (num1.charAt(i)-'0') * (num2.charAt(j)- '0');
            }
        }

        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i] >= 10)
            {
                nums[i+1] = nums[i+1] + (nums[i])/10;
                nums[i] = nums[i] % 10;
            }
        }
        String str = "";
        int i = nums.length-1;
        while(nums[i] == 0 )
        {
            if(i-1>=0)
            {
                i--;
            }
            else{
                break;
            }

        }
        if(i == -1)
        {
            str = "0";
            return str;
        }
        for(;i>=0;i--)
        {
           str += Integer.toString(nums[i]);
        }
        return str;
    }
}