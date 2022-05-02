/*
Problem Statement -- 
Example 1:

Input: jewels = "aA", stones = "aAAbbbb"
Output: 3
Example 2:

Input: jewels = "z", stones = "ZZ"
Output: 0
*/

package Strings;

public class JewelsAndStones {
    public static int newJewelsInStones(String jewels, String stones)
    {
        int j = 0;
        for(int i=0; i<stones.length(); i++)
        {
            for(int k = 0; k<jewels.length(); k++)
            {
                if(stones.charAt(i) == jewels.charAt(k))
                {
                    j += 1;
                }
            }
        }
        return j;
    }
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";

        System.out.println(newJewelsInStones(jewels, stones));
    }
}
