package DSA450Restart.Arrays;

public class StockBuySell {
    
     
   

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
