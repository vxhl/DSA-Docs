package DSA450Restart.Matrices;
class Solution
{
    // The function returns maximum value A(c,d) - A(a,b)
    // over all choices of indexes such that both c > a
    // and d > b.
    static int findMaxValue(int N,int mat[][])
    {
        //stores maximum value
        int maxValue = Integer.MIN_VALUE;
      
        // maxArr[i][j] stores max of elements in matrix
        // from (i, j) to (N-1, N-1)
        // Basically in each index here, we are storing the max element
        // from the range i,j to n-1, n-1
        int maxArr[][] = new int[N][N];
      
        // So ofc at the last index of this arr we will have the element at n-1, n-1 itself so we initialise that for now
        maxArr[N-1][N-1] = mat[N-1][N-1];
      
        // We start by preprocessing the last row of the array
        int maxv = mat[N-1][N-1];  // Keep in mind that we also have negative elements in our array so this keeps on changing
        for (int j = N - 2; j >= 0; j--)
        {
            // In the last row we check and update accordingly
            if (mat[N-1][j] > maxv)
                maxv = mat[N - 1][j];
            maxArr[N-1][j] = maxv;
        }
      
        // We now preprocess the last column
        maxv = mat[N - 1][N - 1];  // Our max will ofc remain the same for it as well
        for (int i = N - 2; i >= 0; i--)
        {
            // We check and update the column accordinlgy
            if (mat[i][N - 1] > maxv)
                maxv = mat[i][N - 1];
            maxArr[i][N - 1] = maxv;
        }
      
        // After we have initialised our first and last row, we start doing for the rest of the matrix
        // This is a dp approach, so as we are storing for the differnt rows and columns we keep checking on the maxValue and updating it

        for (int i = N-2; i >= 0; i--)
        {
            for (int j = N-2; j >= 0; j--)
            {
                // Update maxValue
                if (maxArr[i+1][j+1] - mat[i][j] > maxValue)
                    maxValue = maxArr[i + 1][j + 1] - mat[i][j];
      
                // And update accordingly for by checking for the pick and not pick possibilities. 
                maxArr[i][j] = Math.max(mat[i][j],
                                   Math.max(maxArr[i][j + 1],
                                       maxArr[i + 1][j]) );
            }
        }
      
        return maxValue;
    }

}