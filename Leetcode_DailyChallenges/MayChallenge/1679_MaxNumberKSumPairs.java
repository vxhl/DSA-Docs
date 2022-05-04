package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class Solution_kSumPairs
{
    public static int maxOpskSum(int[] arr, int k)
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int count = 0;

        for(int i=0; i<arr.length; i++)
        {
            if(mp.containsKey(k-arr[i]))
            {
                count++;
                mp.remove(k-arr[i]);
                mp.remove(arr[i]);
            }
            else
            {
                mp.put(arr[i], i);
            }
        }
        return count;
        
    }
    public static void main(String[] args) {
        int[] arr = {3,1,3,4,3};
        System.out.println(maxOpskSum(arr, 5));
    }
}
