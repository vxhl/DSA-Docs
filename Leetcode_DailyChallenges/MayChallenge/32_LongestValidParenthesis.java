package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class Solution_LVP {

    // Using one stack
    public int longestValidParentheses(String s) {
        // Deque<Character> chStk = new LinkedList<>();
        Deque<Integer> iStk = new LinkedList<>();
        
        // So our answer is store in len right
        int len = 0;
        // First of all we push in -1 for the edge cases
        iStk.push(-1);
        int i=0;
        while(i<s.length())
        {
            // Now i get that when we see a opening bracket we push it into the stack
            if(s.charAt(i)=='(')
            {
                iStk.push(i);
            }
            
            // Otherwise if we see a closed bracket what do we do? 
            else
            {   
                // first of all we pop it out of the stack
                iStk.pop();
                // If after popping we find the stack to be empty, we push in the index of the closing bracket into the stack
                /*
                 * 
                 * ()))
                 * |  |  
                 */
                
                if(iStk.isEmpty())
                {
                    iStk.push(i);
                }
                // then we get the max between len and the 
                len = Math.max(len, i - iStk.peek());
            }

            i++;
            
        }
        
        return len;   
    }

    static int LVP(String s)
    {
        // We have a count for the opening and closing brackets and ofc we have the lengths
        int opening = 0;
        int closing = 0;
        int len = 0;
        int i =0;

        // We traverse till the end of the string
        while(i<s.length())
        {
            // If we find an opening bracket we increase our count
            if(s.charAt(i)=='(')
            {
                opening++;
            }
            else
            {
                // Otherwise we increase our closing bracket count
                closing++;

                // If we find our closing and opening to be equal we simply get an answer, otherwise if closing exceeds opening we reset
                if(closing>opening)
                {
                    opening = 0;
                    closing = 0;
                }
                else if(opening == closing)
                {
                    len = Math.max(len, opening+closing);
                }
            }
            i++;
        }

        // After doing so for the prefix we also do the same for the suffix
        // Why do this? 

        // Consider the following case
        // if we had (()() if we do one forward pass, we can never get a value for the opening brackets to be equal to the closing brackets
        // If we then traverse from the back
        // (()() 
        i = s.length()-1;
        opening = 0;
        closing = 0;

        while(i>=0)
        {
            if(s.charAt(i)==')')
            {
                opening++;
            }
            else
            {
                closing++;
                if(closing>opening)
                {
                    opening = 0;
                    closing = 0;
                }
                else if(opening == closing)
                {
                    len = Math.max(len, opening+closing);
                }
            }
            i--;
        }

        return len;

        
        

    }
}

class Solution {
    public int longestValidParentheses(String s) {
        
        int openingCount = 0;
        // In the array we are storing for each and every index what the current longest valid substring is
        int[] currLongest = new int[s.length()];
        int result = 0;
        
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                openingCount++;
            }
            else
            {
                if(openingCount>0)
                {
                    // So if we have an openingCount we naturally have atleast one valid parenthesis if we
                    // find a closing bracket
                    currLongest[i] = currLongest[i-1]+2;
                    
                    // Ok so in this step, what we are basically doing, is we go back two steps inorder to check the 
                    // longest valid substring value of the former character, if we find it to be 0 then fine otherwise
                    // we add it to the current valid parenthesis length since we need the longest valid at any time
                    currLongest[i] += (i-currLongest[i])>0? currLongest[i-currLongest[i]]: 0; 
                    result = Math.max(result, currLongest[i]);
                    openingCount--;
                }
            }
            
        }
        return result;
    }
}


