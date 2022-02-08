/*
Problem Statement -- 

Input:
D
Output:
21
Explanation:
D is meant for decreasing,
So we choose the minimum number
among 21,31,54,87,etc.
*/

package infyTQ2022_JavaPractice;
import java.util.*;

public class NumberFollowingPattern 
{
    static String printMinNumberForPattern(String s)
    {
       
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> st = new Stack<>();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        for(int i=0; i<s.length(); ++i)
        {
            if(s.charAt(i) == 'D' && !q.contains(arr[i])) {st.push(arr[i]);}
            if(s.charAt(i)=='I' && !st.contains(arr[i])){q.add(arr[i]);}
        }
        String res = "";
        
        while(!q.isEmpty())
        {
            res += q.poll();
        }
        while(!st.isEmpty())
        {
            res += st.pop();
        }
        return res;
    }

    // Approach 2: Using just stacks and the right solution lel
    
    static String printMinNumberForPattern2(String s)
    {
        Stack<Integer> st = new Stack<>();
        int num = 1;
        String res = "";
        for(int i=0; i<s.length(); i++) 
        {
            if(s.charAt(i)=='D')
            {
                st.push(num);
                num++; 
            }
            else
            {
                st.push(num);
                num++;

                while(!st.isEmpty())
                {
                    res += st.pop();
                }
            }
            
        }
        st.push(num);
        while(!st.isEmpty())
        {
            res += st.pop();
        }
        return res;  
    }
    public static void main(String[] args) {
        String s1 = "DI"; // 213 
        String s = "IIDDD"; // 126543
        String s3 = "DIDDIDI";
        System.out.println(printMinNumberForPattern2(s1));
    }
}
