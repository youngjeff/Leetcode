package UniquePathsII;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[][] data = new int[3][3];
        for(int i=0;i>3;i++)
        {
            for(int j=0;j<3;j++)
            {
                data[i][j] = 0;
            }
        }
        data[1][1] = 1;
        System.out.println(sl.uniquePathsWithObstacles(data));
    }
}

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length,n = obstacleGrid[0].length;
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
                if(obstacleGrid[i][j] == 0)
                {
                    if (i == 0 && j == 0)
                    {
                        data[i][j] = 1;
                    }
                    else if(i==0)
                    {
                        data[i][j] = data[i][j-1];
                    }
                    else if(j==0)
                    {
                        data[i][j] = data[i-1][j];
                    }
                    else{
                        data[i][j] = data[i-1][j]+data[i][j-1];
                    }
                }

            }
        }
        return data[m-1][n-1];
    }
}