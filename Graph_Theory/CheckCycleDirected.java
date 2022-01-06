package Graph_Theory;
import java.util.*;

class DriverClass
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
         
        while(t-->0)
        {
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i<V+1; i++)
            {
                adj.add(i, new ArrayList<Integer>());
            }
            for(int i=0; i< E; i++)
            {
                // This is where we add edges
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
            }
            if(new Solution2().isCyclic(V, adj) == true)
            {
                System.out.println("The given undirected graph is in fact cyclic");
                
            }
            else
            {
                System.out.println("There is no cycle in the given undirected graph");
            }
        }
    }
}

class Solution2
{
    private boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int vis[] , int dfsvis[])
    {
        // We first of all set the first visited and dfsvisited ones as visited
        vis[node] = 1;
        dfsvis[node] = 1;
        // We then iterate on the adjacent nodes
        for(Integer it: adj.get(node))
        {
            // If the adjacent nodes are not visited
            if(vis[it]==0)
            {   
                // If this recursion call return true
                if(checkCycle(node, adj, vis, dfsvis)==true)
                {
                    return true;
                }
                // If the adjacent node comes up to be visited and it is also visited in the 
                // dfsvisit array then we return true since we have found the point
                // where our cycle begins
                else if(dfsvis[it]== 1)
                {
                    return true;
                }
            }
        }
        // If we end up not finding a cyclic call on the first recursion
        // Then we set the current neighbors of the node as not
        // visited since we will be going back to the parent nodes to run the recursion call for 
        // other non visited nodes
        dfsvis[node] = 0;
        return false;
    }


    boolean isCyclic(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int vis[] = new int[N];
        int dfsvis[] = new int[N];
        
        for(int i = 0; i<N; i++)
        {
            if(vis[i] == 0)
            {
                if(checkCycle(i, adj, vis, dfsvis) == true)
                {
                    return true;
                }
            }
        }
        return false;
    }

}