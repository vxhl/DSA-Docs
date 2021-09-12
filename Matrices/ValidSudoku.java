/*
Problem Statement: 

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits 1-9 without repetition.
2. Each column must contain the digits 1-9 without repetition.
3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
*/

package Matrices;

import java.util.HashSet;

public class ValidSudoku {
    static boolean valid_sudoku(char[][] sudoku)
    {
        HashSet<String> seen = new HashSet();
        
        for(int i=0; i<9; i++)
        {   
          
            // HashSet<Integer> col_vals = new HashSet();
            // HashSet<Integer> box_vals = new HashSet();
            

            for(int j=0; i<9; j++)
            {
                char curr = sudoku[i][j];
                if(curr != '.')
                {
                    if(!seen.add(curr + "found in row" + i) ||
                    !seen.add(curr + "found in column" + j) ||
                    !seen.add(curr + "found in box" + i/3 + "-" + j/3)) return false;
                    // seen.add(curr + "found in row" + i);
                    // seen.add(curr + "found in column" + j);
                    // // This is how we get the current sub vox
                    // seen.add(curr + "found in box" + i/3 + "-" + j/3); 
                }   
            }
        }
        
        return true;
    }
}
