/*
Problem Statememnt:
We are given a 2D matrix NxN `A` which represents an image.
We are to rotate the image by 90 degrees clockwise in place
Note: Using additional arrays will result in partial score
Example:
Input-> 
[[1,2],
[3,4]]
Output->
[[3,1],
[4,2]]
*/
package CodeWithScaler.Week6_GoogleInterviewQuestions;

class rotateMatrix
{
    // Apprach 1: Using Extra Space
    static void rotateMatrixExtraSpace(int matrix[][])
    {
        int n = matrix.length;

        // First we transpose our matrix
        for(int i = 0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Now we reverse our transposed to make it fit the clockwise pattern
        for(int i=0; i<n; i++)
        {
            int top = 0;
            int bottom = n-1;
            while(top<bottom)
            {
                int temp = matrix[i][top];
                matrix[i][top] = matrix[i][bottom];
                matrix[i][bottom] = temp;
                top++;
                bottom--;
            }
        }
    }
    // Approach 2: inplace matrix rotation
    static void rotateMatrixNoExtraSpace(int matrix[][])
    {
        int n = matrix.length;

        // First we transpose our matrix
        for(int i = 0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<(n/2); j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
    }
    static void displayMatrix(int N, int mat[][]){
        for (int i = 0; i < N; i++) {
           for (int j = 0; j < N; j++)
              System.out.print(" " + mat[i][j]);
              System.out.print("\n");
           }
           System.out.print("\n");
        }
        public static void main(String[] args){
           int N = 3;
           int mat[][] = {
              {1,2,3},
              {4,5,6},
              {7,8,9}
           };
           rotateMatrixExtraSpace(mat);
           displayMatrix(N, mat);
        }

}