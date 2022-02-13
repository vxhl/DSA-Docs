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


    // Approach 2: Leetcode
    public static int[] minOps(String boxes)
    {
        int[] res = new int[boxes.length()];
    for (int i = 0, ops = 0, cnt = 0; i < boxes.length(); ++i) {
       res[i] += ops;
       cnt += boxes.charAt(i) == '1' ? 1 : 0;
       ops += cnt;
    }    
    for (int i = boxes.length() - 1, ops = 0, cnt = 0; i >= 0; --i) {
        res[i] += ops;
        cnt += boxes.charAt(i) == '1' ? 1 : 0;
        ops += cnt;
    }
    return res;
    }


    
    public static void main(String[] args) {
        String boxes = "110";

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
