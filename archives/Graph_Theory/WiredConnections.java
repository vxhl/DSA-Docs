/*
Input: n = 4, connections = [[0,1],[0,2],[1,2]]
Output: 1
Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
*/

package Graph_Theory;
import java.util.*;


class Solution
{
    public static void DFS(HashMap<Integer, ArrayList<Integer>> adj, int node, boolean visited[])
    {
        // If current node 
        if(visited[node]) return;

        visited[node] = true;

        for(int x: adj.get(node))
        {
            if(visited[x]==false)
            {
                DFS(adj,x,visited);
            }
        }
    }


    public static int makeConnectedUtil(int N, int connections[][])
    {
        boolean visited[] = new boolean[N];
        int M = connections.length;
        // Building the adjacency list
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        // Initialise the adjacency list 
        for(int i=0; i<N; i++)
        {
            adj.put(i, new ArrayList<Integer>());
        }
        // We store the count of edges for base cases
        int edges = 0;

        // We build our adjacency list
        // from the given edges
        for(int i=0; i<M; i++)
        {
            ArrayList<Integer> l1 = adj.get(connections[i][0]);
            ArrayList<Integer> l2 = adj.get(connections[i][0]);

            // add edges 
            l1.add(connections[i][1]);
            l2.add(connections[i][0]);
            // We incremement our edges
            edges += 1;
        }

        // Store count of comps 
        int comps = 0;
        for(int i=0; i<N; i++)
        {
            if(visited[i] == false)
            {
                comps += 1;
            
                DFS(adj, i, visited);
            }
        }

        if(edges<N-1) return -1;
        int redudant = edges - ((N-1) - (comps-1));

        if(redudant >= (comps - 1))
            return comps - 1;
        return -1;
    }

    public static void makeConnected(int N, int[][] connections)
    {
        int minOps = makeConnectedUtil(N, connections);

        System.out.println(minOps);
    }
}