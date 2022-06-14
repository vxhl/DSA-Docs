class Solution {
    public int minimumTotal(List<List<Integer>> triangle){
        
        // So we store the minPath in this 
        int n = triangle.size();
        int[] minlen = new int[n];
        for(int i=0; i<n; i++)
        {
            minlen[i] = triangle.get(n-1).get(i);
        }
        
        
        for(int i=n-2; i>=0; i--)
        {
            for(int j=0; j<=i; j++)
            {
                minlen[j] = Math.min(minlen[j], minlen[j+1])+triangle.get(i).get(j);
            }
        }
        
        for(int i=0; i<n; i++)
        {
            System.out.print(minlen[i]+ " ");
        }
        return minlen[0];
    
    }
}