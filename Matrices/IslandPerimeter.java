/*
Problem Statement - 
You are given row x col grid 
representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
Output: 16
Explanation: The perimeter is the 16 yellow stripes in the image above.

*/

package Matrices;

public class IslandPerimeter {
    static int IslandPerimeter1(int[][] grid)
    {

        // Boundary Conditions
        if(grid == null || grid.length==0 || grid[0].length==0) return 0;
        int perimeter = 0;

        // Let us loop through the matrix and add 4 to perimeter every time we encounter 1 in the said matrix
        for(int i = 0; i<grid.length; i++)
        {
            for(int j = 0 ; j<grid[i].length; j++)
            {
                if(grid[i][j]==1)
                {
                   perimeter+=4; 
                    
                   if(i>0 && grid[i-1][j] ==1)
                   {
                       perimeter-=2;
                   }
                   if(j>0 && grid[i][j-1]==1)
                   {
                       perimeter-=2;
                   }


                }
            }
    }
    
    return perimeter;
}
    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(IslandPerimeter1(grid));
    
    }
}
