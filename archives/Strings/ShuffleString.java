/*
Problem Statement -
Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"
Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

*/
package Strings;
import java.util.*;
public class ShuffleString {

    private static String printstr(char[] res)
    {
        String res1 = "";
        for(int i: res)
        {
            res1+=i;
        }
        return res1;
    }
    public static String restore_String(String s, int[] indices)
    {
        // Well we just shuffle according to the given shuffled indices
        char[] res = new char[s.length()];
        for(int i=0; i<s.length(); i++)
        {
            res[i] = '0';
        }

        for(int i = 0; i<s.length(); i++)
        {
            res[indices[i]] = s.charAt(i);
        }
        return String.valueOf(res);

    }
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices =  {4,5,6,7,0,2,1,3};
        System.out.println(restore_String(s, indices));
    
    }
}
