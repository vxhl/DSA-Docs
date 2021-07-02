/*
Problem Statement: 
in a NxN square grid each cell is either empty(0) or blocked(1)
We are to clear a path from the top-left to bottom-right of the grid 
provided the top-left and bottom-right cells are not blocked. 

Example: 
{{0, 1, 1, 1}, 
 {0, 0, 0, 1},   =>> Here the shortest path is 4
 {1, 1, 1, 0}};

Time Complexity: O(M*N)
*/
package Graph_Theory;

import java.util.LinkedList;
import java.util.Queue;

class ShortestPathInBinaryMatrix 
{
    static int ShortestCellPathinBinaryMatrix(int[][] grid) 
    {
        if(grid[0][0]==1) return -1;
        // We get the length of the 2D matrix and the 1D matrix inside them
        // To get the coordinates of the elements we want. 
        int m = grid.length; 
        int n = grid[0].length;
        Queue<int[]>q = new LinkedList<>();
        // We first create add the coordinates for our first top most element
        // into the queue and assign count 1 as the 3rd element in the array that we are supposed to return 
        q.add(new int[]{0,0,1}); 
        // We then mark the first cell as visited
        grid[0][0] = 1;
        // We assign a direction array that specifies the different directions
        // a given element can move in our matrix
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        while(!q.isEmpty())
        {
            int size = q.size();
            while(size-- >0)
            {
                int[] point = q.poll();
                // We give condition for if we have reached the target element
                if(point[0]==m-1 && point[1]==n-1) return point[2];

                // Now for the boundary cases
                for(int[] d: dir)
                {
                    // We get the coordinates with the respective directions
                    int r =point[0] + d[0]; 
                    int c = point[1] + d[1];
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==0)
                    {
                    q.add(new int[]{r,c,point[2]+1}); // We increment our count (point[2]+1) on each iteration
                    grid[r][c] = 1; // And set the visited cells as 1
                }
            }
            }
        }
        return -1;
        
    }
    public static void main(String[] args) {
        int[][]grid =   {{0, 1, 1, 1}, 
                         {0, 0, 0, 1}, 
                         {1, 1, 1, 0}};
        System.out.println("The shortest path to the end of the binary maze: "+ShortestCellPathinBinaryMatrix(grid));
    }  
}
