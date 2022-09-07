class Solution {
    public int minimumDeletions(String s) {
        int bcount = 0;
        int[] dp = new int[s.length()+1];
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='a'){
                dp[i+1] = Math.min(dp[i]+1, bcount);
            }else{
            dp[i+1] = dp[i];
                bcount++;
            }
        }
    return dp[s.length()];
    }
}