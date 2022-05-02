package SortingAlgorithms;

public class BubbleSort {
    public static int[] BubbleSort(int[] arr, int n)
    {
        for(int i = 0; i<n; i++)
        {
            for(int j=i+1; j<n; j++ )
            {
                if(arr[i]>arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,4,1,5,3};
        BubbleSort(arr, arr.length);
        for(int i: arr)
        {
            System.out.print(i + " ");
        }
    }
}
