/*
Problem Statement: 
Given pair of coordinates of K rooks on a NxN chessboard. The task is 
to count the number of rooks that can attack each other. 
Note: 1<=K<=N*N

Example: 
I/p:  K=2, arr[][]= {{2,2},{2,3}}, N = 8
o/p: 2
Explanation
Both the rooks can attack each other, because they are in the same
row. Therefore, count of rooks that can attack each other is 2

*/
package Matrices;

public class RooksAttack {
    static int rooksAttack(int k, int[][] arr, int N)
    {   
        int attack  = 0;
        for(int i = 0; i<k-1; i++)
        {
            for(int j = 0; j<k-1; j++)
            {
                if(arr[i][j] == arr[i+1][j] || arr[i][j+1] == arr[i+1][j+1])
                {
                    attack += 1;
                }
                else if(arr[i][j] == arr[i+1][j] && arr[i][j+1] == arr[i+1][j+1])
                {
                    attack += 1;
                }
            }
        }

        return attack;
    }
    
    public static void main(String[] args) {
        int arr[][] = {{2,2},{2,3}};
        int k = 2;
        int N = 8;
        System.out.println(rooksAttack(k, arr, N));
    }
    
}
