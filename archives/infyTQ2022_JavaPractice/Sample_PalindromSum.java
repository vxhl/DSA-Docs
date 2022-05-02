// Input: integer N 
// Output: Palindrome calculated after adding N with it's reverse and we print the output

package infyTQ2022_JavaPractice;
import java.util.*;
class DriverClass_infyTQ
{
    public static void main(String[] args) {
        int n = 195;
        Solution_sample.psum(n);
    }
}

class Solution_sample
{

    public static int psum(int N)
    {
        int res = 0;
        if(!palindrome_check(N))
        {
            res = N - reverse_check(N);
        }
        return res;
    }
    private static boolean palindrome_check(int N)
    {
        // for checking palindrome we need to convert it into a string? 
        if(N-N==0)
        {
            return true;
        }
        return false;

    }
    public static int reverse_check(int N)
    {
        int rev = 0;
        while(N!=0)
        {   
            int remainder = N%10;
            rev = rev*10 + remainder;
            N = N/10;
        }
        return rev;
    }
}