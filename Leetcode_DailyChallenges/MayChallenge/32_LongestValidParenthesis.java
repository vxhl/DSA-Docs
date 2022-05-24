package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class Solution_LVP {

    // Using one stack
    public int longestValidParentheses(String s) {
        // Deque<Character> chStk = new LinkedList<>();
        Deque<Integer> iStk = new LinkedList<>();
        
        int len = 0;
        iStk.push(-1);
        int i=0;
        while(i<s.length())
        {
            if(s.charAt(i)=='(')
            {
                iStk.push(i);
            }
            
            else
            {   
                iStk.pop();
                if(iStk.isEmpty())
                {
                    iStk.push(i);
                }
                
                len = Math.max(len, i - iStk.peek());
            }

            i++;
            
        }
        
        return len;   
    }

    static int LVP(String s)
    {
        int opening = 0;
        int closing = 0;
        int len = 0;
        int i =0;
        while(i<s.length())
        {
            if(s.charAt(i)=='(')
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
            i++;
        }

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
