package DSA450Restart.Matrices;
import java.util.*;
class Solution
{
    // O((N*N)*LogN) approach
    int[][] sortedMatrix(int N, int Mat[][]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                res.add(Mat[i][j]);
            }
        }
        Collections.sort(res);
        // Now we put the elements from our resultant into our 2d array
        int k = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                Mat[i][j] = res.get(k++);
            }
        }
        
        return Mat;
    }
    // O(N*N) and constant space approach
    int[][] sortedMatrix2(int N, int Mat[][]) {
        // Efficient approach
        int size = N*N;
        
        // We are gonna be using bubble sort for this approach
        
        for(int i=0; i<size; i++)
        {
            for(int j=0; j<size-1; j++)
            {
                if(Mat[j/N][j%N] > Mat[(j+1)/N][(j+1)%N])
                {
                    int temp = Mat[j/N][j%N];
                    Mat[j/N][j%N] = Mat[(j+1)/N][(j+1)%N];
                    Mat[(j+1)/N][(j+1)%N] = temp;
                }
                else 
                {
                    continue;
                }
            }
        }
        return Mat;
        
    }
}