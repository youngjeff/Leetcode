package RotateImage;

public class Main {
    public  static  void main(String[] args)
    {
        int[][] matrix = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        Solution sl = new Solution();
        sl.rotate(matrix);
    }
}
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int temp = 0;
        for(int i = 0; i <= (n-1)/2 ; i++ ){
            for(int j = i ; j < n - 1 - i; j++){
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}