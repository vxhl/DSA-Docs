class Solution {

    // More than 1 pass
    public int longestMountain(int[] arr) {
        /*
        We can store all the peak elements in the array and
        take two pointer on either side of the peak element and keep traversing it while meeting the conditions
        required for the left and right parts of the array
        */
        if(arr.length<3 || arr == null){
            return 0;
        }
        
        int ans = 0;
        
        for(int i=1; i<arr.length-1; i++){
            
            // We first define a condition for finding our peak
            if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
                int left = i-1;
                
                // We now expand towards the left
                while(left>0 && arr[left-1]<arr[left]){
                    left--;
                }
                
                int right = i+1;
                
                // We expand towards the right
                while(right<arr.length-1 && arr[right+1]<arr[right]){
                    right++;
                }
                
                // We try to recache the answer everytime
                ans = Math.max(ans, right-left+1);
            }
        }    
        return ans;       
    }
}