package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;

class Solution_BinarySearch {
    public int maxEnvelopes(int[][] envelopes) {
        // Sorting so that the width are sorted in ascending order but if at any point
        // we have width of same values adjacent, we just sort those values is descending order w.r.t the height
        Arrays.sort(envelopes, (a,b)->a[0] == b[0]? b[1]-a[1] : a[0]-b[0]);
        int n = envelopes.length;
        int ans[] = new int[n];   
        int maxlen = 0;
        
        for(int i=0; i<ans.length; i++)
        {
            int index = binarySearch(ans, 0, maxlen, envelopes[i][1]);
            ans[index] = envelopes[i][1];
            if(index == maxlen)
            {
                maxlen++;
            }
        }
        
        return maxlen;
    }
    
    public static int binarySearch(int[] ans, int start, int end, int target)
    {
        while(start<end)
        {
            int mid = start + (end - start)/2;
            
            if(ans[mid] == target)
            {
                return mid;
            }
            else if(ans[mid]<target)
            {
                start = mid+1;
            }
            else
            {
                end = mid;
            }
            
        }
        
        return start;

    }
}


class Solution_LISArray {
    public int maxEnvelopes(int[][] envelopes) {
         // Ok first we sort the envelopes int the order of width of them
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes, (int[] a, int[] b)->{
                return a[0]-b[0]; 
        });
        
        int[] lis = new int[envelopes.length+1];
        Arrays.fill(lis, 1);
        int max = 1;
        for(int i=1; i<envelopes.length; i++)
        {
            for(int j=0; j<i; j++)
            {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1] && lis[i]<1+lis[j])
                {
                    lis[i] = lis[j]+1;
                }
                
                if(lis[i]>max)
                {
                    max = lis[i];
                }
            }
        }
        return max;
        
        
        
        
    }
}