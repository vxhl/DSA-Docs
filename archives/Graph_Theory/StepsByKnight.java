/*
Problem Statement:
Given a square chessboard, the initial position of Knight and position of a target. 
Find out the minimum steps a Knight will take to reach the target position.

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
*/

package Graph_Theory;
import java.util.*;

class DriverClass4
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] knightPos = new int[2];
        int[] targetPos = new int[2];
        for(int i = 0; i<2; i++ )
        {
            knightPos[i] = sc.nextInt();
            targetPos[i] = sc.nextInt();
        }
        System.out.println(Solution4.minStepToReachTarget(knightPos, targetPos, N));
        
    }
}

class Solution4
{
    static class front
{
    static int x;
    static int y;
    static int steps;
    front(int x, int y, int steps)
    {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
}
        // We specify the coordinate array for the number of ways our knight can move
        // For rows
        static int dx[] = {-2,2,2,-2,-1,1,-1,1};
        // For Columns
        static int dy[] = {-1,-1,1,1,2,2,-2,-2}; 
    
        public static int minStepToReachTarget(int knightPos[], int targetPos[], int N)
        {
            // Code here
            // We fill our visited array first of all with all false values
            boolean visit[][] = new boolean[N+1][N+1];
            for(int i=0; i<N; i++)
            {
                for(int j =0; j<N; j++)
                {
                    visit[i][j] = false;
                }
            }
            Queue<front> q = new LinkedList<>();
            // We add the first position of the knight into the queue
            q.add(new front(knightPos[0], knightPos[1],0 ));
            // And we also set the first position for the boolean array as true
            visit[knightPos[0]][knightPos[1]] = true;
            
            while(!q.isEmpty())
            {   

                front test = q.poll();
                q.remove(0);
                if(test.x == targetPos[0] && test.y == targetPos[1])
                {
                    return test.steps;
                }
            // We iterate for the number of ways we can traverse our knight
            for(int i=0; i<8; i++)
            {
                int next_x = front.x + dx[i];
                int next_y = front.y + dy[i];

                // We set the boundary conditions and check or visited
                if(visit[next_x][next_y] == false && next_x>0 && next_y>0 && next_x <=N && next_y <=N)
                {
                    visit[next_x][next_y] = true;
                    q.add(new front(next_x, next_y, front.steps + 1));
                }
            }
            }
            return Integer.MAX_VALUE;
            
        }
}