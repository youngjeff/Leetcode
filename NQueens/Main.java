package NQueens;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        System.out.println(sl.solveNQueens(8));
    }
}

class Solution {
    public int count = 0;
    public ArrayList<List<String>> result = new ArrayList<>();
    public ArrayList<List<String>> solveNQueens(int n) {
        int[][] queen = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                queen[i][j] = 0;
            }
        }
        dfs(queen,0,n);
        return this.result;
    }
    void dfs(int[][] queen, int depth,int n)
    {
        if(depth == n)
        {
            this.count+=1;
            List<String> temp = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String str = "";
                for(int j=0;j<n;j++)
                {
                    if (queen[i][j] == 0)
                    {
                        str+=".";
                    }
                    else{
                        str+="Q";
                    }
                }
                temp.add(str);
            }
            result.add(temp);
        }
        else{
            for(int i=0;i<n;i++)
            {
                if(judge(i,depth,queen,n))
                {
                    queen[i][depth] = 1;
                    dfs(queen,depth+1,n);
                    queen[i][depth] = 0;
                }
            }
        }
    }
    Boolean judge(int i,int depth,int[][] queen,int n)
    {
        int k = 0;
        while(k<n){ if(queen[i][k] == 1) { return false; }if(queen[k][depth] == 1) { return false; }k++; }
        int x = i, y = depth;
        while(x>=0&&y>=0){ if(queen[x][y]==1) { return false; }x--;y--; }
        x = i;y=depth;
        while(x>=0&&y<n){ if(queen[x][y]==1) { return false; }x--;y++; }
        x = i;y=depth;
        while(x<n&&y>=0){ if(queen[x][y]==1) { return false; }x++;y--; }
        x = i;y=depth;
        while(x<n&&y<n){ if(queen[x][y]==1) { return false; }x++;y++; }
        return true;
    }
}