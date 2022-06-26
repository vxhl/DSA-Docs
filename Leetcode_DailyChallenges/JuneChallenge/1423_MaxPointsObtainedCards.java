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
        int totalScore = 0;
        while(card<=k)
        {
            totalScore = Math.max(totalScore, prefix[card]+suffix[n-k+card]);
            card++;
        }
        return totalScore;
    }
}