package Searcha2DMatrixII;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(sl.searchMatrix(matrix,19));
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0 ||matrix[0].length==0)
        {
            return false;
        }
        for(int i=matrix[0].length-1;i>=0;i--)
        {
            if(target == matrix[0][i] || target == matrix[matrix.length-1][i])
            {
                return true;
            }
            else if(target>matrix[0][i] && target<matrix[matrix.length-1][i])
            {
                if(fun(matrix, target,0,matrix.length-1,i))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean fun(int[][] matrix, int target,int left,int right,int col)
    {
        if(left>right)
        {
            return false;
        }
        int mid = (left + right)/2;
        if(matrix[mid][col] == target)
        {
            return true;
        }
        else if(matrix[mid][col] > target)
        {
            return fun(matrix,target,left,mid-1,col);
        }
        else{
            return fun(matrix,target,mid+1,right,col);
        }
    }

}