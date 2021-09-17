/*
Problem Statement: 
Example - 
Input: n = 4
Output: "1211"
Explanation:
countAndSay(1) = "1"
countAndSay(2) = say "1" = one 1 = "11"
countAndSay(3) = say "11" = two 1's = "21"
countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
*/

package Strings;
import java.util.*;

public class CountAndSay {
    
    static String countAndSay_problem(int n)
    {
        if(n<=0) return null;

        String result = "1"; // Setting up the last element
        int i = 1;
        while(i<n)
        {
            int count = 1;
            StringBuilder sb = new StringBuilder(); // We build up our series using sb
            
            // The for loop is for cases that are greater than 1
            for(int j = 1; j<result.length();j++) { // We start from the second element since we already specified the first element
                // We basically increment the count as long as we have repeating elements
                if(result.charAt(j) == result.charAt(j-1))
                {
                    count++;
                }
                // When the repeating loop gets broken
                else
                {
                    // We first append our count
                    sb.append(count);
                    sb.append(result.charAt(j-1));
                    // We again reset our counter for the next number
                    count = 1;
                }


            }

        
        sb.append(count); // We always append our count first
        sb.append(result.charAt(result.length()-1)); // And then we append our character

        result = sb.toString();
        i++;
    }
    return result;
        
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.print("The required series is: ");
        System.out.println(countAndSay_problem(n));
    }

}
