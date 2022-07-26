class Solution {
    // O(N+M) approach
    // O(N*(MLogM)) approach

    public int[] platesBetweenCandles1(String s, int[][] queries) {
        
        int n = s.length();
        
        int[] leftMostCandles = new int[n];
        int[] rightMostCandles = new int[n];
        int[] platesPrefix = new int[n];
        
        // We compute all the indexes for the leftMost prefix for candles
        int index = -1;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '|'){
                index = i;
            }
            leftMostCandles[i] = index;
        }
        index = -1;
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '|'){
                index = i;
            }
            rightMostCandles[i] = index;
        }
        int currPlates = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='*'){
                currPlates++;
            }
            platesPrefix[i] = currPlates;
        }
        int[] ans = new int[queries.length];
        
        for(int i=0; i<queries.length; i++){
            int left = rightMostCandles[queries[i][0]];
            int right = leftMostCandles[queries[i][1]];
            // System.out.print(left + " "+ right);
            if(left == -1 || right == -1){
                ans[i] = 0;
            }
            else{
                if(right-left>0){
                    ans[i] = platesPrefix[right]-platesPrefix[left];
                }
                else{
                    ans[i] = 0;
                }
            }
        }
        
        return ans;
    }


    public int[] platesBetweenCandles(String s, int[][] queries) {
        
        int[] prefixPlates = new int[s.length()];
        int currPlates = 0;
        
        List<Integer> candleIndexes = new LinkedList<>();
        prefixPlates[0] = (s.charAt(0) == '*') ? 1 : 0;
        if(s.charAt(0) == '|') candleIndexes.add(0);
        int n  = s.length();
        
        for(int i = 1; i < n; i++) {
            if(s.charAt(i) == '*') {
                prefixPlates[i] = 1 + prefixPlates[i - 1];
            } else {
                prefixPlates[i] = prefixPlates[i - 1];
                candleIndexes.add(i);
            }
        }
        int[] ans = new int[queries.length];        
        for(int i=0; i<queries.length; i++){
            if(candleIndexes.size()>0){
            int[] firstLast = firstLastOccurenceCandles(s, candleIndexes, queries[i][0], queries[i][1]);
            int left = firstLast[0];
            int right = firstLast[1];
            if(left == -1 || right == -1) continue;
            else if(left == 0) { ans[i] = prefixPlates[right];}
            else { ans[i] = prefixPlates[right]-prefixPlates[left-1];}
            }
            
            // If there are no candles in the current index
            else{
                ans[i] = 0;
            }
        }
        return ans;
    }
    
    private int[] firstLastOccurenceCandles(String s, List<Integer> candle, int start, int end)
    {
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        int low = 0;
        int high = (int)candle.size()-1;
        while(low<=high)
        {
            int amid = (low+high)/2;
            int mid = candle.get(amid);
            if(mid>=start && mid<=end){
                ans[0] = mid;
                high = amid-1;
            }
            if(mid<start) low = amid+1;
            if(mid>end) high = amid-1;
        }
        low = 0;
        high = (int)candle.size()-1;
         
        while(low<=high)
        {
            int amid = (low+high)/2;
            int mid = candle.get(amid);
            if(mid>=start && mid<=end){
                ans[1] = mid;
                low=amid+1;
            }
            if(mid<start) low = amid+1;
            if(mid>end) high = amid-1;
        }
        
        return ans;
    }
}