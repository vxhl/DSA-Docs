package Leetcode_DailyChallenges.AprilChalleges;

class bipartite_graph
{
    // Graph Coloring Algorithm - DFS
    public boolean isBipartitie0(int[][] Graph)
    {
        // We have a color array that tracks the colored nodes in our graph
        int[] color = new int[Graph.length];

        // For each node in our graph
        for(int i=0; i<Graph.length; i++)
        {
            // If the current node is not colored and it does not have a validColor we return false
            if(color[i] == 0 && !validColor(Graph, color, 1, i)) return false;
        }
        return true;
    }

    public boolean validColor(int[][] g, int[] color, int c, int node)
    {
        // If our node is already colored, 
        if(color[node]!=0)
        {
            // If the color of this node matches c we can say true, or we say false
            return color[node] == c;
        }
        // Otherwise we just color the node with c
        color[node] = c;
        // Now each subarray in the int[][] holds the adjacent nodes, so we now check if all the adjacent nodes to the current node have opposite colors 
        // which means they need to be valid for -c, if they are not then we return false, otherwise return true;
        for(int n: g[node])
        {
            if(!validColor(g, color, -c, n)) return false;
        }

        return true;
    }
    
}