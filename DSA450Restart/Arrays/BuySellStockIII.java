package DSA450Restart.Arrays;

public class BuySellStockIII {
    

    public int maxProfit(int[] prices) {
         
        if(prices.length == 0) return 0;
        int fb = Integer.MIN_VALUE;
        int sb = Integer.MIN_VALUE;
        int fs = 0,ss= 0;
        
        for(int i=0; i<prices.length; i++)
        {
            fb = Math.max(fb, -prices[i]); // Whatever fb is the max value for fb we got in the past 
            // either that or just the negation of prices[i]
            fs = Math.max(fs, fb+prices[i]);
            sb = Math.max(sb, fs-prices[i]);
            ss = Math.max(ss, sb+prices[i]);
            
        }
        
        return ss;
    }
}
