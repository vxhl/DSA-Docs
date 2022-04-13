package DSA450Restart.Strings;

class Solution_EditDistance
{
    /*
    Ok let's summarise

    s1 = "horse" s2 = "ros"
    we need to convert our s1 to s2 right and we have 3 operations of delete insert and replace
    we need to try all of these 3 operations and try to find out which one of these is the best

    we have two pointer let's say i and j at the end of s1 and s2 respectively
    1. For Insert Operation:
        First we see that they are not matching right, so in that case we just insert the matching character from s2[j] into our s1 so that makes 1 operation
        and after doing so we increment our jth pointer but we don't do the same for our ith pointer since that is still not the same as our jth pointer
        we have just abstracted the addition of a character as 1 so our function becomes ->1 +  f(i, j-1)
    2. For Delete Operation 
        In case of delete, we simply delete the element from the s1 and on doing so we move downwards in s1 so i-- but no changes happen with j because we
        are matching the element at j after deleting the elmement at s1 ->1 +  f(i-1, j)
    3. For Replace Operation
        We just replace the element at the s1[i] with the element at s2[j] and on doing so we match the two element and we simply decremenet both i and j
        -> 1 + f(i-1, j-1)

    These are the three operations and if we find both elements as equal we don't do any of the operations and decrement our both pointers


    Now for the base cases, we either exhaust our s1 or we exhaust our s2
    If we exhaust s1 -> Then that means i<0 meaning, j>0 and then we just do our insert operation where we insert the remaining number of elements in j into our count
    So base condition 1 -> return j+1;
    Similarly if we exhaust s2 -> Means we have exhausted s2 and i>0, we simply delete all the elements that are left in s1 after exhausting s2 and so we return i+1 as he 
    number of delete operations remaining.

    Using simple recursion this will take exponential time complexity so we memoise our results
    */


    // Exponential Recursive Solution
    private static int f(int i, int j, String s1, String s2)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;

        // If they are matching we simply return and decrement our pointers
        if(s1.charAt(i) == s1.charAt(j)) return f(i-1, j-1, s1, s2);

        // From insert, delete and replace we take the one that does the minimum number
        // of operation
        return 1 + Math.min(f(i-1, j, s1, s2), Math.min(f(i,j-1,s1,s2), f(i-1,j-1,s1,s2)));

    }

    public static int editDistance(String s1, String s2)
    {
        int n = s1.length();
        int m = s2.length();

        return f(n-1, n-2, s1, s2);

    }


    // Dynamic Programming Solution

    public static int f2(int i, int j, int[][] dp, String s1, String s2)
    {
        // Base cases

        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = f2(i-1,j-1,dp, s1, s2);
        return dp[i][j] = 1 + Math.min(f2(i-1, j, dp, s1, s2), Math.min(f2(i,j-1,dp,s1,s2), f2(i-1,j-1,dp,s1,s2)));
    }


    public static int editDistance2(String s1, String s2)
    {

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[1000][1000];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                dp[i][j] = -1;
            }
        }

        return f2(n-1, m-1,dp, s1, s2);



    }
}