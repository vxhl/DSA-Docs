class Solution {
    public int countVowelPermutation(int n) {

        // Given a directed graph, count the number of paths of length n

        
        int mod = 1000000007;
        
        long[][]dp=new long[n+1][5];
        for(int i=0; i<5; i++){
            // All strings of length 1 will have a length of 1
            dp[1][i] = 1;
        }
        // Each vowel 'a' may only be followed by an 'e'.
        // Each vowel 'e' may only be followed by an 'a' or an 'i'.
        // Each vowel 'i' may not be followed by another 'i'.
        // Each vowel 'o' may only be followed by an 'i' or a 'u'.
        // Each vowel 'u' may only be followed by an 'a'.
        // === In other words: 
        // 'a' can be followed by {'e'}
        // 'e' can be followed by {'a', 'i'}
        // 'i' can be followed by {'a', 'e', 'o', 'u'}
        // 'o' can be followed by {'i', 'u'}
        // 'u' can be followed by {'a'}
        // === In other words:
        // 'a' can follow {'e', 'i', 'u'}
        // 'e' can follow {'a', 'i'}
        // 'i' can follow {'e', 'o'}
        // 'o' can follow {'i'}
        // 'u' can follow {'i', 'o'}
        
        // States for other lengths becomes
        for(int i=2; i<=n; i++){
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4])%mod; 
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%mod;
            dp[i][2] = (dp[i-1][1]+dp[i-1][3])%mod;
            dp[i][3] = (dp[i-1][2])%mod;
            dp[i][4] = (dp[i-1][2]+dp[i-1][3])%mod;
        }
        long ans = 0;
        for(long d: dp[n]){
            ans+=d;
            ans%=mod;
        }
        return (int)ans;
    }
}