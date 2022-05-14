package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class NetworkDelayTime {
    class distNode
    {
        int v;
        int dist;
        distNode(int v, int dist)
        {
            this.v = v;
            this.dist = dist;
        }
    }
    // This is for the adjacency list nodes
    class edge
    {
        int dst;
        int wt;
        edge(int dst, int wt)
        {
            this.dst = dst;
            this.wt = wt;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        // We first create our adjacency list
        ArrayList<edge>[] graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();
        for(int i=0; i<times.length; i++) 
        {
            // Our edge constitutes the target node and the time taken respectively
            edge newE = new edge(times[i][1], times[i][2]);
            // Then we add the connections for the corresponding source node
            graph[times[i][0]].add(newE);
        }
        
        // We define our source node which starts from k and has an initial distance of 0
        distNode src = new distNode(k,0);
        
        // We use a maxHeap
        PriorityQueue<distNode> pq = new PriorityQueue<>((a,b)->{return a.dist-b.dist;});
        pq.add(src);
        
        // We have a new array that holds our distances
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        // We only assign the source's value as 0 since we can always reach it
        distance[k] = 0;
        
        while(pq.size()!=0)
        {
            distNode vtx = pq.remove();
            for(edge e: graph[vtx.v])
            {
                // We get the weight of the current edge to a corresponding edge and
                // add it to our current distance value for the vtx we removed from the queue
                distNode tmp = new distNode(e.dst, e.wt + vtx.dist);
                // If we find the value to be smaller than our currently added value in our
                // distance array we update it and push it into our heap
                if(distance[tmp.v]>tmp.dist)
                {
                    // We add into heap
                    pq.add(tmp);
                    // We update the distance value for that vertex
                    distance[tmp.v] = e.wt + vtx.dist;
                }
            }
        }
        int time = 0;
        for(int i=1; i<=n; i++)
        {
            if(distance[i]==Integer.MAX_VALUE)
            {
                return -1;
            }
            time  = Math.max(time, distance[i]);
            
            
        }
        return time;
        
        
    }
}
