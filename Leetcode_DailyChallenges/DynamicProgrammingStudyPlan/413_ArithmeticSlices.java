class Solution {
    /*
    Difference between any two consecutive elements is the same
    Case 1:
    [1 3 5 7 9]
    So this is a valid one
    3-1 = 2 | 5-3 = 2 | 7-5=2 | 9-7=2 | 
    Case 2:
    We are to return the number of arithmetic subarrays
    in [1 2 3 4] we have
    1 2 
    2 3
    3 4 
    Case 3: 
    [1] is a one element array and has less than 3 so not a sequence
    
    3 -1 -5 -9
    So we got 3 here as well
    3 -1 -> 4
    -1 + 5 -> 4
    -5 + 9 -> 4

    1 3 5 7 8 9 11 12
    
    */
    public int numberOfArithmeticSlices(int[] arr) {
        if(arr.length<3) return 0;
        int ans = 0;
        int cache = 0;
        for(int i=2;i<arr.length; i++){
            // So we only continue caching for the AS as long as we have an arithmetic sequence
            // continuing
            if(arr[i]-arr[i-1]==arr[i-1]-arr[i-2]){
                cache += 1;
                ans += cache;
            }else{
                // As soon as we see that we don't have an arithmetic sequence anymore, we break the cache and set it back to 0
                cache=0;
            }
        }
        return ans;
    }
}