package DSA450Restart.Arrays;
import java.util.*;
public class CountPairsGivenSum {
    public static int cpg_recursive(int[] nums, List<Integer> ds, int n, int k)
    {
        // Our base condition
        int count = 0;
        if(k==0)
        {
            count++;
        }   
        if(nums[n-1]<=k)
        {
            ds.add(nums[n-1]);
            cpg_recursive(nums, ds, n-1, k-nums[n-1]);
            ds.remove(ds.size()-1);
            cpg_recursive(nums, ds, n-1, k);
        }

        return count;

    }

    public static int getPairsCount(int arr[], int n, int k)
    {
        HashMap<Integer, Integer> m = new HashMap<>();

        // Creating a frequency HashMap
        for(int i=0; i<arr.length; i++)
        {
            if(!m.containsKey(arr[i]))
            {
                m.put(arr[i], 0);
            }
            m.put(arr[i], m.get(arr[i] +1));
        }


        int count = 0;
        // Iterate through each element and increment
        // Each pair is counted twice
        for(int i=0; i<arr.length; i++)
        {
            // We check if we have elements pair for the target minus the current element
            if(m.get(k-arr[i]) != null)
            {
                // If we do we increment
                count += m.get(k-arr[i]);
            }
            if(k-arr[i] == arr[i])
            {
                count--;
            }
        }
        // We divide the count since everytime we count the pairs we are also counting
        // it's symmetric counterpart and we do not need recurring pairs. So we divide the count
        return count/2;

    }
    

    public static void main(String[] args) {
        int[] nums = {1,5,7,1};
        // List<Integer> ds = new ArrayList<>();
        // int k = 6;
        // int n = nums.length;
        int k = 6;
        // System.out.println(cpg_recursive(nums, ds, n, k));
        System.out.println(getPairsCount(nums, nums.length, k));
    }
}
