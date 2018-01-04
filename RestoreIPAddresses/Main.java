package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        List result = sl.restoreIpAddresses("25525511135");
        System.out.print(result);
    }
}
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<>();
        String str = "";
        dfs(0,0,str,s,list);
        return list;
    }
    void dfs(int index,int num, String str,String s ,List<String> list)
    {
        if(index > s.length())
        {
            return;
        }
        else if(num>4)
        {
            return;
        }
        else if(index == s.length() && num == 4)
        {
            list.add(str.substring(0,str.length()-1));
        }
        else {
            for (int i = 1; i < 4; i++)
            {
                if(index+i<=s.length())
                {
                    int val = Integer.valueOf(s.substring(index,index+i));
                    if( val<256 && i== String.valueOf(val).length())
                    {
                        dfs(index+i,num+1,str+s.substring(index,index+i)+".",s,list);
                    }
                }

            }
        }
    }
}
