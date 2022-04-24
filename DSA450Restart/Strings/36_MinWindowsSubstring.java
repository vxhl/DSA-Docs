package DSA450Restart.Strings;
import java.util.*;
class MinWindows
{
    public static String minWindows(String s, String t)
    {
        // Your code here
        // This is gonna be very similar to smallest distinct window 
        int ans = Integer.MAX_VALUE;
        int start_index = 0;
        int end_index = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        if(t.length()>s.length())
        {
            return "-1";
        }
        for(char c: t.toCharArray())
        {
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        
        int left = 0;
        int right = 0;
        int count = 0;
        int flag = 0;
        for(;right<s.length(); right++)
        {
            if(mp.containsKey(s.charAt(right)))
            {
                mp.put(s.charAt(right), mp.get(s.charAt(right))-1);
                if(mp.get(s.charAt(right)) == 0)
                {
                    count++;
                }
            }

            if(count == mp.size())
            {
            while(count == mp.size())
            {
                flag = 1;
                if(mp.containsKey(s.charAt(left)))
                {
                    if(mp.get(s.charAt(left)) < 0)
                    {
                    mp.put(s.charAt(left), mp.get(s.charAt(left))+1);
                    left++;
                    }
                    
                    else if(mp.get(s.charAt(left)) == 0)
                    {
                        mp.put(s.charAt(left), mp.get(s.charAt(left))+1);
                        left++;
                        count--;
                    }
                }
                else
                {
                    left++;
                }
            }

            int len_window = right-left+2;
            if(len_window<ans)
            {
                ans = len_window;
                start_index = left-1;
                end_index = right+1;
                
            }
        }
        }
    
        // System.out.println(ans);
        if(flag == 0)
        {
            return "-1";
        }
        return s.substring(start_index, end_index);
    }

    public static void main(String[] args) {
        String s = "timetopractice";
        String t = "toc";   
        String s1 = "zoomlazapzo";
        String t1 = "oza";

        String s2 = "adobecodebanc";
        String t2 = "abc";
        for(char c: minWindows(s2, t2).toCharArray())
        {
            System.out.print(c + " ");
        }

    }
}