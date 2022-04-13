package Leetcode_DailyChallenges.AprilChalleges;

class Solution_GameOfLife
{


    // Using Extra Space
    public static void gameOfLife(int[][] board) {
        int[][] ans = new int[board.length][board[0].length];
        
        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                // First we handle the boundary conditions 
                int curr = 0;
                curr = call(board, i-1, j-1) + call(board, i+1, j+1) + call(board, i+1, j-1) + call(board, i-1, j+1) + call(board, i, j+1) + call(board, i+1, j) + call(board, i-1, j)+
                call(board, i, j-1); 
                    if(board[i][j] == 1)
                    {
                        if(curr == 2 || curr == 3)
                        {
                            ans[i][j] = board[i][j];
                        }
                        else
                        {
                            ans[i][j] = 0;
                        }
                    }
                    else
                    {
                        if(curr == 3)
                        {
                            ans[i][j] = 1;
                        }
                        else
                        {
                            ans[i][j] = board[i][j];
                        }
                    }
                }
        }

        for(int i=0; i<board.length; i++)
            {
                for(int j=0; j<board[0].length; j++)
                {
                    board[i][j] = ans[i][j];                   
                }
            }
        }



        private static int call(int[][] board, int i, int j)
        {
            if(i>=0 && j>=0 && i<board.length && j<board[0].length)
            {
                return board[i][j];
            }
            return 0;
        }


        // Without using extra space
        public static void gameOfLife2(int[][] board) {
        
            for(int i=0; i<board.length; i++)
            {
                for(int j=0; j<board[0].length; j++)
                {
                    // First we handle the boundary conditions 
                    int curr = 0;
                    curr = call(board, i-1, j-1) + call(board, i+1, j+1) + call(board, i+1, j-1) + call(board, i-1, j+1) + call(board, i, j+1) + call(board, i+1, j) + call(board, i-1, j)+
                    call(board, i, j-1); 
                        if(board[i][j] == 1)
                        {
                            if(curr == 2 || curr == 3)
                            {
                                board[i][j] = board[i][j];
                            }
                            else
                            {
                                board[i][j] = -1;
                            }
                        }
                        else
                        {
                            if(curr == 3)
                            {
                                board[i][j] = 2;
                            }
                        }
                    }
            }
            
            for(int i=0; i<board.length; i++)
            {
                for(int j=0; j<board[0].length; j++)
                {
                    if(board[i][j] == 2)
                    {
                        board[i][j] = 1;
                    }
                    else if(board[i][j] == -1)
                    {
                        board[i][j] = 0;
                    }
                }
            }
            }
    
    
            private static int call2(int[][] board, int i, int j)
            {
                if(i>=0 && j>=0 && i<board.length && j<board[0].length)
                {
                    if(board[i][j] == 2)
                    {
                        return 0;
                    }
                    else if(board[i][j] == -1)
                    {
                        return 1;
                    }
                    else
                    {
                        return board[i][j];
                    }
                }
                return 0;
            }





    public static void main(String[] args) {
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(board);

        for(int i=0; i<board.length; i++)
        {
            for(int j=0; j<board[0].length; j++)
            {
                System.out.print(board[i][j]+ " ");
            }

            System.out.println();
        }
        
    }
}