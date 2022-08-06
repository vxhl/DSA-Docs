class Solution {
    // DFS
    private boolean seen;
    public boolean validPathDFS(int n, int[][] edges, int source, int destination) {
        // We first create our adjacency list for the edges
        
        HashSet<Integer>[] adj = new HashSet[n];
        for(int i=0; i<n; i++){
            adj[i]=new HashSet<Integer>();
        }
        for(int[]edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        } 
        boolean[] vis = new boolean[n];
        
        if(adj[source].contains(destination)){
            return true;
        }
        seen=false;
        dfs(adj, vis, source, destination);
        return seen;   
    }
    
    private void dfs(HashSet<Integer>[] adj, boolean[]vis,int currSource, int destination){
        
        if(!vis[currSource] && !seen){
            if(currSource==destination){
                seen=true;
                return;
            }
        }
        vis[currSource]=true;
        for(Integer it: adj[currSource]){
            if(!vis[it]) dfs(adj, vis ,it, destination);   
        }
    }



    // BFS
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // We first create our adjacency list for the edges
        
        HashSet<Integer>[] adj = new HashSet[n];
        for(int i=0; i<n; i++){
            adj[i]=new HashSet<Integer>();
        }
        for(int[]edge: edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        } 
        boolean[] vis = new boolean[n];
        
        if(adj[source].contains(destination)){
            return true;
        }
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        
        while(!q.isEmpty()){
            int curr=q.poll();
            if(curr==destination) return true;
            // We then traverse the current HashSet for the node
            for(Integer i: adj[curr]){
                if(!vis[i]){
                    vis[i]=true;
                    q.offer(i);
                }   
            }
        }
        return false;
    } 
}


