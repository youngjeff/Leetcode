package Subsets;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {1,2,3};
        System.out.println(sl.subsets(nums));
    }
}

class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> tmp = new ArrayList<>();
        list.add(tmp);
        dfs(0,nums,tmp);

        return list;
    }
    public void dfs(int i,int[] nums,List<Integer> tmp)
    {
        if(i>=nums.length)
        {
            return;
        }
        else{
            for (int j=i;j<nums.length;j++)
            {
                tmp.add(nums[j]);
                List<Integer> temp = new ArrayList<>(tmp);
                list.add(temp);
                dfs(j+1,nums,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
}