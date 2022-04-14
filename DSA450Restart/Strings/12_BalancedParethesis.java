package DSA450Restart.Strings;
import java.util.*;


class BalancedParethesis
{
    static boolean ispar(String x)
    {
        // add your code here
        Deque<Character> st = new LinkedList<Character>();
        
        for(int i=0; i<x.length(); i++)
        {
        if(x.charAt(i) == '(' || x.charAt(i) == '{' || x.charAt(i) == '[')
        {
            st.push(x.charAt(i));
        }

        if(st.isEmpty()) return false;
        else
        {
            if(x.charAt(i) == ')')
            {
                if(st.peek() != '(') 
                {
                    return false;
                }
                else
                {
                    st.pop();
                }
            }
            if(x.charAt(i) == '}')
            {
                if(st.peek() != '{') 
                {
                    return false;
                }
                else
                {
                    st.pop();
                }
            }

            if(x.charAt(i) == ']')
            {
                if(st.peek() != '[') 
                {
                    return false;
                }
                else
                {
                    st.pop();
                }
            }
        }
        }

        if(!st.isEmpty())
        {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "(){}[]}";
        System.out.println(ispar(s));

    }
}