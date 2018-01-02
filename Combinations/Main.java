package Combinations;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.combine(4,2));
    }

}


class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> test = new ArrayList<>();
        dfs(n,k,test,1);
        return list;
    }
    public void dfs(int n,int k,List<Integer> test,int num)
    {
        if(test.size() == k)
        {
            List<Integer> temp = new ArrayList<>(test);
                list.add(temp);
        }
        if(test.size()>k)
        {
            return ;
        }
        else
        {
            for(int i=num;i<=n;i++)
            {
                if(!test.contains(i))
                {
                    test.add(i);
                    dfs(n,k,test,i+1);
                    test.remove(test.size()-1);
                }

            }
        }
        return;
    }
}