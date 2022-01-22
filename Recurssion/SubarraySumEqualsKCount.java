package Recurssion;
import java.util.*;

public class SubarraySumEqualsKCount {
    static int SubarraySumEqualsKCountUtil(int ind, ArrayList<Integer> ds, int s,int[] arr, int k )
    {
        // Base Case
        if(ind==arr.length)
        {
            if(s==k)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        // Recursion calls
        ds.add(arr[ind]);
        s += arr[ind];
        int  l = SubarraySumEqualsKCountUtil(ind+1, ds, s, arr, k);
        s -= arr[ind];
        ds.remove(ds.size() - 1);
        int r = SubarraySumEqualsKCountUtil(ind+1, ds, s, arr, k);

        return l+r;
    }

    static int SubarraySumEqualsKCountHashmap(int arr[], int n, int sum)
    {
        // We use a hashmap to sotre the number of subarrays starting
        // from index zero having particular value of sum
        HashMap<Integer, Integer> prevSum = new HashMap<>();
 
        int res = 0;
 
        // Sum of elements so far.
        int currsum = 0;
 
        for (int i = 0; i < n; i++) {
 
            // Add current element to sum so far.
            currsum += arr[i];
 
            // If currsum is equal to desired sum,
            // then a new subarray is found. So
            // increase count of subarrays.
            if (currsum == sum)
                res++;
 
            // currsum exceeds given sum by currsum
            //  - sum. Find number of subarrays having
            // this sum and exclude those subarrays
            // from currsum by increasing count by
            // same amount.
            if (prevSum.containsKey(currsum - sum))
                res += prevSum.get(currsum - sum);
 
            // Add currsum value to count of
            // different values of sum.
            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }
 
        return res;

    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int k = 3;
        ArrayList<Integer> ds = new ArrayList<>();
        System.out.println(SubarraySumEqualsKCountUtil(0, ds, 0, arr, k));
    }
}
