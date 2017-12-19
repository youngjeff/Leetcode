package JumpGame;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {2,3,1,1,4};
        System.out.println(sl.canJump(nums));
    }
}
class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] data = new Boolean[nums.length];
        for (int i=0;i<data.length;i++) {
            data[i] = false;
        }
        data[0] = true;
        for(int i=0;i<nums.length;i++)
        {
            if(data[i] == true)
            {
                for(int j=i;j<=nums[i]+i && j<nums.length ;j++)
                {
                    if(data[j]==false)
                    {
                        data[j] = true;
                    }

                }
            }
        }
        return data[data.length-1];
    }
}