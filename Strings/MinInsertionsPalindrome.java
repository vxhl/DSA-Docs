package Strings;

public class MinInsertionsPalindrome {
    
    
    static boolean ispalindrome(String A) {
        int l = A.length();
 
        for (int i = 0, j = l - 1; i <= j; i++, j--) {
            if (A.charAt(i) != A.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public int MinInsertionsToPalindrone(String A)
    {
        int cnt = 0;
        int flag = 0;
 
        while (A.length() > 0) {
            // if string becomes palindrome then break
            if (ispalindrome(A)) {
                flag = 1;
                break;
            } else {
                cnt++;
 
                // erase the last element of the string
                A = A.substring(0, A.length() - 1);
                //s.erase(s.begin() + s.length() - 1);
            }
        }
 
        // print the number of insertion at front
        if (flag == 1) {
            return cnt;
    }
}
}

