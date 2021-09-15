/*
Problem Statement: 
Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true
*/
package Matrices;

public class Search2DMatrixII {
    // This is the same as the previous problem so what's the difference?
    // The efficiency maybe? What was faster again? Rotation or Binary Search? 

    // Approach 1: Binary Searh approach
    static boolean searchMatrixII(int[][] matrix, int target)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m-1; // We set the pointer to the last column
        while(i<n && j>=0)
        {   

            if(matrix[i][j] == target) return true;
            
            if(matrix[i][j]>target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return false;


    }
}
