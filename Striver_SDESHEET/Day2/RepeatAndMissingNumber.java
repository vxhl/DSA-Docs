/*
Problem Statemnt:
We are given an array of N+1 integers with elements from 1 -> N
We are to return A from here which is repeated twice and B which is missing and
A,B belong to 1-N
*/

package Striver_SDESHEET.Day2;

import java.util.HashSet;

public class RepeatAndMissingNumber {
    // Is it just me or does this one again need the 
    // Floyd's cycle finding algorithm cause it sure looks like it -_- 
    public static int[] repeatMissing(int[]arr)
    {
        int slow = arr[0];
        int fast = arr[0];

        while(true)
        {
            slow = arr[slow];
            fast = arr[arr[fast]];
            if(slow == fast) break;
        }

        fast = arr[0];

        while(slow!=fast)
        {
            slow = arr[slow];
            fast = arr[fast];
            if(slow==fast)
            break;
        }
        int[] res = new int[2];
        res[0] = slow;
        res[1] = 0;
        return res;

    }
    

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3};
        repeatMissing(arr);
        for(int i: repeatMissing(arr))
        {
            System.out.println(i + " ");
        }
    }
}
