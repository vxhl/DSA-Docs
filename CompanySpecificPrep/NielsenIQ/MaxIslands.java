import java.util.*;
class Solution {
    public int numIslands(char[][] grid) {    
        // we can move in 4 directions
        int[] xDir = {1,0,-1,0};
        int[] yDir = {0,1,0,-1};
        Queue<int[]> q = new LinkedList<>();
        int islands = 0;
    for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    islands++;
                    q.offer(new int[]{i,j});
                    grid[i][j]='X';
                    while(!q.isEmpty()){
                        int[] curr = q.poll();    
                        int x = curr[0];
                        int y = curr[1];
                        for(int k=0; k<4;   k++){
                            int newx = x+xDir[k];
                            int newy = y+yDir[k];
                            if(newx>=0 && newx<grid.length && newy>=0 && newy<grid[0].length && grid[newx][newy]=='1'){
                                q.offer(new int[]{newx,newy});
                                grid[newx][newy]='X';
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}




// When can we say we have formed 1 island? 
        /*
         We can do a BFS and keep traversing until we terminate and keep all the
         cells that we traversed till now as visited.
         Then we start checking for the grids that we have not visited, and see if there are 1's there
         and again start our traversal from there
       
          ["1","1","0","0","0"],
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]
            
            
        Maybe instead of using the visited array, we instead mark the visited
        islands as -1 that works better
          ["1","1","0","0","0"]
          ["1","1","0","0","0"],
          ["0","0","1","0","0"],
          ["0","0","0","1","1"]
         
         We again traverse and find till the end whether there are any 1s left, if we find
         we again put it into the queue and start traversing again to find the island
            
       */