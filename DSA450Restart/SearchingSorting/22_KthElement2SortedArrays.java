class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        
        for(int i=m-1; i>=0; i--)
        {
            int last = arr1[n-1];
            int j = 0;
            
            for(j=n-2; j>=0 && arr1[j]>arr2[i]; j--)
            {
                arr1[j+1] = arr1[j];
            }
            if(j!=n-2 || last>arr2[i])
            {
                arr1[j+1] = arr2[i];
                arr2[i] = last;
            }
        }
        long ans = 0;
        
        if(k<=arr1.length)
        {
           ans = (long)arr1[k-1];
        }
        else
        {
            // System.out.print("working2");
            k = k-arr1.length;
            ans = (long)arr2[k-1];
        }
        return ans;
        
        
        
    }
}