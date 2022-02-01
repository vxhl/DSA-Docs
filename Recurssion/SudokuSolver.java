package Recurssion;

class Solution
{
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0)
            return;
        solve(board);
    }
    
    public boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){//trial. Try 1 through 9
                        if(isValid(board, i, j, c)){
                            board[i][j] = c; //Put c for this cell
                            
                            if(solve(board))
                                return true; //If it's the solution return true
                            else
                                board[i][j] = '.'; //Otherwise go back
                        }
                    }
                    
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' && 
board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }
}


/* My shit 


public class SudokuSolver {
    

    public void SudokuSolver1(char[][] board)
    {
        solve(board);
    }

    static boolean solve(char[][] board)
    {
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c='1'; c<=9; c++)
                    {
                        if(isValid(board, i,j,c))
                        {
                            // Here comes the tricky part. 
                            // If we find our board as valid we add our element into that place but then again
                            board[i][j] = c;
                            // We set this if condition to check if the board satisfies all possible conditions from the recurssion tree and if it doesn't
                            if (solve(board)==true)
                            {
                                return true;
                            }
                            // we set an else condition and return back with emptying the element that we added in the previous step
                            else
                            {
                                board[i][j] = '.';
                            }
                        }
                    }
                    // If none of the conditions get satisfied we get out of our for loop and return a false for the current board
                    return false; 
                }
                
            }
        }
        // If our board has no empty spaces and is all filled up we just return true directly
        return true;
    }


    static boolean isValid(char[][] board, int row, int col, char c)
    {
        for(int i=0; i<9; i++)
        {
            // Here we set our 3 primary conditions for determining whether any given character
            // placed in a particular space of our sudoku puzzle is valid or not


            // This is a more convenient way for checking rows and cols since at any time one of the index remains unchanged
            if(board[row][i] == c)
            {
                return false;
            }
            if(board[i][col] == c)
            {
                return false;
            }

            // Here comes the tricky part with the checking of 3X3 blocks. Take this formula and do a dry run by taking one block at a time and see how it works
            if(board[3*(row/3)+ i/3 ][3*(col/3)+i%3] ==c ) return false;
        }
        return true;
    }

*/
}


