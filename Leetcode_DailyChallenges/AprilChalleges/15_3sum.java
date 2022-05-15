package DSA450Restart.Arrays;
import java.util.*;
class Solution_3Sum
{
    public List<List<Integer>> threeSum(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        
        // We are only iterating till the last 3rd elmeent since that is till where we will have 3 elements in our range
        for(int i=0; i<arr.length-2; i++)
        {
            // I do not need to look at the solution. I can do this by myself pretty easily tbh. 
            // For the first number in the arr or if it is not the first number and it is also not a repetition of the previous number we have traversed then we do the following
            if(i==0 || (i>0 && arr[i-1]!=arr[i]))
            {
                int low = i+1;
                int high = arr.length-1;
                while(low<high)
                {
                    // What we need is our target to be arr[i] negative right
                    // So basically we return when our -arr[i] == low+high
                    if(-(arr[i]) == arr[low]+arr[high])
                    {
                        // We add the result to the list so it becomes
                        ArrayList<Integer> ds = new ArrayList<>();
                        ds.add(arr[i]);
                        ds.add(arr[low]);
                        ds.add(arr[high]);
                        res.add(ds);
                        // After adding to the list we run another loop so that we do not encounter more elements having the same low
                        // that we already added and we do the same for our high
                        while(low<high && arr[low] == arr[low+1]) low++;
                        // We do the same for our high condition
                        while(low<high && arr[high] == arr[high-1]) high--;
                        
                        // After doing so we as usual do our traversal for the next operands
                        // since we have already added for the present elements
                        low++;
                        high--;
                        
                    }
                    
                    else if(arr[low]+arr[high]<-(arr[i])) low++;
                    else high--;
                }
                
                
            }
        }
        
        return res;
    }


    public List<List<Integer>> threeSum2(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        
        // We are only iterating till the last 3rd elmeent since that is till where we will have 3 elements in our range
        for(int i=0; i<arr.length-2; i++)
        {
            // I do not need to look at the solution. I can do this by myself pretty easily tbh. 
            // For the first number in the arr or if it is not the first number and it is also not a repetition of the previous number we have traversed then we do the following
            if(i==0 || (i>0 && arr[i-1]!=arr[i]))
            {
                int low = i+1;
                int high = arr.length-1;
                while(low<high)
                {
                    // What we need is our target to be arr[i] negative right
                    // So basically we return when our -arr[i] == low+high
                    if(-(arr[i]) == arr[low]+arr[high])
                    {
                        // We add the result to the list so it becomes
                        ArrayList<Integer> ds = new ArrayList<>();
                        ds.add(arr[i]);
                        ds.add(arr[low]);
                        ds.add(arr[high]);
                        res.add(ds);
                        // After adding to the list we run the loop for our low condition 
                        // so that we skip all the repeating elements that we have in our traversal
                        while(low<high && arr[low] == arr[low+1]) low++;
                        // We do the same for our high condition
                        while(low<high && arr[high] == arr[high-1]) high--;
                        
                        // After doing so we as usual do our traversal for the next operands
                        // since we have already added for the present elements
                        low++;
                        high--;
                        
                    }
                    
                    else if(arr[low]+arr[high]<-(arr[i])) low++;
                    else high--;
                } 
            }
        }
        
        return res;
    }
}