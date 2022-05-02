package Arrays.SlidingWindowsProblems;
import java.util.*;
public class LargestSubarrayOfSumK {
    
    // ONLY POSITIVE NUMBERS
    
     // Function for finding maximum and value pair
     public static int lenOfLongSubarr (int arr[], int N, int sum) {
        //Complete the function
        // We initialise our window sizes first
        int i=0;
        int j=0;
        // We initialise our max count element for the subarray
        int mx = 0;

        // We initialise our current sum
        int curr = 0;

        int n = arr.length;
        int count = 0;
        while(j<n)
        {
            curr += arr[j];  
            if(curr<sum)
            {
                j++;
            }
            else if (curr==sum)
            {
                mx = Math.max(mx, j-i+1);
                curr = 0;
                
                j++;
            }
            else
            {
                while(curr>sum)
                {
                    curr -= arr[i];
                    i++;
                    
                }
                j++;
            }
        }

        return mx;
    }


    // BOTH POSITIVE AND NEGATIVE NUMBERS
  // Function for finding maximum and value pair
  public static int lenOfLongSubarr2 (int A[], int N, int K) {
    //Complete the function
    HashMap<Integer,Integer> hmap=new HashMap<>();
    int sum=0,len=0;
    for(int i=0;i<N;i++){
        sum+=A[i];
        if(sum==K) len=i+1;
        if(!hmap.containsKey(sum)) hmap.put(sum,i);
        if(hmap.get(sum-K)!=null) len=Math.max(len,i-hmap.get(sum-K));
    }
    return len;
}

}
