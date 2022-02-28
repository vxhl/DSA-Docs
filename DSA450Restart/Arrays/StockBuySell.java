package DSA450Restart.Arrays;

public class StockBuySell {
    
     
    // public static int sbs(int[] arr)
    // {
    //     int[] dp = new int[arr.length];
    //     int buy = arr[0];
    //     for(int i: dp)
    //     {
    //         i=0;
    //     }

    //     for(int i=0; i<arr.length; i++)
    //     {
    //         dp[i] = Math.max(dp[i-1], arr[i] - buy);
    //         buy = Math.min(arr[i], buy);
    //     }

    //     return dp[arr.length];
    // }

    public static int sbs(int[] arr)
    {
        int buy = arr[0];
        int profit = 0;

        for(int i=0; i<arr.length; i++)
        {
            profit = Math.max(profit, arr[i]-buy);
            buy = Math.min(buy, arr[i]);
        }

        return profit;
    }
}
