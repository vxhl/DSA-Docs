package DSA450Restart.Strings;

import java.util.Spliterator;

class Solution_SplitSubstrings
{
    public static int splitStrings(String str)
    {
        int low = 0;
        int high = 0;
        int c0 = 0;
        int c1 = 0;
        int ans = 0;

        while(high<str.length())
        {
            


            if(str.charAt(high) == '0')
            {
                c0++;
                high++;
            }
            else if(str.charAt(high) == '1')
            {
                c1++;
                high++;
            }

            if(c1 == c0)
            {
                ans++;
            }
            

        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "0100110101";

        System.out.print(splitStrings(s));
    }
}