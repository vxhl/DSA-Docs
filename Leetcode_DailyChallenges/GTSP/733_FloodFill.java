/* 
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel. 
 */
import java.util.*;
class FloodFill {
    // BFS Approach
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{image[sr][sc], sr, sc});
        int xdir[] = {1,-1,0,0};
        int ydir[] = {0,0,1,-1};
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int[] curr = q.poll();
                int x = curr[1];
                int y = curr[2];
                // If we find that the current image is alreday colored we just continue.
                if(image[x][y] == color){
                    continue;
                }
                // Otherwise we set it's color to the given color
                image[x][y] = color;
                for(int i=0; i<4; i++){
                    int xnew = x + xdir[i];
                    int ynew = y + ydir[i];
                    // Then we include those elements in the queue whose color is the same as the previous cell adjacent to it. 
                    if(xnew>=0 && xnew<image.length && ynew>=0 && ynew<image[0].length && image[xnew][ynew] == curr[0]){
                        q.add(new int[]{image[xnew][ynew], xnew, ynew});
                    }
                }
            }
        }
        return image;
    }
    // DFS Approach
    public int[][] floodFill2(int[][] image, int sr, int sc, int color) {
        int curr = image[sr][sc];
        // We only need to color if our current image is not already colored with the color we are given
        // If it is already colored we do not need to make any moves and we just return the image
        // But if it was not colored then we execute our dfs
        if(curr!=color) dfs(image,sr,sc,curr,color);
        return image;
    }
    
    public void dfs(int[][] image, int r, int c, int curr, int color){
        // If the current image we are at has the same color as the color of the source node only then do we color
        // otherwise we are not able to flood it.
        if(image[r][c] == curr){
            // So we set the curr as color
            image[r][c] = color;
            // Then we traverse in depth for all the 4 directions possible. Unlike bfs where we are traversing by breadth 
            // for each level, here we are traversing each direction first and then doing for the others.
            // First for the top
            if(r>=1) dfs(image,r-1,c,curr,color);
            // left
            if(c>=1)  dfs(image,r,c-1,curr,color);
            // Down
            if(r+1<image.length)  dfs(image,r+1,c,curr,color);
            // Right
            if(c+1<image[0].length) dfs(image,r,c+1,curr,color);
        }

        // So when does the base condition hit? 
        // Here the base condition is when none of the condition meet, and we are done changing the colors
        // of everything that we can, that is when we are done with all our possible calls and the calls
        // do not return anywhere and instead just change the colors for the respective coordinates specified.
    }


}
