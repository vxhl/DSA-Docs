class Solution {
    public int[] shortestToChar(String s, char c) {
        
        if(s == null) return new int[]{};
        if(s.length()==1 && s.charAt(0) == c) return new int[]{0};
        int n = s.length();
        
        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        for(int i=0; i<n; i++)
        {   
            if(s.charAt(i) == c) 
            {
                ans[0] = i; break;
            }
        }
        
        for(int i=1; i<n-1; i++){
            if(s.charAt(i) == c) {
                ans[i] = 0;
            }
            else{
                int left = i-1;
                while(left>0 && s.charAt(left)!=c){
                    left--;
                }
                if(s.charAt(left) == c) ans[i] = i-left;
                int right = i+1;
                while(right<n-1 && s.charAt(right)!=c){
                    right++;
                }
                if(s.charAt(right) == c) ans[i] = Math.min(ans[i], right-i);
            }
        }
        
        for(int i=n-1; i>=0; i--)
        {   
            if(s.charAt(i) == c) 
            {
                ans[n-1] = n-1-i; 
                break;
            }
        }
        
        return ans;
    }
}