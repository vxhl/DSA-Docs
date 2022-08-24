class Solution {
    public int numDecodings(String s) {
        // We are to return the number of ways we can decode a string of given number
        /* 
        "11106"
        If we had this, then find the ways to decode this
        so let's split into subarrays ofc
        1 1 1 0 6 invalid
        1 11 06 invalid
        1 1 10 6 valid
        11 10 6 valid
        So we have two valid strings to decode here
        When is a string valid then?
        When the subarray value 1<=subarrayValue<=26
        and there are no leading zeroes in the subarray
        So we got out base condition
        
        if(s[ind]==0) return 0;
        if(Integer.parseInt(substring(i,i+2)))<=26 then we pick
        When do we have a result or a valid partition? 
        when ind==n then we have a valid partition so return 1 only in that case
        */
        int[] dp = new int[s.length()+1];
        // Now we try to tabulate this
        dp[0] = 1;
        // Since we cannot ever start with 0
        dp[1] = s.charAt(0)!='0'?1:0;
        for(int i=2; i<=s.length(); i++){
            // We store for one digit numbers or character
            int first = Integer.valueOf(s.substring(i-1,i));
            // We store for two digit numbers corresponding characters
            int second = Integer.valueOf(s.substring(i-2,i));
            if(first>=1 && first<=9){
                dp[i] += dp[i-1];
            }
            if(second>=10 && second<=26){
                dp[i]+=dp[i-2];
            } 
        }
        
        return dp[s.length()];
        
    }
    
    // Memoisation + Recursion
    int helper(int ind, String sa, int[]dp){
        if(ind==sa.length()){
            return 1;
        }
        
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        // Another base condition
        if(sa.charAt(ind)=='0'){
            return 0;
        }
        
        int include = 0;
        int exclude = 0;
        if(ind<sa.length()-1 && Integer.parseInt(sa.substring(ind, ind+2))<=26){
            include = helper(ind+2, sa,dp);
        }   
        // Now there are no choices here, but we are to find the number of ways
        // by either including or excluding the current index
        exclude = helper(ind+1,sa,dp);
        
        return dp[ind]=include+exclude;
    }
}