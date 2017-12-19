package Searcha2DMatrix;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[][] matrix = {
                {1,   3,  5,  7},
        {10, 11, 16, 20},
            {23, 30, 34, 50}
            };
        System.out.println(sl.searchMatrix(matrix,2));
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 ||matrix[0].length==0)
        {
            return false;
        }
        for(int i=matrix.length-1;i>=0;i--)
        {
            if(target == matrix[i][0])
            {
                return true;
            }
            else if(target>matrix[i][0])
            {
                return fun(matrix[i], target,0,matrix[i].length-1);
            }
        }
        return false;
    }
    public boolean fun(int[] matrix, int target,int left,int right)
    {
        if(left>right)
        {
            return false;
        }
        int mid = (left + right)/2;
        if(matrix[mid] == target)
        {
            return true;
        }
        else if(matrix[mid] > target)
        {
            return fun(matrix,target,left,mid-1);
        }
        else{
            return fun(matrix,target,mid+1,right);
        }
    }

}