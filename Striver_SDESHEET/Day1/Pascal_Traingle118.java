/*
Problem Statement:
Given an integer numRows, return the first numRows of Pascal's triangle

Example:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]

*/

package Striver_SDESHEET.Day1;
import java.util.*;


public class Pascal_Traingle118 {
    
    public static List<List<Integer>> pascal(int numRows)
    {
        // OK did not solve it myself. SO
        // Let's just talk to ourselves and see how the process goes on.
        // ofc first we define our resultant array which is res
        List<List<Integer>> res = new ArrayList<>();
        
        // Let us now define our current row and previous row lists
        List<Integer> row, pre = null;

        for(int i=0; i< numRows; i++)
        {
            row = new ArrayList<>();
            for(int j=0; j<=i; j++)
            {
                // We first add 1 to the boundaries since they will always be 1
                if(j==0 || j==i)
                {
                    // Ok so we added to the start and end of the list right.
                    row.add(1);
                }
                else
                {
                    // Now when we are not at the start or end of the list we look at our previous array and set the values
                    // for the current position as the previous ones.
                    row.add(pre.get(j-1) + pre.get(j));
                }
            }
            // We set the current row that we computed as the previous one cause we need to get the values for it in the next iteration.
            // honestly won't really get the full idea as long as i do not dry run this. SO. Let's dry run this actually. 
            // it'll be good for me. 
            pre = row;
            res.add(row);
        }
        return res;
    }
    public static void main(String[] args) {
        int numRows = 3;
        System.out.println(pascal(numRows));
    }
}
