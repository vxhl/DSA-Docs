package DSA450Restart.Strings;
import java.util.*;
class Solution_Isomorphic
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String str1,String str2)
    {
        // Your code here
        
        if(str1.length()!=str2.length())
        {
            return false;
        }
        ArrayList<Character> vis = new ArrayList<>();
        
        Map<Character, Character> mp = new HashMap<>();
        for(int j=0; j<str1.length(); j++)
        {
            if(!mp.containsKey(str1.charAt(j)) && !vis.contains(str2.charAt(j)))
            {
                vis.add(str2.charAt(j));
                mp.put(str1.charAt(j), str2.charAt(j));
            }
            else if(!mp.containsKey(str1.charAt(j)) && vis.contains(str2.charAt(j)))
            {
                return false;
            }
        }
        int i = 0;
        while(i<str1.length())
        {
            if(mp.get(str1.charAt(i))!=str2.charAt(i))
            {
                return false;
            }
            i++;
        }
        return true;
        
    }
}