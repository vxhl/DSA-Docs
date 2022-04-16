package DSA450Restart.Strings;

class Solution_KMP
{
    public static int LongestPrefixSuffix(String s)
    {
        // We have a LPS array of the same length as s

        int[] lps= new int [s.length()];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while(i<s.length())
        {
            if(s.charAt(i) == s.charAt(len))
            {
                lps[i] = len+1;
                len++;
                i++;
            }
            else
            {
                if(len!=0)
                {
                    len = lps[len-1];
                }
                lps[i] = 0;
                i++;
            }
        }


        return len;
    }

    public static void main(String[] args) {
        String s = "abcdaabc";

        System.out.print(LongestPrefixSuffix(s));
        
    }
}
