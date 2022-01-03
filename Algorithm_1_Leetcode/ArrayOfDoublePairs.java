/*
Problem Statement:
Given an integer array of even length arr, return true if it is possible to reorder arr such that arr[2 * i + 1] = 2 * arr[2 * i] for every 0 <= i < len(arr) / 2, or false otherwise.

Example 1:
Input: arr = [3,1,3,6]
Output: false

Example 2:
Input: arr = [2,1,2,6]
Output: false

Example 3:

Input: arr = [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].


*/
package Algorithm_1_Leetcode;
import java.util.*;

public class ArrayOfDoublePairs {

    // This seems slower
    public static boolean adp(int[] arr)
    {
        // We take the Map to get the frequencies of all the elemens in the array
        Map<Integer, Integer> count = new TreeMap<>();
        for(int el: arr)
        {
            // We get the element and the counts for it and put them in the the count map 
            count.put(el, count.getOrDefault(el,0) + 1);
        }
        // We make a new array to store all the sorted elements in
        Integer[] arr1 = new Integer[arr.length]; 
        for(int i=0; i<arr.length; i++)
        {
            arr1[i] = arr[i]; 
        }
        // We sort using the comparator operator
        Arrays.sort(arr1, Comparator.comparingInt(Math::abs));
        // Now we iterate this sorted array
        for(int num: arr1)
        {   
            // We check to see if the element from arr1 has a frequency of 
            // 0 in the treemap
            if(count.get(num) == 0)
            {
                continue;
            }
            // We check to see if the double of the number num in arr1
            // even exists in the treemap
            if(count.getOrDefault(2*num, 0) <= 0)
            {
                // if it doesn't we directly return false and end the program
                return false;
            }
            // Otherwise we keep moving forward
            // We reduce the frequency for the found double number and consume it
            count.put(2*num, count.get(2*num) - 1);
            // We do the same for the current number we are at
            count.put(num, count.get(num) - 1);
        }
        return true;
    }
    // Faster and more efficient solution


    public static void main(String[] args) 
    {
        int[] arr1 = {4,-2,2,-4};
        int[] arr = {3,1,3,6};
        System.out.println(adp(arr));
        System.out.println(adp(arr1));
    }
        

}
