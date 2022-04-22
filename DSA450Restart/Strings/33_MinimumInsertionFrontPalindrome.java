package DSA450Restart.Strings;

class Solution_FrontInsertion {

    // Brute force appraoch
    public static int tpalfornt(String s)
    {
        int flag = 0;
        int count = 0;
        
        while(s.length()>0)
        {
            if(isPalindrome(s))
            {
                flag = 1;
                break;
            }
            else
            {
                count+=1;
                s = s.substring(0, s.length()-1);
            }

        }

        if(flag == 1)
        {
            return count;
        }
        return 0;


    }

    private static boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;

        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
            {
                return false;
            }
        }
        return true;
    }

    // Efficient Approach -> O(N) , this uses a concatenated string with it's reverse and the KMP algorithm using which
    // we find the longest prefix suffix meaning, the longest palindrome that we have currently and then we return the total length -1 to get our 
    // answer for the number of items to be inserted at the front


    public static int[] computeLPS(String s)
    {
        // We have our LPS array to compute the current length of the substring
        int len = 0;
        int[] lps = new int[s.length()];
        lps[0] = 0;
        int i = 1;
        while(i<s.length())
        {
            if(s.charAt(i) == s.charAt(len))
            {
                lps[i] = len+1;
                len++;
                
        System.out.println("In a loop ain't i");
                i++;
            }
            else
            {
                if(len!=0)
                {
                    // Why did we do this step? In computing the LPS array again? 
                    // It's because, if the length of the current LPS is not 0, 
                    // then the length of the current lps should reduce to
                    len = lps[len-1];
                    
                }
                else
                {
                    lps[i] = 0;
                    i++;
                    
        System.out.println("In a loop ain't i 3");
                    
                }
            }
        }
        return lps;

    }

    public static int frontPalindrome(String s)
    {
        // We first get the concatenation of the two strings so we first reverse it ofc
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        String concatenatedString = s + "$" + sb.reverse().toString();
        System.out.println(concatenatedString);
        int[] lps = computeLPS(concatenatedString);
        
        return s.length() - lps[lps.length-1];
    }

    public static void main(String[] args) {
        String s = "AACECAAAA";
        System.out.println(frontPalindrome(s));
    }









}