package DSA450Restart.Strings;
import java.util.*;


class Solution_RomanDec
{
    public static int romanToDecimal(String str) {
        // code here
        // char[] arr = {"I", "V", "X", "L", "C", "D", "M"};
        HashMap<Character, Integer> mp = new HashMap<>();
        mp.put('I', 1);
        mp.put('V', 5);
        mp.put('X', 10);
        mp.put('L', 50);
        mp.put('C', 100);
        mp.put('D', 500);
        mp.put('M', 1000);
        
        int ans = 0;
        if(str.length()==1)
        {
            return mp.get(str.charAt(0));
        }

        for(int i=0; i<str.length(); i++)
        {
            char c = str.charAt(i);
            if(i+1<str.length())
                if(mp.get(c) >= mp.get(str.charAt(i+1)))
                {
                    ans += mp.get(c);
                }
                else
                {
                    ans += mp.get(str.charAt(i+1)) - mp.get(c);
                    i++;
                }
                
            else
            {
                ans+=mp.get(c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "XXIII";
        System.out.println(romanToDecimal(s));
    }
}