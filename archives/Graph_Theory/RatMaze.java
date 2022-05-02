/*
Problem Statement:
Input:
N = 4
m[][] = {{1, 0, 0, 0},
         {1, 1, 0, 1}, 
         {1, 1, 0, 0},
         {0, 1, 1, 1}}
Output:
DDRDRR DRDDRR
Explanation:
The rat can reach the destination at 
(3, 3) from (0, 0) by two paths - DRDDRR 
and DDRDRR, when printed in sorted order 
we get DDRDRR DRDDRR.
*/
package Graph_Theory;
import java.util.*;

class DriverClass2
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = sc.nextInt();
        int n = sc.nextInt();
        int[][] maze = new int[n][n];
        for(int it=0; i<n; i++)
        {
            for(int jt = 0; i<n; i++)
            {
                maze[it][jt] = sc.nextInt();
            }
        }
        System.out.print(Solution3.findPath(maze, n));
    }
}

class Solution3
{
    public static void solve_ratMaze(int i, int j, int[][] maze, int n, ArrayList<String> ans, String move, int[][] vis, int di[], int dj[] )
    {
        // Well that's a lot of parameter ain't it. Let's define them first
        // i and j are ofc the coordinates for where the rat is supposed to move
        // maze is ofc our maze
        // n is the dimension of the array
        // ans is th string arraylist for DLRU
        // move is the string for D, L, R or U
        // vis is ofc for the visited 2D array that we mark accordingy as we move through the maze
        // di and dj are the directions for DLRU 

        if(i==n-1 && j==n-1)
        {
            // If it is already the last element in the array
            ans.add(move);
            return;
        }
        String dir = "DLRU"; // in lexicographic order
        for(int idx = 0; idx<4; idx++)
        {
            // We get the directions for the current coordinates
            int nexti = i+di[idx];
            int nextj = j+dj[idx];
            // We now set the boundary conditions to check if the next traversal is possible and can be visited by refering to our visited array
            if(nexti>=0 && nextj>=0 && nexti<n && nextj<n && vis[nexti][nextj] == 0 && maze[nexti][nextj] == 1)
            {
                // We then first mark the current node as visited
                vis[i][j] = 1;
                // We set the coordinates for the next traversal and add the valid direction to the move String
                solve_ratMaze(nexti, nextj, maze, n, ans, move + dir.charAt(idx) , vis, di, dj);
                // We once again set the visited path as not visited? Why?????
                vis[i][j] = 0;
            }
        }
    }
    
    public static ArrayList<String> findPath(int[][] m, int n)
    {
        // We now define our findPath function for implementing our util function
        int[][] vis = new int[n][n];
        // We first fill our visited array with 0 eing unvisited for every node
        for(int i=0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                vis[i][j] = 0;
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        int di[] =  {1,0,0,-1};
        int dj[] = {0,-1,1,0};
        // While the first element of the array is 1 we get to do the traversal
        if(m[0][0] == 1) solve_ratMaze(0,0,m,n,ans,"",vis, di, dj);
        return ans;
    }

}
