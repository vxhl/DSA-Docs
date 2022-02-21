package DSA450Restart.Arrays;
import java.util.*;


public class ReverseTheArray {
    public static int[] revArray(int[] arr)
    {
        int start = 0;
        int end = arr.length-1;

        while(start<=end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;

    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        for(int i: revArray(arr))
        {
            System.out.print(i+" ");
        }
    }
}
