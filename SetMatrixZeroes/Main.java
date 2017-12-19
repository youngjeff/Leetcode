package SetMatrixZeroes;

public class Main {
    public static void main(String[] args)
    {
        Solution sl = new Solution();
        int[][] matrix = { {1,0},{1,1} };
        sl.setZeroes(matrix);
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.println(matrix[i][j]);
            }

        }

    }
}


class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 )
        {
            return;
        }
        if (matrix[0].length == 0)
        {
            return;
        }
        int[] cln = new int[matrix.length];
        int[] row = new int[matrix[0].length];

        for(int i=0;i<matrix.length;i++)
        {
            cln[i] = matrix[i][0];
        }
        for(int i=0;i<matrix[0].length;i++)
        {
            row[i] = matrix[0][i];
        }

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j] == 0)
                {
                    row[j] = 0;
                    cln[i] = 0;
                }
            }
        }

        for(int i=0;i<row.length;i++)
        {
            for(int j=0;j<matrix.length;j++)
            {
                if(row[i] == 0)
                {
                    matrix[j][i] = 0;
                }

            }
        }
        for(int i=0;i<cln.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(cln[i]==0)
                {
                    matrix[i][j] = 0;
                }

            }
        }

    }
}