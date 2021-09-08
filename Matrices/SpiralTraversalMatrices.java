/*
Problem Statement:
Spirally Traversing a Matrix
Given a matrix of size r*c. Traverse the matrix in spiral form

Example1:
Input -
matrix[][] =   {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11,12},
                {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
*/
package Matrices;
import java.util.*;
public class SpiralTraversalMatrices {
    // Approach 1: Simulation Method
    static void SpiralTraveral(int[][] arr, int m, int n)
    {
        int i;
        int l = 0, k=0; 
        int last_row = n-1;
        int last_col = m-1;
        
        while(k<=last_row && l<=last_col)
        {
            // For printing the first row in the outer matrix
            for(i=l; i<=last_col; i++)
            {
                System.out.print(arr[k][i] + " ");
                // We then increment k to keep track of the next row
            }
                k++;
            
            // For printing the last column
            for(i = k; i<=last_row; i++)
            {
                System.out.print(arr[i][last_col] + " ");
                
            }
            // We decrement last_col for the next inner matrix
            last_col--;
            // for printing the last row
            // Here we iterate from the last 2nd column till the pointer for the first column
           //  if(k<=last_row)
            
            for(i=last_col; i>=l; i--)
            {
                System.out.print(arr[last_row][i] + " ");
             
            }
            last_row--;
        
            // if(l<=last_col)
            
            // Now for printing the last column
            for(i=last_row; i>=k; i--)
            {
                System.out.print(arr[i][l] + " ");
                // We finally increment l for the next column
                
            }
            l++;
        
        }
        // For printing the first row in the matrix
        
    }
    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11,12},
                        {13, 14, 15,16}};
        int n = 4;
        int m = 4;
        //System.out.println("The given matrix is: ");
      //  System.out.println(Arrays.deepToString(arr));
    //    System.out.println("The Spiral Traversal for it is: ");
        //SpiralTraveral(arr, m, n);
        int x = arr.length;
        System.out.println(x);       }
}
