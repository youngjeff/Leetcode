package ValidSudoku;

public class Main {
    public static void main(String[] args)
    {
        char[][] board = {{'.','8','7','6','5','4','3','2','1'},{'2','.','.','.','.','.','.','.','.'},{'3','.','.','.','.','.','.','.','.'},{'4','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},{'6','.','.','.','.','.','.','.','.'},{'7','.','.','.','.','.','.','.','.'},{'8','.','.','.','.','.','.','.','.'},{'9','.','.','.','.','.','.','.','.'}};

        Solution sl = new Solution();
        if(sl.isValidSudoku(board))
        {
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null)
        {
            return false;
        }

        for(int i=0;i<9;i++)
        {
            int[] row = new int[9];
            for(int k=0;k<9;k++)
                row[k] = 1;
            for(int j=0;j<9;j++)
            {
                if(board[i][j] == '.')
                {
                    continue;
                }
                row[board[i][j]-'0'-1]--;
                if(row[board[i][j]-'0'-1] < 0 )
                {
                    return false;
                }
            }

        }

        for(int i=0;i<9;i++)
        {
            int[] column = new int[9];
            for(int k=0;k<9;k++)
                column[k] = 1;
            for(int j=0;j<9;j++)
            {
                if(board[j][i] == '.')
                {
                    continue;
                }
                column[board[j][i] -'0'-1 ]--;
                if(column[board[j][i] -'0'-1 ] < 0)
                {
                    return false;
                }
            }

        }

        for(int i=0;i<9;i=i+3)
        {
            int[] box = new int[9];

            for(int j=0;j<9;j=j+3)
            {
                int tempi = i,tempj = j;
                int k = 0;
                while(tempi<i+3)
                {
                    while(tempj<j+3)
                    {
                        box[k] = 1;
                        k++;
                        tempj++;
                    }
                    tempj=j;
                    tempi++;
                }


                tempi = i;tempj = j;
                while(tempi<i+3)
                {
                    while(tempj<j+3)
                    {

                        if(board[tempi][tempj] == '.')
                        {
                            tempj++;
                            continue;
                        }
                        box[board[tempi][tempj]-'0'-1 ]--;
                        if(box[board[tempi][tempj] -'0'-1 ] < 0)
                        {
                            return false;
                        }
                        tempj++;
                    }
                    tempj=j;
                    tempi++;
                }

            }

        }
        return true;
    }
}