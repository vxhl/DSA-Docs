class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Ok we have the prereqs here as the edges and the number of courses as the vertices of the graph right
        
        
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for(int i=0; i<numCourses; i++){
            graph[i] = new HashSet<>();
        }
        
        // For a directed graph
        for(int i=0; i<prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        int[] vis= new int[numCourses];
        
        // Now we do a DFS to determine the cycle
        for(int i=0; i<numCourses; i++){
            if(vis[i]==0){
                if(dfs(i, graph, vis)) return false;
            }
        }
        return true;
        
    }
    private boolean dfs(int curr, HashSet<Integer>[] graph, int[] vis){
        // So we have three states
        // 0 1 and 2
        // for 2 it means the node is already processed for 1 it means it is under processing
        // so if we ever reach a node that is under processing that means there is a cycle
        
        // If node is already under processing we return true
        if(vis[curr]==1){
            return true;
        }
        // Otherwise we set it as under processing
        vis[curr] = 1;
        
        for(Integer i: graph[curr]){
            // We only do dfs if the current node is not being processed
            if(vis[i]!=2){
                // We check if for the current node we get true for cycle and if we do we return
                if(dfs(i, graph, vis)){
                    return true;
                }
            }
        }
        // We are setting the node as processed
        vis[curr] = 2;
        
        return false;
    }
}












