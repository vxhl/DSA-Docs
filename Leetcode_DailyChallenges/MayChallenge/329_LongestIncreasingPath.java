package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
// import java.util.concurrent.LinkedBlockingDeque;
class LongestIncreasingPath
{
    // This works but is too slow
    // How do i change this into a memoisation problem
    // For each element we store it's corresponding memoisation
    // 
    static int Xdir[] = {1,-1,0,0};
        static int Ydir[] = {0,0,-1,1};
    public static int longestIncreasingPath(int[][] matrix) {
        
        int Xdir[] = {1,-1,0,0};
        int Ydir[] = {0,0,-1,1};
        int ans = 0;
        int sum = 0;
        boolean[][] vis = new boolean[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                vis[i][j] = false;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<matrix.length; i++)
        {
            System.out.println("Iterating for row");

            for(int j=0; j<matrix[0].length; j++)
            {
                System.out.println("Iterating for cols");
                // We first add the element into our queue
                q.add(new int[]{i,j,matrix[i][j], 1});

                while(!q.isEmpty())
                {

                    int[] point = q.poll();
                    // We have our two directions, our element and the path's current length in the queue
                    sum = Math.max(sum, point[2]);
                    ans = Math.max(ans, point[3]);
                    System.out.println(sum + " " + ans);

                    for(int k=0; k<4; k++)
                    {
                        int newX = point[0] + Xdir[k];
                        int newY = point[1] + Ydir[k];
                        if(newX>=0 && newX<matrix.length && newY>=0 && newY<matrix[0].length && matrix[newX][newY]> matrix[point[0]][point[1]] && 
                        vis[newX][newY]==false)
                        {
                            vis[newX][newY] = true;
                            q.add(new int[]{newX, newY, point[2]+matrix[newX][newY], point[3]+1});
                            vis[newX][newY] = false;
                        }
                    }
                }
            }
        }

        return ans;
    }


    // Using Memoisation
    public static int longestIncreasingPath2(int[][] matrix)
    {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                dp[i][j] = 0;
            }
        }
        int ans = 0;
        for(int i=0; i<matrix.length; i++)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
              ans = Math.max(ans, f(matrix, i, j, dp));  
            }
        }
        return ans;
    
    }

    public static int f(int[][] matrix, int i, int j, int[][] dp)
    {
        if(i<0 || j<0 || i>=matrix.length || j>=matrix[0].length)
        {
            return 0;
        }
        if(dp[i][j] > 0)
        {
            return dp[i][j];
        }
        
        int currMax = 1;    
        for(int k=0; k<4; k++)
        {
            int newX = i + Xdir[k];
            int newY = j + Ydir[k];
            
            if(newX>=0 && newY>=0 && newX<matrix.length && newY<matrix[0].length && matrix[newX][newY]>matrix[i][j])
            {
                currMax = Math.max(currMax, 1+f(matrix, newX, newY, dp));
            }

            dp[i][j] = currMax;
        }

        return currMax;
    }




    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},
                        {6,6,8},
                        {2,1,1}};

        System.out.println(longestIncreasingPath2(matrix));
    }
}