/*
Problem Statement:
Given a positive integer n, generate an n x n matrix filled with 
elements from 1 to n2 in spiral order.

Input: n = 3
Output: [[1,2,3],[8,9,4],[7,6,5]]

*/
package Matrices;
import java.util.*;
public class SpiralMatrixII {
    static int[][] spiralmatrixgeneration(int n)
    {
        int[][] matrix = new int[3][3];
        int rowBegin = 0;
        int rowEnd = n-1;
        int colBegin = 0;
        int colEnd = n-1;
        
        int counter = 0;

        while(rowBegin<=rowEnd && colBegin <= colEnd)
        {
            // For the first row
            for(int i=colBegin; i<=colEnd; i++)
            {
                matrix[rowBegin][i] = counter++;
            }
            // We are done with the first row so we increment it
            rowBegin++;

            // For the last column
            for(int i = rowBegin; i<=rowEnd; i++)
            {
                matrix[i][colEnd] = counter++;
            }
            // We decrement last column for the next inner matrix
            colEnd--;

            // For the last row
            for(int i = colEnd; i>=rowBegin; i--)
            {
                matrix[rowEnd][i] = counter++; 
            }
            rowEnd--;

            // For the first column
            for(int i = rowEnd; i>=rowBegin;i--)
            {
                matrix[i][colBegin] = counter++;
            }
            colBegin++;

        }
        return matrix;
    }
    static void displayMatrix(int[][] matrix, int[][] is, int[][] is2)
    {
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void main(String[] args) {
        int n = 3;
        
    }
}
