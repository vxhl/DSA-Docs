/*
Problem Statement:
Gicen an undirected graph and an integer M. THe task is to determine if the
graph can be colored with at most M colors such that no two adjacent vertices of the 
graph are colored with the same color. 
Here coloring of a graph means the assignment of colors to all vertices. 
Print 1 if it is possible to color vertices and 0 otherwise

Input:
N = 4
M = 3
E = 5
Edges[] = {(0,1),(1,2),(2,3),(3,0),(0,2)}
Output: 1
Explanation: It is possible to colour the
given graph using 3 colours.
*/

package Recurssion;
import java.util.*;


public class MColoringProblem {

    private static boolean isSafe(int node, List<Integer>[] G, int[] color, int n, int col) {
        for(int it: G[node]) {
            if(color[it] == col) return false; 
        }
        return true; 
    }
    private static boolean solve(int node, List<Integer>[] G, int[] color, int n, int m) {
        if(node == n) return true; 
        
        for(int i = 1;i<=m;i++) {
            if(isSafe(node, G, color, n, i)) {
                color[node] = i;
                if(solve(node+1, G, color, n, m) == true) return true; 
                color[node] = 0;
            }
        }
        return false; 
    }
    public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int m) 
    {
        int n = G.length; 
        if(solve(0, G, color, n, m) == true) return true; 
        return false; 
        // Your code here
    }
}
