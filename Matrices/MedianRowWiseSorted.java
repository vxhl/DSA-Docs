/*
Problem Statement:
Given a row wise sorted matrix of size 
RxC where R and C are always odd, find the median of the matrix.

Input:
R = 3, C = 3
M = [[1, 3, 5], 
     [2, 6, 9], 
     [3, 6, 9]]
Output: 5
Explanation:
Sorting matrix elements gives us 
{1,2,3,3,5,6,6,9,9}. Hence, 5 is median. 
 
*/
package Matrices;
import java.util.*;

public class MedianRowWiseSorted
{
    static int MedianMatrix(int[][] arr)
    {
        
        int n = arr.length;
        int m = arr[0].length;
        int l = 0;
        int h = (n*m)-1;
        int mid = l + ((h-l)/2);
        return arr[mid/m][mid%m];
    }
    public static void main(String[] args) {
    int[][]arr = {{1, 3, 5}, 
                {2, 6, 9}, 
                {3, 6, 9}};
    System.out.print("The Median of the given matrix is: " + MedianMatrix(arr));    
    }
}

// Notes
/*
This is very similar to the usual but this time around I need to find the actual
median of the matrix. This is simple enough, just go halfway through Binary Search
probably
*/