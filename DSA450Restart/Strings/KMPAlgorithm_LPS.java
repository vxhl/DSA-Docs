package DSA450Restart.Strings;
import java.util.*;
public class KMPAlgorithm_LPS {
    // Ok I understand how the LPS thing works, let's now get some exampples to work with alright

    public static int[] LPSArray(String s)
    {
        // This variable progressively stores the length of the longest LPS at the current moment
        int len = 0;
        int i = 1;
        int[] lps = new int[s.length()];
        char[] arr = s.toCharArray();
        lps[0] = 0;
        while(i<s.length())
        {
            if(arr[i] == arr[len])
            {
                // If the patterns match we
                lps[i] = len+1;
                i++;
                len++;
            }

            else
            {
                if(len!=0)
                {
                    len = lps[len-1];
                }
                else
                {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;


    }


    public static void main(String[] args) {
        String s = "abcdabca"; // -> 00001231
        
        for(int i: LPSArray(s))
        {
            System.out.print(i+ " ");
        }
    }
}
