package DSA450Restart.Strings;
// We need to consider the two cases of the sequence starting with 0 and starting with 1
class Solution {
    public int minFlips(String S) {
        // Code here
        int ans1 = 0;
        int ans2 = 0;
            for(int i=0; i<S.length(); i++)
            {
                if(i%2==0 && S.charAt(i)!='0')
                {
                    ans1++;
                }
                else if(i%2!=0 && S.charAt(i)!='1')
                {
                    ans1++;
                }
                
            }
        
            for(int i=0; i<S.length(); i++)
            {
                if(i%2==0 && S.charAt(i)!='1')
                {
                    ans2++;
                }
                else if(i%2!=0 && S.charAt(i)!='0')
                {
                    ans2++;
                }
                
            }
        
               
        
        return Math.min(ans1, ans2);
}
}