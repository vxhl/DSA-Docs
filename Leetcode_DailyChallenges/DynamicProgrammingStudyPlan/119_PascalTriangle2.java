class Solution {
    public List<Integer> getRow(int rowIndex) {
        // Ok this time we are to just return a row
        // We could do this by generating them all buy will probably be too inefficient
        Integer[] ans = new Integer[rowIndex+1];
        Arrays.fill(ans,0);
        ans[0]=1;
        for(int i=1; i<rowIndex+1; i++){
            for(int j=i; j>0; j--){
                ans[j]=ans[j]+ans[j-1];
            }
        }
        return Arrays.asList(ans);   
    }
}