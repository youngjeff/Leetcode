package MaximalSquare;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        char[][] list = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        System.out.println(sl.maximalSquare(list));
        System.out.print("asd");
    }
}
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
        {
            return 0;
        }
        int result = 0,length = 1;
        for (int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                while (fun(i,j,length,matrix))
                {
                    length++;

                }
                result = Math.max((length-1) * (length-1),result);
                length = 1;
            }
        }
        return result;
    }
    public boolean fun(int x,int y,int length,char[][] matrix)
    {

        for (int i=x;i<x+length;i++)
        {
            for (int j=y;j<y+length;j++)
            {
                if (i>=matrix.length || j>=matrix[0].length)
                {
                    return false;
                }
                if (matrix[i][j] == '0')
                {
                    return false;
                }
            }
        }
        return true;
    }

}