package DSA450Restart.SearchingSorting;
import java.util.*;
class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i: arr)
        {
            mp.put(i, mp.getOrDefault(i,0)+1);
        }
        
        int[] res = new int[2];
        // We loop from 1 to N
        for(int i=1; i<n+1; i++)
        {
            if(!mp.containsKey(i))
            {
                res[1] = i;
            }
            else
            {
                if(mp.get(i)>1)
                {
                    res[0] = i;
                }
            }
        }
        
        return res;
    } 

    // Negation Approach 
    public static int[] MissingRepeating(int[] arr, int n)
    {
        // We are to use the negation appraoch so we are ofc
        // going to be modifying the array
        // Ok we have the indices 1->n right
        int res[] = new int[2];
        for(int i=0; i<n; i++)
        {
            int x = Math.abs(arr[i])-1;
            if(arr[x]<0)
            {
                res[0] = x+1;
            }
            else
            {
               arr[x]*=-1; 
            }

        }

        for(int i=0; i<n; i++)
        {
            if(arr[i]>0)
            {
            res[1] = i+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println);
        int[] arr = {2,2};
        int n = 3;

        for(int i: MissingRepeating(arr, n))
        {
            System.out.print(i + " ");
        }
    }
} 