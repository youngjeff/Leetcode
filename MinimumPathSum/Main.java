package MinimumPathSum;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[][] data = {{1}};

        System.out.println(sl.minPathSum(data));
    }
}
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        int[][] data = new int[m][n];
        for(int i=0;i>m;i++)
        {
            for(int j=0;j<n;j++)
            {
                data[i][j] = 0;
            }
        }
        for (int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {

                    if (i == 0 && j == 0)
                    {
                        data[i][j] = grid[i][j];
                    }
                    else if(i==0)
                    {
                        data[i][j] = data[i][j-1] + grid[i][j];
                    }
                    else if(j==0)
                    {
                        data[i][j] = data[i-1][j] + grid[i][j];
                    }
                    else{
                        data[i][j] = Math.min(data[i-1][j],data[i][j-1])+ grid[i][j];
                    }


            }
        }
        return data[m-1][n-1];
    }
}