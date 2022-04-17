package DSA450Restart.Strings;
import java.util.*;
class SearchWordGrid
{
    /*
    Let me just think about this for the time that is left. 
    When we reach a character, that is equal to our first character in the pattern
    we have the choice of moving in one of 8 directions.
    We keep moving in those directions as long we have true, if we find false, then we start backtracking
    and removing the position that we have already added in our resultant array. 
    
    There is a lot to think about here so let's take all the examples - 

    abab
    abeb   pattern -> abe  directions -> (i+1, j+1), (i-1, j-1), (i-1, j+1),(i+1, j-1)
    ebeb                                  (i, j+1)(i+1, j)(i-1, j)(i, j-1)
    
    When are we supposed to move? When our 
    if(pattern[i] == board[i][j]) 
        ans.add(0,0); 
        dfs(board, i, j, count, word); 
        ans.remove(ans.size()-1); 
    
    */

    
    static int[][] exist(char[][] grid, String word)
    {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<grid.length; i++)
        {
            for(int j=0; j<grid[i].length; j++)
            {
                if(grid[i][j] == word.charAt(0) && dfs())
                {
                    ArrayList<Integer> ds = new ArrayList<>();
                    ds.add(i);
                    ds.add(j);
                    ans.add(ds);
                }
            }
        }

        int[][] ans1 = new int[ans.size()][ans.size()];
        for(int i=0; i<ans.size(); i++)
        {
            ans1[i][j]
        }
    }




}