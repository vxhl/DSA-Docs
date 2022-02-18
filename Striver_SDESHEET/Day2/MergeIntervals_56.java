/*
Problem Statement:
Given an array of intervals where `intervals[i] - [ starti, endi]
merge all the overlapping intervals and return an array of the non-overlapping intervals
that cover all the intervals in the input. 

Example1- 
Input: intervals = {{1,3},{2,6},{8,10},{15,18}}
Output: {{1,6},{8,10},{15,18}}
*/

package Striver_SDESHEET.Day2;
import java.util.*;


public class MergeIntervals_56 {
    // Well I have done this before but I do not remember jack shit rn
    // we have two elements from the two subarray from the 2d array
    // arr[i][j+1] and arr[i+1][j]
    // if arr[i][j+1]>=arr[i+1][j] then we merge the two intervals arr[i][j] and arr[i+1][j+1]
    // Now the question is how do we merge??

    public static int[][] mergeIntervals(int[][] arr)
    {
        // We have our resultant array where we push in our intervals once we find any
        List<int[]> res = new ArrayList<>();
        // This sorts our array on the basis of the first element in each interval since we are 
        // given that the given intervals are unsorted.

        Arrays.sort(arr ,(arr1,arr2) -> Integer.compare(arr1[0], arr2[0]));
        
        // We first define our start and end and then push it into our resultant array
        int start = arr[0][0];
        int end = arr[0][1];
        // Once that is done we traverse our interval array
        for(int i[]: arr)
        {
            // If the first element of the next array is greater than or equal to the last element of the previous interval
            if(i[0] <= end)
            {
                // We update the end by comparing the last element of the current interval and the 
                // last element of the previous interval
                // Once we find one we set it as the current end and then we add it into our result? 
                end = Math.max(i[1], end);
                // Actually we do not directly add it into our result since if in case we have another interval
                // for the next element that satisfies the condition for this current interval we also have to merge it
                // so we keep on looping till we find that the condition for this if statement is not satisfied                
            }
            // and once it is not satisfied we add the interval into our resultant array and change our start and end into that interval
            else 
            {
                res.add(new int[]{start, end});
                start = i[0];
                end = i[1];
            
            }
        }

        // We finally add the last interval once we complete the traversal
        res.add(new int[]{start, end});

        // Why does this work?
        return res.toArray(new int[0][]);



    }

    public static int[] merge(int[] arr1, int[] arr2)
    {
        // i SERIOUSLY HAVE NO IDEA HOW TO MERGE
        // Well we do merge rn with extra space
        // Let us take another array
        
        int[] newarr = {arr1[0], arr2[1]};
        return newarr;
    }


    public static void main(String[] args) {

        int[][] arr = {{1,3},{8,10},{2,6},{15,18}};
        mergeIntervals(arr);
        for(int i=0; i<mergeIntervals(arr).length; i++)
        {
            for(int j=0; j<mergeIntervals(arr)[0].length; j++)
            {
                System.out.print(mergeIntervals(arr)[i][j] + " ");
            }
            System.out.println();
        }

    }

    // Let us set aside a helper function for merge for now
}
