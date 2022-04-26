package DSA450Restart.Strings;
import java.util.*;

class costConnectPoints
{
    /*
        So it is all about understanding how minimum spanning tree works and using the minheap inorder to make sense of it
    */
    public static int minCost(int[][] points)
    {
        int cost = 0;
        // We intialise our priority queue so when we add into it we compare the distance between the given two nodes
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[2]-b[2]));
        // We initialise our minHeap with the 0th node and the cost
        pq.offer(new int[]{0,0,0});
        int num = points.length;
        Set<Integer> vis = new HashSet<>();
        
        while(vis.size()<num && !pq.isEmpty())
        {   
            int[] curr = pq.poll();
            int endId = curr[1];
            int currCost = curr[2];
            if(vis.contains(endId))
            {
                continue;
            }
            
            cost+= currCost;
            vis.add(endId);

            for(int i=0; i<num; i++){
                if(!vis.contains(i))
                {
                    pq.offer(new int[]{endId, i, distance(points, endId, i)});
                }
            }

        }
        return cost;
    }

    public static int distance(int[][] points, int i, int j)
    {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]); 
    }
}