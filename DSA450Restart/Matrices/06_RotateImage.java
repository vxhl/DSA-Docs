package DSA450Restart.Matrices;

class Solution {
    public void rotate(int[][] arr) {
        // What I remember about this is first we transpose the matrix and then start reversing the rows? Well something like
        // that
        // First let us implement the transpose part atleast 
        int n = arr.length;
        int m = arr[0].length;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<m; j++)
            {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
                
            }
        }
        // Ok the transposing of the matrix was a success now on to the next step
        
        // Now what we do is reverse each of the rows in the matrix, now how
        
        // We can just have a reverse function can't we? 
        
        for(int i=0; i<n; i++)
        {
            reverse(arr[i]);
        }
        
        
    }
    
    private static void reverse(int[] rev)
    {
        int i = 0;
        // Actuall there was a way to reverse in logN time, how was it again
        // Like if arr[start] == arr[n-i+1] then we swap something like that I presume
        int n = rev.length;
        while(i<=n-i-1)
        {
            int temp = rev[i];
            rev[i] = rev[n-i-1];
            rev[n-i-1] = temp;
            i++;
        }
        
    }
}
