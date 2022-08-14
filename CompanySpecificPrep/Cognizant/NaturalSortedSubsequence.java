import java.util.*;
public class NaturalSortedSubsequence {
    public int naturalSortedSS(String s){
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        char[] s1 = s.toCharArray();
        return helper(0, s1, '#', dp);
    }

    private int helper(int i, char[] s, char curr, int[]dp){
        // Feels very similar to LIS
        if(i==s.length){
            return 0;
        }
        int include = 0;
        int exclude = 0;
        if(dp[i]!=-1){
            return dp[i];
        }
        if(s[i]>curr)
        {
            include = 1+helper(i+1, s, s[i], dp);
        }
        else
        {
            exclude = helper(i+1, s, curr, dp);
        }

        return dp[i] = Math.max(include, exclude);
    }


    public int findPath(int input1, int input2, int[][] input3){
        int count = 0;
        for(int i=0; i<input3.length; i++){
            for(int j=0; j<input3[0].length; j++){
                if(input3[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }
}
class main{
    public static void main(String[] args) {
        NaturalSortedSubsequence obj1 = new NaturalSortedSubsequence();
        String s = "abzd";
        System.out.print(obj1.naturalSortedSS(s));
    }
}
