package SpiralMatrixII;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[][] data = sl.generateMatrix(1);
        for(int i=0;i<1;i++)
        {
            for(int j=0;j<1;j++)
            {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }
}


class Solution {
    public int[][] generateMatrix(int n) {


        int[][] matrix = new int[n][n];
            if(n == 0)
                return matrix;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                matrix[i][j] = 0;
            }
        }

        int count = n*n,bound = 0,i=-1,j=0,num=1;
        while(count>0)
        {
            while(i+1<matrix[0].length-bound&&count>0) { i++;matrix[j][i] = num;num++;count--; }
            while(j+1<matrix.length-bound&&count>0) { j++;matrix[j][i] = num;num++;count--; }
            while(i-1>=bound&&count>0) { i--;matrix[j][i] = num;num++;count--; }
            while(j-1>bound&&count>0) { j--;matrix[j][i] = num;num++;count--; }
            bound++;
        }
        return matrix;
    }
}