package CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> list = sl.combinationSum2(nums,8);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
}

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> alllist = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();

        alllist = dfs(candidates,target,list, alllist,0);
        return alllist;
    }
    public List<List<Integer>> dfs(int[] candidates, int target,List<Integer> list,List<List<Integer>> alllist,int i)
    {
        int sum = 0;
        for(int j=0;j<list.size();j++)
        {
            sum+=list.get(j);
        }
        if(sum == target)
        {
            if(!alllist.contains(list))
            {
                List<Integer> copyList = new ArrayList<>();
                copyList.addAll(list);
                alllist.add(copyList);
            }
        }
        else if(sum < target)
        {
            for(int j=i;j<candidates.length;j++)
            {
                if(sum+candidates[j]<=target)
                {
                    if(candidates[j]>0)
                    {
                        list.add(candidates[j]);
                        int temp = candidates[j];
                        candidates[j] = 0;
                        dfs(candidates,target,list,alllist,j+1);
                        candidates[j] = temp;
                        list.remove(list.size()-1);
                    }
                }
            }
        }
        return alllist;
    }
}