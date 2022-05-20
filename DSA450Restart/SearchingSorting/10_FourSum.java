package DSA450Restart.SearchingSorting;
import java.util.*;
class fourSum {
    public List<List<Integer>> fourSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        // int i = 0;
        // int j = arr.length-1;
        
        for(int i=0; i<arr.length; i++)
        {
            
        for(int j = i+1; j<arr.length; j++)
        {
                int low = j+1;
                int high = arr.length-1;
                
                while(low<high)
                {
                    if((arr[i]+arr[j]) == target-(arr[low]+arr[high]))
                    {
                        
                        List<Integer> ds = new ArrayList<>();
                        ds.add(arr[i]);
                        ds.add(arr[j]);
                        ds.add(arr[low]);
                        ds.add(arr[high]);
                        res.add(ds);
                        
                        while(low<high && arr[low+1] == arr[low]) low++;
                        while(low<high && arr[high-1] == arr[high]) high--;
                        low++;
                        high--;
                    }
                    else if((arr[i]+arr[j])<target - (arr[low]+arr[high]))
                    {
                        low++;
                    }
                    else
                    {
                        high--;
                    }
                }
                 while(j+1<arr.length && arr[j+1]==arr[j])j++;   
            
        }
        while(i+1<arr.length && arr[i+1]==arr[i])++i;

            
        }
        
        return res;
        
        
    }
}