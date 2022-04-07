package DSA450Restart.Strings;
import java.util.*;
class Solution_ShuffledStrings
{
    public static boolean ShuffledStrings(String a, String b)
    {
        /*
        We have abcde and edbac 
        We need to check whether one is a shuffle of another so 
        We can just sort the shuffled and then use equals to get the answer but ofc that
        would not work with nlogn time to just sort the string alone
        */

        if(a.length() != b.length())
        {
            return false;
        }

        HashMap<Character, Integer> mp1 = new HashMap<>();
        HashMap<Character, Integer> mp2 = new HashMap<>();

        for(int i=0; i<a.length(); i++)
        {
            // For first string
            if(!mp1.containsKey(a.charAt(i)))
            {
                mp1.put(a.charAt(i), 1);
            }
            mp1.put(a.charAt(i), mp1.get(a.charAt(i))+1);
            
            // For second string
            if(!mp2.containsKey(b.charAt(i)))
            {
                mp2.put(b.charAt(i), 1);
            }
            mp2.put(b.charAt(i), mp2.get(b.charAt(i))+1);
        
        }


        return mp1.equals(mp2);
    }

    public static void main(String[] args) {
        String a = "abcde";
        String b = "acdeb";
        String a1 = "abxde";
        String b2 = "abxdf";

        System.out.println(ShuffledStrings(a, b));
    }
}