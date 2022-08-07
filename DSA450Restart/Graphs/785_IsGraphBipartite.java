public class Solution {

    public boolean isBipartiteDFS(int[][] graph) {
        int v = graph.length;
        int[] color = new int[v];
        // We will be doing a DFS now
        for(int i=0; i<v; i++){
                if(color[i]==0){
                    if(!dfs(i, graph, color)) return false;
                }
        }
        return true;
    }
    
    private boolean dfs(int node, int[][] graph, int[] color){
        // Actually we are doing this in a cyclic graph in the ideal case so there is no need for checking the initial state
        for(int i: graph[node]){
            if(color[i]==0){
                color[i] = color[node]==1?2:1;
                if(!dfs(i, graph, color)) return false;
            }
            else if(color[i]==color[node]) return false;
        }
        return true;
        
    }

    public boolean isBipartiteBFS(int[][] graph) {
        // Well we could use the boolean this as well so anyway
        int v = graph.length;
        int[] color = new int[v];
        // Well my logic was ofc correct but implementing with graphs is the tricky part
        // to understand tbh
        for(int i=0; i<graph.length; i++){
            // We visit the graph if we find that it is not colored
            if(color[i]==0){
                // So we first color it with 1
                color[i]=1;
                Deque<Integer> q = new LinkedList<>();
                q.add(i);
                while(!q.isEmpty()){
                    int currNode = q.poll();
                    for(int node: graph[currNode]){
                        if(color[node]==0){
                            q.add(node);
                            color[node] = color[currNode]==1?2:1;
                        }
                        else if(color[node]==color[currNode]){
                            return false;
                        }
                    }   
                }
            }
        }
        return true;
    }
    
}
