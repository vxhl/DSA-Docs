// Problem Statement : Amazing substring is one that starts with a vowel
// and does not take into consideration the elements that come before
// Time Complexity : O(N)

package CodeWithScaler.Week2;

import java.util.Arrays;

public class AmazingSubArrays
{
    public static int AmazingSubStrings(String A)
    {
        int count = 0;
        for(int i = 0; i<A.length(); i++)
        {
            if(A.charAt(i)=='A' ||A.charAt(i)=='E' ||A.charAt(i)=='I' ||A.charAt(i)=='O' ||A.charAt(i)=='U' ||
                    A.charAt(i)=='a' ||A.charAt(i)=='e' ||A.charAt(i)=='i' ||A.charAt(i)=='o' ||A.charAt(i)=='u')
        {
            count += A.length()-i;
        }
        }
        return count%10003;
    }
    public static void main(String[] args) {
        String A = "ABECDEFGHIjklmnopqrsTUv";
        System.out.println(AmazingSubStrings(A)); // Output : 86
    }
}