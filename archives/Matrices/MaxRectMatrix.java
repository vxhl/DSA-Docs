/*
Problem Statement:
Given a rows x cols binary matrix 
filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the above picture.

*/
package Matrices;
import java.util.*;
public class MaxRectMatrix 
{
    /*
    Here we will be using the previous MaxReactHistogram algorithm inorder to get
    the max react areas for each row in the matrix in O(C) time. For total number of rows as R
    the time complexity for the problem is O(R*C)
    */
    static int maxRectangleMatrix(char[][] matrix)
    {
        // First of all we need a variable that will be storing
        // the areas and keeps updating as we encounter larger areas 
        if(matrix.length == 0) return 0;
        
        // We want to create one array having same number of cols as matrix 
        int[] height = new int[matrix[0].length]; 
        for(int i=0; i<matrix.length; i++)
        {
            for(int j = 0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    height[j] = 0;
                }
                else
                {
                    height[j] += 1;
                }
            }
        }
    }
}
