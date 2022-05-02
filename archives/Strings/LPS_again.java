/*
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

*/

package Strings;
import java.util.*;
public class LPS_again {
    

    // Nick White's Solution: O(N^2) and O(1)










    // Brute Force
    static String printsubstring(String str, int low, int high)
    {
        String ans = "";
        for(int i=low; i<=high; i++)
        {
          ans += str.charAt(i);
        }
        return ans;
    }
    public static String LPS_String(String str)
    {
        int low = 0;
        int high = str.length()-1;
        
        // All the substrings in the diagonal of the tabular matrix will be of one element and this palindrome
        
        // We start a loop that will be used to mark the starting and ending indexes of the substrings that we will be
        // checking to whether be palindrome or not
        int n = str.length();
        int maxLenght = 1;
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                int flag = 1;
                
                // We now check for the palindrome

                for(int k=0; k<(j-i+1)/2; k++)
                {
                    if(str.charAt(i+k)!=str.charAt(j-k))
                    {
                        flag = 0;
                    }
                }

                if(flag!=0 && (j-i+1)>maxLenght)
                {
                    low = i;
                    maxLenght = j-i+1;
                }

            }
        }

        return printsubstring(str,low,low+maxLenght-1);
     
    }

    public static void main(String[] args) {
        String s = "xabbacdaasfafaw";
        String s1 = "f1racecar";
        int left = 0;
        int right = 0;
        int res= 0;
        for(int i=0; i<s1.length(); i++)
        {
        while(left >= 0 && right < s1.length() && s.charAt(left)== s.charAt(right))
        {
           left--;
           right++; 
        }
        res = res+right - left - 1;
       }
       System.out.println(res);
    
    }


    // Using this checkPalindrome function we check whether the current string is palindrome or not though we might need to do some changes based on the indexing
   
}
