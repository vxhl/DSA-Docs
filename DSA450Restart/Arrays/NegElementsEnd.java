package DSA450Restart.Arrays;
import java.util.*;
public class NegElementsEnd {
    
   // Taking O(N) space

   public static int[] nege_extraspace(int[] arr, int n)
   {
       List<Integer> pos = new ArrayList<>();
       List<Integer> neg = new ArrayList<>();

       for(int i=0; i<arr.length; i++)
       {
           if(arr[i]<0)
           {
               neg.add(arr[i]);
           }
           else
           {
               pos.add(arr[i]);
           }
       }

       List<Integer> res = new ArrayList<>();

       for(int i=0; i<pos.size(); i++)
       {
           res.add(pos.get(i));
       }
       for(int i=0; i<neg.size(); i++)
       {
           res.add(neg.get(i));
       }

       int[] res1 = new int[res.size()];
       for(int i=0; i<res.size(); i++)
       {
           res1[i] = res.get(i);
       }
       return res1;
   }

    // new copied approach no extra space and in relative order
    public static int[] nege(int[] arr, int n)
    {
    // Count negative numbers
    int count_neg = 0;
    for (int i = 0; i < n; i++)
    {
        if (arr[i] > 0)
        count_neg++;
    }
    // Run a loop until all
    // negative numbers are
    // moved to the beginning
    int i = 0, j = i + 1;
    while (i != count_neg)
    {
    
        // If number is negative,
        // update position of next
        // positive number.
        if (arr[i] < 0)
        {
            i++;
            j = i + 1;
        }
    
        // If number is positive, move
        // it to index j and increment j.
        else if (arr[i] > 0 && j < n)
        {
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            j++;
        }
    }

    while(i<count_neg)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        j++;
    }
    return arr;
}

    public static void main(String[] args) {
        int arr[] = {1, -1, 3, 2, -7, -5, 11,6};
        for(int i: nege(arr, arr.length))
        {
            System.out.print( i + " ");
        }
        
    }
}
