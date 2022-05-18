package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class Critical_Connections
{
    int time =0;
    List<List<Integer>> result;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<Integer>[] adj = new ArrayList[n];
        
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        
        for(List<Integer> edge:connections){
            int a = edge.get(0);
            int b = edge.get(1);
            
            adj[a].add(b);
            adj[b].add(a);
        }
        
        boolean[] visited = new boolean[n];
        int[] timestamp = new int[n];
        result = new ArrayList<>();
        dfs(adj,visited,timestamp,0,-1);
        return result;
    }
    
    void dfs(List<Integer>[] adj,boolean[] visited,int[] timestamp,int vertex, int prev){
        visited[vertex]=true;
        timestamp[vertex] = time++;
        int currentTimeStamp = timestamp[vertex];
        
        
        for(int v : adj[vertex]){
            if(v == prev) continue;
            
            if(!visited[v]) dfs(adj,visited,timestamp,v,vertex);
            
            timestamp[vertex] = Math.min(timestamp[vertex],timestamp[v]);
            
            if(currentTimeStamp < timestamp[v]) result.add(Arrays.asList(vertex,v));
            
        }
    }
}