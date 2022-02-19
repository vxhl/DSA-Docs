package Striver_SDESHEET.Day2;
import java.util.*;

// This is the n+1 integers duplicate problem

public class FindDuplicateNumber_287 {
    

    public static int dupes(int[] arr)
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
        }
        return slow;

    }

    public static void main(String[] args) {
        int[] arr = {3,1,3,4,2};
        System.out.println(dupes(arr));
    }
}
