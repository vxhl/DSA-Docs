package Median_DifferentSizes;

public class Median_DifferentSizes {
    
    /*
    arr1[] = {1,3,4,7,10,12} => {1,2,3,3,4,6,7,10,12,15} => The Median - 5 
    arr2[] = {2,3,6,15}
    
    In this problem we cannot say whether our final array will be even or odd so
    what do we do instead? 
    
    From our previous approach of two pointers, is there a way possible to solve this? 

    {1,3,4,7,10,12}
    {2,3,6,15,18}
    i, j => We traverse these in the same way, but wait up
    can't this be done with the merge without extra space thing we did earlier? 
    We try doing the technique for merge sort we do in the same size one
    ofc that works here as well

    If our array is even we get the (n-1)th and (n)th elements
    while we do our merge sort merging operation and if our array is odd we
    get just the (n-1)th element 
  */
    public static int median_differentSizes(int[] arr1, int[] arr2)
    {
        int start1 = 0;
        int start2 = 0;

        int m1= 0;
        int m2 = 0;

        if((arr1.length + arr2.length) %2 == 0)
        {
            for(int i=0; i<=(arr1.length + arr2.length)/2; i++)
            {
                if(arr1[start1] > arr2[start2])
                {
                    m1 = m2;
                    m2 = arr2[start2];
                    start2++;
                }
                else if(arr1[start1] < arr2[start2])
                {
                    m1= m2;
                    m2 = arr1[start1];
                    start1++;
                }

                if(start1 == arr1.length)
                {
                    m1= m2;
                    m2 = arr2[start2];
                    break;
                }

                else if(start2 == arr2.length)
                {
                    m1= m2;
                    m2 = arr1[start1];
                    break;
                }

            }
        }

        else
        {
            // Now what to do about the odd one

            // SO we get the length as arr1.length + arr2.length/2 to be the place where our median will lie
            // so do we just loop till that place? 

        }


    }

}
