public class ConcatenateBinaryString {
    
}
class Solution {
    public int concatenatedBinary(int n) {
        long ans = 0;
        int mod = 1000000007;
        int l = 0;
        
        for(int i=1; i<=n; ++i){
            // This condition checks for everytime when
            // our length of string increases meaning,
            // our number at i is even
            if((i&(i-1))==0) l++;
            
            // We left shift by l positions let's say for first 01 we left shift by l positions
            // meaning we go from 01 -> 100 and then we add to it i(2) 100 + 010 -> 110 for n=2
            // next for n=3 again we left shift by 2 so 11000 and add i which is 3 so we get
            // 11011 so 27 which is our answer for n=3
            // next we have 4 so our length increases to 3 
            // 11011000 + 4 -> 11011100 
            ans  = ((ans<<l)+i)%mod;
        }
        return (int)ans;
    }
}


/*
  1
 10
 11
100
for 3 length the concatenation is 11011
*/