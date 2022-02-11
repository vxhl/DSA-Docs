package Strings;

import java.util.*;

public class DefangingIpAddress 
{
    public static String defang(String address)
    {
        // We get a new stack
        Stack<Character> st = new Stack<>();
        String ans = "";
        for(int i=address.length()-1; i>=0; i--)
        {
            if(address.charAt(i)!='.')
            {
                st.push(address.charAt(i));
            }
            else
            {
                st.push(']');
                st.push('.');
                st.push('[');
            }
        }

        while(!st.isEmpty())
        {
            ans += st.pop();
        }
        return ans;
    }

    public static void main(String[] args) {
        String address = "1.1.1";
        String address2 = "255.100.50.0";
        System.out.println(defang(address2));
    }

}
