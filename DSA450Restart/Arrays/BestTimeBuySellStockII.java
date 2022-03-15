package DSA450Restart.Arrays;

public class BestTimeBuySellStockII {

    // Approach 1: O(N) time and O(1) space
    // Does this even need any more optimisations? 
    public int maxProfit(int[] arr) {
        int buy = -1;
        int sell = 0;
        int profit = 0;
        int i=0;
        for(i=0; i<arr.length-1; i++)
        {
            if(buy == -1 && arr[i]<arr[i+1])
            {
                buy = arr[i];
            }
            
            else if(buy!=-1 && (arr[i]>arr[i+1] || i == arr.length-1))
            {
                sell = arr[i];
                profit += (sell-buy);
                buy = -1;
                sell = 0;
            }
        }
        if(buy != -1)
        {
            sell = arr[arr.length-1];
            profit+=(sell-buy);
        }
        return profit;
    }

    //Approach 2: Removing the garbage
    // Instead of storing our values for buy and sell we can
    // just keep increasing our profit as long as our values keep increasing
    public int SBSII_better(int[] arr)
    {   
        int profit = 0;
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i-1]<arr[i])
            {
                profit += arr[i] - arr[i-1];
            }
        }
        return profit;
    }

}
