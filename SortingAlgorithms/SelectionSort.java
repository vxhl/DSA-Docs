package SortingAlgorithms;

public class SelectionSort {
    public static int[] Selection(int[] arr)
    {   // We run our loop till the last 2nd element since our imin index cannot be at the last position
        for(int i=0; i<arr.length; i++)
        {
            // We initialise our minimum index position first of all
            int imin = i;

            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[imin]>arr[j])
                {
                    imin = j;
                }
            }
            // we then swap the positions for the imin and ith indices

            int temp = arr[i];
            arr[i] = arr[imin];
            arr[imin] = temp;

        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,5,3};
        Selection(arr);

        for(int i: arr)
        {
            System.out.print(i + " ");
        }
    }
}
