class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // We first make our adjacency list
        
        ArrayList[] adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++)
        {
            adj[i] = new ArrayList<>();
        }
        
        // We add all the prerequisite adjacent nodes into an adjacency list for all the relations ( directed graph )
        for(int i=0; i<prerequisites.length; i++)
        {
            // We know that for every 1th course we need to do the 0th course so 
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        // We have the visited array for every course that we have
        int[] visited = new int[numCourses];
        
        for(int i=0; i<numCourses; i++)
        {
            // If we find the current course to be not processed
            if(visited[i]==0)
            {
                // If we find a cycle that means we cannot finish all the courses so we return false
                if(helper(adj, visited, i)) return false;
            }
        }
        // Otherwise we can
        return true;
    }
    
    // Standard dfs graph coloring traversal
    private boolean helper(ArrayList[] graph, int[] visited, int curr)
    {
        // 2 means that we are tryig to visit a node that is under processing
        if(visited[curr] == 2) return true;
        
        // We set the current node under processing
        visited[curr] = 2;
        
        // Now we process the current course, and all the adjacent courses that we need to do
        for(int i=0; i<graph[curr].size(); i++)
        {
            // If our adjacent course has not been processed yet
            if(visited[(int)graph[curr].get(i)]!=1)    
            {
                // We check recursively whether while recursively processing the adjacent nodes we get a node that is already under process in the visited array, if we do we return true
                if(helper(graph, visited, (int)graph[curr].get(i)))
                {
                    return true;
                }
            }
        }
        // Once we are done processing all the adjacent nodes we can simply set the node as processed and we don't need to further check for this
        visited[curr] = 1;
        // In the end we return false;
        return false;
        
    }
    
    
    
    
}