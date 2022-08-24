class Solution {
    
    /*
    An ugly number:
    prime factors-> 2,3,5
    return the nth ugly
    n=10
    nth ugly sequence
    What's the recurrence relation here? 
    [1,2,3,4,5,6,8,9,10,12]
    */
    public int nthUglyNumber(int n) {
        // So at each step, we are checking for multiples of 2,3 and 5 and choosing the
        // minimum among them
        // We take the 3 multiples right
        int two = 2;
        int three = 3;
        int five = 5;
        int[] dp = new int[n];
        dp[0]=1;
        // and we take indexes for each
        int index2=0; int index3=0;int index5 = 0;
        for(int i=1; i<n; i++){
            // Now we get the minimum current multiple to place at the 2nd position
            int min = Math.min(Math.min(two,three),five);
            dp[i]=min;
            // After placing we got to the next multiple
            if(two==min){
                // We increment our index representing we have picked the 
                // 2nd multiple
                index2++;
                // And we increment 2 by it's next multiple
                two = 2*dp[index2];
                System.out.print(two+ " ");
            }
            if(three==min){
                index3++;
                three = 3*dp[index3];
            }
            if(five==min){
                index5++;
                five = 5*dp[index5];
            }
        }
        return dp[n-1];
    }
}