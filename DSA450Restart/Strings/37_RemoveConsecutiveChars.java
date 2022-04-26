package DSA450Restart.Strings;
import java.util.*;
class Solution_ConsecutiveChars{
    public String removeConsecutiveCharacter(String S){
        Deque<Character> st = new LinkedList<>();
        
        st.push(S.charAt(0));
        
        for(int i=0; i<S.length(); i++)
        {
            if(st.peek()!=S.charAt(i))
            {
                st.push(S.charAt(i));
            }
        }
        
        StringBuilder ans = new StringBuilder();
        
        while(!st.isEmpty())
        {
            ans.append(st.pop());
        }
        ans.reverse();
        
        return ans.toString();
    }
}