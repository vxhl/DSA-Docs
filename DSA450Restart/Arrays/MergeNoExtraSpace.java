package DSA450Restart.Arrays;
import java.util.*;

public class MergeNoExtraSpace {

    private static void swapping(int e1, int e2)
    {
        int temp = e1;
        e1 = e2;
        e2 = temp;
    }

    public static void mnes(int[]arr1, int[]arr2)
    {
        int p1 = 0;
        int p2 = 0;

        // We are taking the first arr as our first sorted array
        // that continues into the 2nd array
        int temp = 0;
        while(p1<arr1.length)
        {

        
                if(arr1[p1] > arr2[p2])
                {
                    // We swap if that happens and we repeat the process
                    temp = arr1[p1];
                    arr1[p1] = arr2[p2];
                    arr2[p2] = temp;
                    Arrays.sort(arr2);
                }
                else
                    p1++;
    
            }

            for(int i: arr1)
            {
                System.out.print(i + " ");
            }
            for(int i: arr2)
            {
                System.out.print(i+ " ");
            }
        }


        // Using the GAP Algorithm
        
        public static void mnes_gap(int[] arr1, int[] arr2)
        {
            int gap = (int) Math.ceil((arr1.length+arr2.length)/2);
            int p1 = 0;

            while(gap!=1)
            {
                if(p1<arr1.length && gap<arr1.length)
                {
                    if(arr1[p1]>arr1[gap])
                    {
                        int temp = arr1[p1];
                        arr1[p1] = arr1[gap];
                        arr2[gap] = temp;

                    }
                    else
                    {
                        p1++;
                        gap++;
                    }
                }
                else if(gap>arr1.length)
                {
                    if(arr1[p1]>arr2[gap-])
                }
            }
        }



    public static void main(String[] args) {
        int[] arr1 = {0,1,3,5,7};
        int[]arr2 = {2,6,8,9};
        mnes(arr1, arr2);

    }
}
