/*
Problem Statement: 
Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s. 

Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2

*/
package Matrices;

import java.util.Arrays;
import java.util.Collections;

public class Max1s {
    // Approach 1: Brute forces
    static int MaxRow1(int[][] mat)
    {
        int row = mat.length;
        int col = mat[0].length;
        // We declare the two variables to store the row with max 1s
        // and the number of 1s in that row
        int max_1 = 0;
        int max_row_index = 0;
        // Traverse the matrix row wise
        for(int i = 0; i<row; i++ )
        {
            // We count the number of 1s in the current row
            int count_1 = 0;
            for(int j = 0; j<col; j++)
            {
                if(mat[i][j] == 1)
                {
                    count_1 ++;
                }
            }
            // If current row has more number of 1s than previous record
            // then update the value and index
            if(count_1>max_1)
            {
                max_row_index = i;
                max_1 = count_1;

            }
        }
        return max_row_index;

        
    }

    public static void main(String[] args) {
        int[][] mat = { { 0, 0, 0, 1 },
                            { 0, 1, 1, 1 },
                            { 1, 1, 1, 1 },
                            { 0, 0, 0, 0 } };
        
        System.out.println(MaxRow1(mat));
    
    
    }


}
