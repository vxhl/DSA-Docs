/*
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
*/
package Matrices;
import java.util.*;

public class RottingOranges 
{
    public static int orangesRotting(int[][] grid)
    {
        // We need the following: 
        // The total non empty cells in the matrix
        // The count variables for the mins
        // The count_queue for total elements we inserted and found as rotten
        if(grid == null || grid.length == 0) return 0;
        Queue<int[]> q = new LinkedList<>();
        int oranges = 0; 
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0; i<rows; i++)
        {
            for(int j=0; j<cols; j++)
            {
                if(grid[i][j] == 2) q.offer(new int[]{i,j});
                
                
                if(grid[i][j] != 0)
                    oranges ++;
            }
        }
        
        
        if(oranges == 0) return 0;
        int count_rotten = 0;  
        int mins = 0;
        // These are the 4 directions we can move in
        int dx[] = {0,0,1,-1};
        int dy[] = {1,-1,0,0};
        

        while(!q.isEmpty())
        {
            int size = q.size();
            count_rotten += size; // This keeps track of the total rotten oranges that we get and compare it to our actual total oranges value in the end
            
            for(int i=0; i<size; size++)
            {
                int[] point = q.poll();
                for(int j = 0; j<4; j++)
                {
                    int ni = point[0] + dx[j];
                    int nj = point[1] + dy[j];
                // We now set the boundary conditions
                    if(ni<0 || nj <0 || ni>=rows || nj>=cols || grid[ni][nj]==0 || grid[ni][nj] == 2) continue;
                
                    grid[ni][nj] = 2; // We set them as rotten
                    q.offer(new int[]{ni, nj});
                }
            }
            if(q.size()!=0) 
            {
                mins ++;
            }
        }
    
        return oranges == count_rotten ? mins: -1;
}

public static void main(String[] args) {
    int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
    String[] str1 = new String[]{"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
    int res = 0;
    int max = 0;
    for( String s: str1)
    {
        String[] s1 = s.split(" ");
        res = s1.length;
        max = Math.max(max, res); 
    }
    System.out.println();
}
}
