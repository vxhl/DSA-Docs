package DSA450Restart.Arrays;
import java.util.*;

public class UnionArrays {

    // O(N*M) solution
    public static int union(int[] arr1, int[] arr2)
    {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int count = 0;
        for(int i = arr1.length-1; i>=0; i--)
        {
            for(int j = 0; j<arr2.length; j++)
            {
                if(arr1[i] == arr2[j])
                {
                    count++;
                }
            }
        }
        return arr1.length+arr2.length - count;
    }

    // O(N+M) solution
    public static int doUnion(int arr1[], int n, int arr2[], int m) 
    {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        
        for(int i=0; i<arr1.length; i++)
        {
            mp.put(arr1[i],i);
        }
        for(int j =0; j<arr2.length; j++)
        {
            mp.put(arr2[j],j);
        }
        return mp.size();
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] arr1 = {3,4,5,6,7};

        System.out.println(union(arr, arr1));

    }    
}
