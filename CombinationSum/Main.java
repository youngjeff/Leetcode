package CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> list = sl.combinationSum(nums,7);
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i));
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> alllist = new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        alllist = dfs(candidates,target,0,list, alllist);
        return alllist;
    }
    public List<List<Integer>> dfs(int[] candidates, int target,int i,List<Integer> list,List<List<Integer>> alllist)
    {
        int sum = 0;
        for(int j=0;j<list.size();j++)
        {
            sum+=list.get(j);
        }
        if(sum == target)
        {
            List<Integer> copyList = new ArrayList<>();
            copyList.addAll(list);
            alllist.add(copyList);

        }
        else if(sum < target)
        {
            for(int j=i;j<candidates.length;j++)
            {
                if(sum+candidates[j]>target)
                {
                    continue;
                }
                list.add(candidates[j]);
                dfs(candidates,target,j,list,alllist);
                list.remove(list.size()-1);
            }
        }
        return alllist;
    }
}