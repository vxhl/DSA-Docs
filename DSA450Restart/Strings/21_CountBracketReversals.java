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
            while(s.charAt(i) != '{')
            {
                count++;
            }

             
            
                st.push(s.charAt(i));
            
            
                if(s.charAt(i) == '}')
                {
                    if(st.peek() != '{')
                    {
                        count++;
                    }
                    else
                    {
                        st.pop();
                    }
                    
            }


        }

        return count;



    }

    public static void main(String[] args) {
        String S = "}{{}}{{{"; 

        System.out.print(bracketReversals(S));

    }



}