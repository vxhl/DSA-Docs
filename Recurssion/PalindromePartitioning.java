/*
Problem Statement: 
Given a string , partition it such that every substring of it is a palindrome.

Example 1 - 
Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2 - 
Input: s = "a"
Output: [["a"]]
*/
package Recurssion;
import java.util.*;
public class PalindromePartitioning {
    // As the pattern is going for so long, we probably need to use either
    // of the two techniques we have learned so far. SO for this the 2nd technique ofc.
    // All of our paritions need to be a palindrome in order
     public List<List<String>> partition(String s)
     {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        partitionUtil(0, s, ds, res);
        return res;
    }

     void partitionUtil(int index, String s, List<String> ds, List<List<String>> res)
     {
        if(index == s.length())
        {
            res.add(new ArrayList<>(ds));
            return;
        }

        for(int i = index; i<s.length(); ++i)
        {
            if(isPalindrome(s, index, i))
            {
                ds.add(s.substring(index, i+1));
                partitionUtil(index+1, s, ds, res);
                ds.remove(ds.size()-1);
            }
        }
     }

     boolean isPalindrome(String s, int start, int end)
     {
         while(start<=end)
         {
             if(s.charAt(start++) != s.charAt(end--))
                return false;
         }
         return true;
     }
}
