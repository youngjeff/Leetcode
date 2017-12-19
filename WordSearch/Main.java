package WordSearch;

public class Main {
    public  static void main(String[] args)
    {
        Solution sl = new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.print(sl.exist(board,word));
    }
}
class Solution {
    boolean[][] table;
    boolean temp = false;
    public boolean exist(char[][] board, String word) {
        if(board == null || board[0] == null)
        {
            return false;
        }

        table = new boolean[board.length][board[0].length];
        for(int i=0;i>board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                table[i][j] = false;
            }
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {

                dfs(board,word,i,j,0);
                if(temp)
                {
                    return true;
                }
            }
        }
        return  false;
    }
    public void dfs(char[][] board, String word, int x,int y,int num)
    {
        if(temp)
        {
            return ;
        }
        if(num > word.length())
        {

            return ;
        }
        if(num == word.length())
        {

            temp = true;
            return ;
        }
        if(board[x][y] == word.charAt(num))
        {
            if(num+1 == word.length())
            {

                temp = true;
                return ;
            }
            if(x-1>=0)
            {
                if(!table[x-1][y])
                {
                    table[x][y] = true;
                    dfs(board,word,x-1,y,num+1);
                    table[x][y] = false;
                }
            }
            if(y-1>=0)
            {
                if(!table[x][y-1])
                {
                    table[x][y] = true;
                    dfs(board,word,x,y-1,num+1);
                    table[x][y] = false;
                }
            }
            if(x+1<board.length)
            {
                if(!table[x+1][y])
                {
                    table[x][y] = true;
                    dfs(board,word,x+1,y,num+1);
                    table[x][y] = false;
                }
            }
            if(y+1<board[0].length)
            {
                if(!table[x][y+1])
                {
                    table[x][y] = true;
                    dfs(board,word,x,y+1,num+1);
                    table[x][y] = false;
                }
            }
        }

        return ;
    }
}