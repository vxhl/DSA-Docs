class Solution {
    
    public boolean isSubsequence(String s, String t) {
    
        int n1 = s.length();
        int n2 = t.length();
        // For index of s ( or subsequence )
        
        int p1=0;
        
        for(int i=0; i<n2 && p1<n1; i++){
            if(s.charAt(p1) == t.charAt(i)){
                p1++;
            }
        }
        
        return p1==n1;
    }
    
    public boolean isSubsequence1(String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        
        int[][] dp = new int[n1+1][n2+1];
        
        for(int i=0; i<n1+1; i++){
            for(int j=0; j<n2+1; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=1; i<n1+1; i++){
            for(int j=1; j<n2+1; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2]==n1? true: false;
    }
}