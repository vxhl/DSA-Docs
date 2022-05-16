package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;

class shortestPathBinaryMatrix
{
    /*
    Ok what I understand is that this is possible with breadth first search
    The question is how and when should I be using problems involving DFS and BFS
    After I am done with the LinkedLists problems from today, let's practice
    problems associated with DFS and BFS specifically and how to identify
    these problems.
    */

    static int xdir[] = {-1,-1,0,1,1,1,0,-1};
    static int ydir[] = {0,-1,-1,-1,0,1,1,1};
    

    
    public static int shortestPathBinaryMatrix(int[][] grid)
    {
        // int ans = 0;
        
        if(grid[0][0] == 1) return -1; 
        
        
        Deque<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0,0,1});
         
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-->0)
            {
            int[] poll = q.poll();
            if(poll[0] == grid.length-1 && poll[1] == grid[0].length-1)
            {
                return poll[2];
            }
            
            for(int i=0; i<8; i++)
            {
                int newx = poll[0] + xdir[i];
                int newy = poll[1] + ydir[i];
                
                if(newx>=0 && newy>=0 && newx<grid.length && newy<grid[0].length && grid[newx][newy] == 0)
                {
                    q.add(new int[]{newx, newy, poll[2]+1});
                    grid[newx][newy] = 1; // We mark it as visited?
                }
            }
            }
        }
        
        return -1;
        
    }
}