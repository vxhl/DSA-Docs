class Solution {



    // Memoisation approach
    public boolean wordBreak(String s, List<String> wordDict) {
        // How to memoise?
        Boolean[] dp = new Boolean[s.length()];
        return helper(0, wordDict, s,dp);
    }
    private boolean helper(int ind, List<String> wordDict, String s,Boolean[]dp){
        // If we manage to reach the end of the string
        if(ind==s.length()){
            return true;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        // We take the current substring and check if we have it in our wordDict
        String curr = s.substring(ind);
        boolean matches = false;
        // Now for every word we have in wordDict
        for(String w: wordDict){
            // If the current substring starts with the word in wordDict
            if(curr.startsWith(w)){
                // Means we have something
                // We set 
                if(helper(ind+w.length(), wordDict, s, dp))
                    matches=true;       
                    dp[ind]=matches;
            }
        }
        return dp[ind]=matches;
        
    }
}