package DSA450Restart.Strings;
import java.util.*;

class Solution_noccnuc
{
    public static int noccnuc(int n, String s)
    {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c: s.toCharArray())
        {
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }


        // GACCBDDBAGEE
        char[] s1 = s.toCharArray();
        int comps = n;
        int ans = 0;
        for(char c: s1)
        {
            if(mp.containsKey(c))
            {
                // The customer enters the shop
                if(mp.get(c)>1 && comps!=0)
                {
                    // So we say that the enter event is over
                    mp.put(c, mp.get(c)-1);
                    // And one of the computers has been occupied
                    comps--;
                }
                // If our occurence is 1, that means, it is time to leave the shop
                else if(mp.get(c)==1 && comps!=0)
                {
                    // The customer leaves
                    mp.put(c, mp.get(c)-1);
                    // Thus we have a free computer now
                    comps++;
                }

                else if(mp.get(c)>1 && comps==0)
                {
                    mp.put(c, mp.get(c)-1);
                    ans++;
                }
            }
        }

        return ans;
    }


    public static int solve(String s, int n)
    {
        char[] seen = new char[26];

        int ans = 0;

        // To keep track of occupied computers
        int occupied = 0;

        for(int i=0; i<s.length(); i++)
        {
            int ind = s.charAt(i) - 'A';
            if(seen[ind] == 0)
            {
                seen[ind] = 1; // IN the cafe

                // If we have computers than we assign a computer
                if(occupied<n)
                {
                    occupied++;
                    // Computer assigned
                    seen[ind] = 2;
                }

                else
                {
                    ans++;
                }
            }

            else
            {
                if(seen[ind] == 2)
                    occupied--;
                seen[ind] = 0;
            }


        }
        return ans;
        
    }

    public static void main(String[] args) {
        String s = "GACCBDDBAGEE";
        int n = 3;

        System.out.println(solve(s, n));
    }
}