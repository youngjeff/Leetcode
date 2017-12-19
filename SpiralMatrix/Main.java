package SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[][] data = {
                { }
            };
        System.out.println(sl.spiralOrder(data));
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) { return result; }
        int count = matrix.length * matrix[0].length,bound = 0,i=-1,j=0;
        while(count>0)
        {
            while(i+1<matrix[0].length-bound&&count>0) { i++;result.add(matrix[j][i]);count--; }
            while(j+1<matrix.length-bound&&count>0) { j++;result.add(matrix[j][i]);count--; }
            while(i-1>=bound&&count>0) { i--;result.add(matrix[j][i]);count--; }
            while(j-1>bound&&count>0) { j--;result.add(matrix[j][i]);count--; }
            bound++;
        }
        return result;
    }
}