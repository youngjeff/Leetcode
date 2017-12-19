package Permutations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args)
    {
        int[] nums = {1,1,3};
        Solution sl = new Solution();

        List<List<Integer>> list = sl.permute(nums);
        for(int i=0;i< list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }

}


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int[] target = new int[nums.length];
        for(int i=0;i<target.length;i++)
        {
            target[i] = 1;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result = dfs(nums,target,list,result);
        return result;
    }

    List<List<Integer>> dfs(int[] nums,int[] target,List<Integer> list,List<List<Integer>> result)
    {
        if(list.size() == nums.length)
        {
            if(!result.contains(list))
            {
                List<Integer> copyList = new ArrayList<Integer>();
                copyList.addAll(list);
                result.add(copyList);
            }

        }
        else{
            for(int j=0;j<nums.length;j++){
                if(target[j] > 0)
                {
                    list.add(nums[j]);
                    target[j]--;
                    dfs(nums,target,list,result);
                    target[j]++;
                    list.remove(list.size()-1);
                }
            }
        }
        return result;
    }

}

