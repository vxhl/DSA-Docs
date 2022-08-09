class Solution {
    int helper_function(String s,int k,int idx,char ch,int dp[][]){
         if(idx==s.length()) return 0;
         if(dp[idx][ch]!=-1) return dp[idx][ch];
         int include=0;
         if(Math.abs(ch-s.charAt(idx))<=k || ch=='-') 
             include=1+helper_function(s,k,idx+1,s.charAt(idx),dp);
         int exclude=helper_function(s,k,idx+1,ch,dp);
        return dp[idx][ch]=Math.max(include, exclude);
         
     }
     public int longestIdealString(String s, int k) {
         int n=s.length();
         // We memoise for the range of the ascii values
         int dp[][]=new int[n+1][150];
         for(int d[]:dp)
          Arrays.fill(d,-1);
         return helper_function(s,k,0,'-',dp); 
         
     }
 }