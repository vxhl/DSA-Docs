/*
Problem Statement:
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, 
which means you have to modify the input 2D matrix directly.
DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

*/
package Matrices;
import java.util.*;

public class RotateImage {
    // Let us first look at the brute force approach    
    static void rotataImageII(int matrix[][])
    {
        int n = matrix.length;

        // We first transpose our matrix
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Now that we have transposed it let us now reverse the positions so that
        // It comes in the clockwise reverse order of the originalmatrix
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
    public static void main(String[] args) {
        int mat[][] = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
         };
         
        rotataImageII(mat);
        System.out.println(Arrays.deepToString(mat));
    }


}
