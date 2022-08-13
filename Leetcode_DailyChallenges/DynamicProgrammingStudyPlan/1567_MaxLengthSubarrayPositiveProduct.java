class Solution {
    public int getMaxLen(int[] nums) {
        // Ok i get the intutition
        // Basically instead of  counting all the negative
        // values that we have, we instead use the negative values as
        // a flag for when our product becomes negative, and when we encounter
        // a negative number again we reset our flag and the product becomes positive
        // As for expection 0 cases, our positive and negative products become 0 so we reset
        // and start over for the next subarray
        // we don't need to multiply at all for this problem just need to keep good care of the flag
        
        int positive = 0;
        int negative = 0;
        int maxLen = 0;
        for(int i: nums){
            if(i==0){
                // If encounter 0 we reset
                positive = 0;
                negative = 0;
            }
            else if(i>0){
                // If still greater than 0 then we keep incrementing our positive
                // and we also increment our negative if we have encountered negative values before of odd freq
                positive++;
                negative = negative == 0?0:negative+1;
            }
            // If we ever encounter a negative value we swap our positive and negative values
            // this condition is like a flag that alternates between negative and positive count of 0s
            else {
                int temp = positive;
                positive = negative;
                positive = positive == 0? 0: positive+1;
                negative = temp+1;
            }
            
            maxLen = Math.max(maxLen, positive);
        }
        
        return maxLen;
        
        
    }
}