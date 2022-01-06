/*
Problem Statement:
Detect if there is a cycle in the given undirected graph or not
*/
package Graph_Theory;
import java.util.*;
import java.lang.*;


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
            if(new Solution().isCycle(V, adj) == true)
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
class Node
{
    // We make a class node for storing the current node and it's parent from the graph
    int first;
    int second; 
    public Node(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}
class Solution
{
    private boolean checkCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean vis[]) {
        // First we make a queue for storing our edges and give it the class Node
        Queue<Node> q = new LinkedList<>();
        // We add the first node and mark it as visited and set it's parent to -1 since it doesn't have no parent
        q.add(new Node(s,-1));
        vis[s] = true;
        while(!q.isEmpty())
        {
            // We extract the node and the parent from the Node object we created
            int node = q.peek().first;
            int par = q.peek().second;
            // We remove it because we do not need it for the next iteration
            q.remove();
            // We iterate on our node in Node
            for(Integer it: adj.get(node))
            {
                // If we find that the current element has not been visited
                if(vis[it] == false)
                {
                    // We add it to the queue and mark it as visited
                    q.add(new Node(it, node));
                    vis[it] = true;
                }
                // Otherwise if we find that the neighbor is not the previous node 
                // then we return true since we do infact have a cycle
                else if(par!=it) return true;
            }
        }
        // We return false if we don't find a cycle
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // We take out visited array here and first of all we fill it with false values
        // since none of the nodes have been visited as of yet
        boolean vis[] = new boolean[V+1];
        Arrays.fill(vis,false);
        for(int i = 1; i<=V; i++)
        {
            if(vis[i] == false)
            {
                if(checkCycle(adj, i, vis))
                {
                    return true;
                }
            }
        }
        return false;
        
    }
}