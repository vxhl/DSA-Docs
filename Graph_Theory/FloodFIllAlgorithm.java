/*
Problem Statement:
An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor. 
You should perform a flood fill on the image starting from the pixel image[sr][sc].

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
*/
package Graph_Theory;

import java.util.*;

class Solution5
{
    class Node
    {
        // Since every node has a color of it's own we just make a new form of node for this
        int i;
        int j;
        // Color seems to be represented by a number? 
        int color;
        
        Node(int i, int j, int color)
        {
            this.i = i;
            this.j = j;
            this.color = color;
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        int[][] floodFilled = new int[image.length][image[0].length];
        int[][] visited = new int[image.length][image[0].length];
        for(int i = 0; i<image.length; i++)
        {
            for(int j = 0; j<image[0].length; j++)
            {
                visited[i][j] = 0;
            }
        }
        
        // We should be starting the floodfill from our given source
        // pixel so we need to find the things that are connceted to it 
        // in the four directions
        // So let's define all the directions in which it can move then
        // Using the below two indices together we can move in any of the four connected directions
        int di[] =  {1,0,0,-1};
        int dj[] = {0,-1,1,0};
        visited[sr][sc] = 1;
        floodFilled[sr][sc] = newColor;
        
        for(int idx = 0; idx<4; idx++)
        {
            int next_i = sr + di[idx];
            int next_j = sc + dj[idx];
            // Add the boundary conditions and then do a recursive function
            if(visited[next_i][next_j] == 0 && next_i > 0 && next_j >0 && next_i<=image.length && next_j <= image[0].length && image[next_i][next_j]==image[sr][sc])
            {
                visited[next_i][next_j] = 1;
                floodFilled[next_i][next_j] = newColor;
                floodFill(image, next_i, next_j, newColor);   
            }
            else if(image[next_i][next_j]==1)
            {
                floodFilled[next_i][next_j] = image[next_i][next_j];
            }

        }
        return floodFilled;

    }

    public int[][] floodFill_Nick(int[][] image, int sr, int sc, int newColor)
    {
        // base case
        if(image[sr][sc] == newColor) return image;
        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    
    }
    // We take a new function that will fill one pixel
    
    public void fill(int[][] image, int sr, int sc, int color, int newColor)
    {   if( sr<0 || sc<0 || sr >= image.length || sc >= image[0].length ||image[sr][sc] != color)
        {
            return;
        }
        image[sr][sc] = newColor;
        int di[] =  {1,0,0,-1};
        int dj[] = {0,-1,1,0};
        for(int i = 0; i<4; i++)
        {
            int next_i = sr + di[i];
            int next_j = sc + dj[i];
            fill(image, next_i, next_j, color, newColor);
        }
    }


}

class DriverClass5
{

}
