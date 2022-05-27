import java.util.*;
class Solution {

    // Even tho this approach is correct this does not give us our answer since the slope reaches beyond values of double
    // THe only way the get the answer using this is using BigDecimal class in java

    public int minimumLines2(int[][] stockPrice) {
        // First we need to sort the array in accordance with the first element so that
        // we can traverse the lines in a sequential manner
        Arrays.sort(stockPrice, (a,b)-> (a[0]-b[0]));
        
        // We initialise our count variable for the result
        int ans = 0;
        // And we also initialise our previous slope value
        double prevSlope = Double.MAX_VALUE;
        
        for(int i=1; i<stockPrice.length; i++)
        {
            double currSlope = ((double)(stockPrice[i][0] - stockPrice[i-1][0]) / (double)(stockPrice[i][1]-stockPrice[i][1]));
            if(currSlope == prevSlope)
            {
                continue;
            }
            else
            {
            ans++;
            prevSlope = currSlope;
            }
        }
        
        return ans;
        
    }
    
    
    // So we take the slopes and the price and we calculate them by multiplying one with the other instead of division.
    public int minimumLines(int[][] stockPrice) {
        if(stockPrice.length == 1) return 0;
        int count = 1;
        Arrays.sort(stockPrice, (a,b)->(a[0]-b[0]));
        
        for(int i=2; i<stockPrice.length; i++)
        {
            if(((stockPrice[i][1] - stockPrice[i-1][1]) * (stockPrice[i-1][0] - stockPrice[i-2][0]))!=
               ((stockPrice[i-1][1] - stockPrice[i-2][1]) * (stockPrice[i][0] - stockPrice[i-1][0])))
               {
                   count++;
               }
        }
               return count;
        
    }
}