package PermutationsII;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static  void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.getPermutation(3,5));
    }
}

class Solution {
    public String getPermutation(int n, int k) {
        String str = "";
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++)
            list.add(i+1);
        int result ,reminder,index = n;
        while(list.size() > 0)
        {
            result = k / fun(index-1);
            reminder = k % fun(index-1);
            if(reminder > 0)
                result++;
            str += Integer.toString(list.get(result-1));
            list.remove(result-1);
            if(reminder == 0)
                k = fun(index-1);
            else{
                k = reminder;
            }

            index--;
        }

        return str;
    }
    int fun(int n)
    {
        int result = 1 ;
        if(n <= 0)
        {
            return 1;
        }
        for(int i=1;i<=n;i++)
        {
            result = result * i;
        }
        return result;
    }
}