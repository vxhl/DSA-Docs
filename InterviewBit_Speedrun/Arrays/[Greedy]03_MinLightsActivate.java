class Solution {
    public int solve(int[] A, int B) {
        int count = 0;
        int i = 0;
        int n = A.length;
        while(i<n){
            // We need to search on both the left and right sides
            int right = Math.min(n-1,i+B-1);
            int left = Math.max(0,i-B+1);
            boolean bulbFound = false;
            while(right>=left){
                if(A[right]==1){
                    bulbFound = true;
                    break;    
                }
                right--;
            }
            if(!bulbFound) return -1;
            // If we are able to light up we increment
            count++;
            i = right+B;
        }
        return count;
    }
}
