package Recurssion;
import java.util.*;

class examples {
    
    public static boolean palindromeCheck(int i, String s)
    {
        int n = s.length();
        // The only way for it to be a palindrome is if
        // our pointer reaches to the middle of the array without encountering a
        // dissimilar variable- 
        if(i>=n/2) return true;
        if(s.charAt(i)!=s.charAt(n-i-1)) return false;
        return palindromeCheck(i+1, s);
    }

    // Fibonacci with recurssion
    public static int nthfibonacci(int n)
    {
        if(n<=1) return n;
        return nthfibonacci(n-1) + nthfibonacci(n-2);
    }
}
