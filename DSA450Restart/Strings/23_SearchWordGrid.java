package DSA450Restart.Strings;
import java.util.*;
class Solution_Search2DGrid
{
    public int[][] searchWord(char[][] grid, String word)
    {

        // First we just intialise our ans array as l
        ArrayList<Pair> l = new ArrayList<>();
        
        // Then we look at each character int he grid and
        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++)
            // For each possible direction we do the following
                for(int k=0;k<8;k++)
                    if(s(k,grid,word,i,j,0,grid.length,grid[0].length,word.length()))
                        l.add(new Pair(i,j));
                        
        int[][] a = new int[l.size()][2];
        
        for(int i=0;i<l.size();i++){
            a[i][0] = l.get(i).x; 
            a[i][1] = l.get(i).y;
        }
        
        return a;
    }
    
    public boolean s(int k,char[][] a,String w,int i,int j,int p,int n,int m,int s){
        if(p == s) // If our words length is equal to the current length we return true
            return true;
            
        // if our of bounds we return false
        if(i<0 || j<0 || i==n || j==m)
            return false;
        
        // If we find the character at current index to be equal, we
        // run 8 cases for the value of k, that represents the current swithch case
        // for every switch case we have 8 directions that we can move and each of them return a boolean value
        // and add to our resultant length which is p. Ofc we only go forward with the cases if our current position
        // matches with the words current position
        if(w.charAt(p) == a[i][j]){
            switch(k){
                case 0:
                    return s(k,a,w,i+1,j,p+1,n,m,s) ;
                case 1:
                    return s(k,a,w,i,j+1,p+1,n,m,s);
                case 2:
                    return s(k,a,w,i-1,j,p+1,n,m,s);
                case 3:
                    return s(k,a,w,i,j-1,p+1,n,m,s);
                case 4:
                    return s(k,a,w,i+1,j+1,p+1,n,m,s) ;
                case 5:
                    return s(k,a,w,i-1,j+1,p+1,n,m,s) ;
                case 6:
                    return s(k,a,w,i+1,j-1,p+1,n,m,s) ;
                default :
                    return s(k,a,w,i-1,j-1,p+1,n,m,s);
            }
        }
        else
            return false;
    }
}

class Pair{
    int x,y;
    
    Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}

class GFG {
 
    // Rows and columns in the given grid
    static int R, C;
 
    // For searching in all 8 direction
    static int[] x = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] y = { -1, 0, 1, -1, 1, -1, 0, 1 };
 
    // This function searches in all
    // 8-direction from point
    // (row, col) in grid[][]
    static boolean search2D(char[][] grid, int row,
                            int col, String word)
    {
        // If first character of word
        // doesn't match with
        // given starting point in grid.
        if (grid[row][col] != word.charAt(0))
            return false;
 
        int len = word.length();
 
        // Search word in all 8 directions
        // starting from (row, col)
        for (int dir = 0; dir < 8; dir++) {
            // Initialize starting point
            // for current direction
            int k;
            int rd = row + x[dir]; 
            int cd = col + y[dir];
 
            // First character is already checked,
            // match remaining characters
            for (k = 1; k < len; k++) {
                // If out of bound break
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;
 
                // If not matched, break
                if (grid[rd][cd] != word.charAt(k))
                    break;
 
                // Moving in particular direction
                rd += x[dir];
                cd += y[dir];
            }
 
            // If all character matched,
            // then value of must
            // be equal to length of word
            if (k == len)
                return true;
        }
        return false;
    }
 
    // Searches given word in a given
    // matrix in all 8 directions
    static int[][] patternSearch(
        char[][] grid,
        String word)
    {
        // Consider every point as starting
        // point and search given word
        ArrayList<Pair> ans = new ArrayList<>();
        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {
                if (grid[row][col]==word.charAt(0)  &&
                    search2D(grid, row, col, word))
                        ans.add(new Pair(row, col));
            }
        }

        int[][] ans1 = new int[ans.size()][2];
        for(int i=0; i<ans.size(); i++)
        {
            ans1[i][0] = ans.get(i).x;
            ans1[i][1] = ans.get(i).y;
        }

        return ans1;
    }
 
}