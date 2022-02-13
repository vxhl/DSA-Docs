/*
Example 1:

Input: boxes = "110"
Output: [1,1,3]
Explanation: The answer for each box is as follows:
1) First box: you will have to move one ball from the second box to the first box in one operation.
2) Second box: you will have to move one ball from the first box to the second box in one operation.
3) Third box: you will have to move one ball from the first box to the third box in two operations, and move one ball from the second box to the third box in one operation.
Example 2:

Input: boxes = "001011"
Output: [11,8,5,4,3,4]
*/

package Strings;

import java.util.*;
public class MinOps1769 {


    // Approach 2: Leetcode - O(N)
    public static int[] minOps(String boxes)
    {
        // A - Total number of steps
        // a - Balls on the right side
        // b - Balls on the left side
        int count = 0;
        int[] steps = new int[boxes.length()];
        int behind = 0;
        int ahead = 0;
        for(int i= 0; i<boxes.length(); i++)
        {
            if(boxes.charAt(i) == '1')
            {
                ahead++;
                steps[0] += i;
            }
        }
        // Now let us implement the formula that we gathered
        if(boxes.charAt(0) == '1')
        {
            ahead--;
            behind++;
        }
        
        for(int i = 1; i<boxes.length(); i++)
        {
            steps[i] = steps[i-1] - ahead + behind;
            if(boxes.charAt(i) == '1')
            ahead++;
            behind--;
        }

        return steps;
        
    }



    public static void main(String[] args) {
        String boxes = "110";
        System.out.println(minOps(boxes).toString());
        List<Integer> ops = new ArrayList<>(); 
        int countOps = 0;
        for(int i=0; i<boxes.length(); i++)
        {
            for(int j = 0; j<boxes.length(); j++)
            {
                if(boxes.charAt(j) == '1')
                {
                    countOps += Math.abs(i-j);
                }           
            }
            ops.add(countOps);
            countOps = 0;
       
        }

        System.out.println(ops.toString());        

    }
}
