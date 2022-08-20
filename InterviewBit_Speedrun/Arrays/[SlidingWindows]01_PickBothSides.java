class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // Several cards arranged in a row
        // 1 2 3 4 5 6 1
        // pref->1 3 5 9 14 20 21
        // suff->1 7 12 16 19 21 22
        
        // 9 7 7 9 7 3 9  k = 3
        // 9 9 7
        // pref => 9 16 23 32 39 46 55
        // suff => 9 12 19 28 35 42 51
        // In one step we can take one card from the beginning or the end of the row
        // We have to take exactly k cards
        // Score is the sum of the points of the cards we have taken
        // We are to return the maximum score we can obtain
        // k=3
        // 1 2 3 4 // => 6 5 1 ->12
        
        int n = cardPoints.length;
        int prefix[] = new int[n+1];
        int suffix[] = new int[n+1];
        
        prefix[1] = cardPoints[0];
        suffix[n-1] = cardPoints[n-1];
        
        for(int i=2; i<n+1; i++)
        {
            prefix[i] = cardPoints[i-1]+prefix[i-1];
        }
        for(int j=n-2; j>=0; j--)
        {
            suffix[j] = cardPoints[j]+suffix[j+1];
        }
        int card = 0;
        int totalScore = Integer.MIN_VALUE; // Convers all cases of negative values as well
        while(card<=k)
        {
            totalScore = Math.max(totalScore, prefix[card]+suffix[n-k+card]);
            card++;
        }
        return totalScore;
    }
    public int solve(int[] C, int K) {
        // Concise sliding windows in constant space
        int curr = 0;
        // We first get the total for the first k elements from the front
        for (int i = 0; i < K; i++) curr += C[i];
        int max = curr; // For now we set it as max
        // With i=k-1 meaning at index 2 and j starting to pick from the back
        // we increment and 
        for (int i = K - 1, j = C.length - 1; i >= 0; i--, j--) {
            curr = curr + C[j] - C[i]; // We increment by picking from the back and decrement
            // the latest value we added at the front
            max = Math.max(max, curr);
        }
        return max;
        
    }


}