package PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Main {
}
class Solution {
    List<List<String>> list = new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0)
        {
            return null;
        }
        else{
            List<String> temp = new ArrayList<>();
            dfs(s,temp);
            return list;
        }
    }
    private void dfs(String s,List<String> temp)
    {
        if(s.length() == 0)
        {
            List<String> str = new ArrayList<String>(temp);
            list.add(str);
        }
        else{
                for(int i=1;i<=s.length();i++)
            {
                String str = s.substring(0,i);
                if(palindromic(str))
                {
                    temp.add(str);
                    dfs(s.substring(i,s.length()),temp);
                    temp.remove(temp.size()-1);
                }
            }
        }
    }
    private boolean palindromic(String str)
    {
        for (int i=0;i<str.length()/2;i++)
        {
            if(str.charAt(i) != str.charAt(str.length()-1-i))
            {
                return false;
            }
        }
        return true;
    }
}
