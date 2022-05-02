package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;
class MinEffort
{


    // Binary Search
    

    // Djikstra's Algorithm
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length; 
        int n = heights[0].length;
        
        // We have an effort matrix that holds the min effort required to reach any particular element
        // We initialise it with the max
        int[][] efforts = new int[m][n];
        for(int i=0; i<m; i++)
        {
            Arrays.fill(efforts[i], Integer.MAX_VALUE);
        }
        
        // We have our minHeap. Our minHeap is ordered according to our first element in the object, which is the effort
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        // We intialise the effort to reach the first element as 0
        pq.offer(new int[]{0,0,0});
        
        // We have our 4 directions
        int[][] dir = new int[][]{{0,1}, {0,-1}, {-1,0}, {1,0}};
        while(!pq.isEmpty())
        {
            // We first of all poll whatever is the min effort rn from the minHeap
            int[] min = pq.poll();
            int dist = min[0];
            int row = min[1];
            int col = min[2];
            
            // We check if the effort is greater than the current effort, if it is then we skip the loop
            if(dist>efforts[row][col]) continue;
            // if we have reached the last element we return our answer
            if(row == m-1 && col == n-1) return dist;
            // Otherwise we look in all the 4 directions
            for(int[] d: dir)
            {
                // We get our new directions
                int newRow = row+d[0];
                int newCol = col+d[1];
                
                // Checking for out of bounds exceptions
                if(newRow>=0 && newRow<m && newCol>=0 && newCol<n)
                {
                    // We then get the maximum between our previous element and the direction in which we are moving, we assign this new distance into our minHeap
                    // if we find it to be smaller than that of the effort of our new directions
                    int newDist = Math.max(dist, Math.abs(heights[newRow][newCol] - heights[row][col]));
                    if(newDist < efforts[newRow][newCol])
                    {
                        // We update our distance
                        efforts[newRow][newCol] = newDist;
                        // And we add it into our priority queue
                        pq.offer(new int[]{newDist, newRow, newCol});
                    }
                }
                
            }
        }
        return 0;
    }

    // Binary Search
}