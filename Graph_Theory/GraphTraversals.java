package Graph_Theory;
/*
Problem Statement:
Given a directed graph. 
The task is to do Breadth First Traversal of this graph starting from 0.
*/
import java.util.*;

public class GraphTraversals
{
    // first we make the adjacenecey list
    private LinkedList<Integer> adj[];

    // Constructor for graph to determine how many vertices are there
    public GraphTraversals(int v)
    {
        adj = new LinkedList[v];
        for(int i = 0; i<v; i++)
        {
            adj[i] = new LinkedList<Integer>();
        }
    }

    // Now we have the function for the edge
    public void addEdge(int source, int destination)
    {
        // Since this is an undirected graph we add the source 
        // to the destination and the destination to the source
        adj[source].add(destination); 
        adj[destination].add(source);
    }

    // This will give us the min distance between the two
    public int bfs(int source, int destination)
    {
        // a boolean array indexed in terms of the adj. list since we
        // need to mark which nodes in the graph we have already visited
        boolean vis[] = new boolean[adj.length];
        // Our parent array tells us which node introduces it's neighbors
        int parent[]= new int[adj.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        // Since no one introduces oru source we set it to -1
        parent[source] = -1;
        vis[source] = true;

        while(!q.isEmpty())
        {
            int cur = q.poll(); // we pop the queue
            if(cur == destination) break; // we end the program
            for(int neighbor: adj[cur])
            {
                // We see if the neighbor is not visited
                if(!vis[neighbor])
                {
                    vis[neighbor] = true;
                    q.add(neighbor);
                    // We set the parent as cur so it ends up as the new node
                    parent[neighbor] = cur;
                }
            }

        }
        int cur = destination;
        int dis = 0;
        while(parent[cur]!=-1)
        {
            System.out.print(cur+"->");
            cur = parent[cur];
            dis++;
        }
        System.out.println();
        System.out.print("The minimum distance with bfs is: ");
        return dis;
    }
    // Recursive DFS
    public boolean dfs(int source, int destination, boolean vis[])
    {
        // Well as always the base case
        if(source == destination) return true;
        // Now we check for the visited and non visited using a for each loop
        for(int neighbor: adj[source])
        {
            if(!vis[neighbor])
            {
                // We set the neigh to true since now we have visited it
                vis[neighbor] = true;
                // Here is our recursive formula
                boolean isConnected = dfs(neighbor, destination, vis);
                if(isConnected) return true;
            }
        }
        return false;
    }
    // Stack DFS
    public boolean dfsStack(int source, int destination)
    {
        boolean vis[] = new boolean[adj.length];
        vis[source] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while(!stack.isEmpty())
        {
            int cur = stack.pop();
            if(cur == destination) return true;
            for(int neighbor: adj[cur])
            {
                if(!vis[neighbor])
                {
                    vis[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
        return false;

    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices and edges");
        int v = sc.nextInt();
        int e = sc.nextInt();

        GraphTraversals graph = new GraphTraversals(v);
        System.out.println("Enter "+e+" edges");
        for(int i = 0; i<e; i++)
        {
            // We get the input for the source and destination
            int source = sc.nextInt();
            int destination = sc.nextInt();
            // And then we use the addEdge function that we previously
            // created to add the edge to the graph we previously created
            graph.addEdge(source, destination);
        }
        System.out.println("Enter the source and destination " );
        int source = sc.nextInt();
        int destination = sc.nextInt();
        System.out.println(graph.bfs(source, destination));
        System.out.println("possible: "+ graph.dfsStack(source, destination));
        sc.close();
    }
}