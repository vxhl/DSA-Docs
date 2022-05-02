package Recurssion;
import java.util.*;

class NQueens {
    
    private static void solveNQueenUtil(int col, char[][] board, List<List<String>> ans, int[] upperDiagonal, int[] lowerDiagonal, int[] leftRow, int n)
    {
        // Base Case
        if(col==board.length)
        {
            ans.add(construct(board)); // We add the valid board for n queens into our resultant list
            return;
        }
        
        // we run for the number of columns again ofc
        for(int row = 0; row<board.length; row++)
        {
            // If all the three directions are ok
            if(leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[(n-1)+col-row]==0)
            {
                // first we set down our queen in the position
                board[row][col] = 'Q';
                // We set our previous hashes as visited
                leftRow[row] = 1;
                lowerDiagonal[row+col] = 1;
                upperDiagonal[board.length-1+col-row] = 1;
                // We run the recursion
                solveNQueenUtil(col+1, board, ans, upperDiagonal, lowerDiagonal, leftRow, n);
                // We again remove our queen when we are done and backtrack
                board[row][col] = '.';
                // We also reset our hash for the next index to be called
                leftRow[row] = 0;
                lowerDiagonal[row+col] = 0;
                upperDiagonal[board.length-1+col-row] = 0;
                
            }
        }
        
        
    }
    
    // We construct our board in the form of List<String>
    
    private static List<String> construct(char[][] board)
    {
        List<String> res = new LinkedList<String>();
        for(int i=0; i<board.length; i++)
        {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        int[] leftRow = new int[n];
        solveNQueenUtil(0, board, ans, upperDiagonal, lowerDiagonal, leftRow, n);
        return ans;
    }
}