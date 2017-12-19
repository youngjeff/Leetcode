package UniquePaths;



public class Main {
   public static void main(String[] args)
   {
       Solution sl = new Solution();
       System.out.println(sl.uniquePaths(23,12));
   }
}
class Solution {

    public int uniquePaths(int m, int n) {
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
       return data[m-1][n-1];
    }
}