package DSA450Restart.Strings;
import java.util.*;
class BracketReversals
{
    public static int bracketReversals(String s)
    {   
        /*
            }{{}}{{{

        */
        Deque<Character> st = new LinkedList<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '{')
            {
                st.push(s.charAt(i));
            }
            else
            {
                if(!st.isEmpty())
                {
                    st.pop();
                }
                else
                {
                    st.push('{');
                    count++;
                }
            }
        }

        return (st.size())%2 == 0 ? (int)(st.size()/2)+count :  -1; 
    }

    public static void main(String[] args) {
        String S = "}{{}}{{{"; 
        String S1 = "{{";

        System.out.print(bracketReversals(S1));

    }



}