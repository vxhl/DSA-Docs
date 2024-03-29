/*
Problem Statement: 
Implement QuickSort algorithm for arrays taking the first
element as pivot

Example: 
arr = {6,5,8,9,3,10,15,12,16};
o/p => Sorted Array: 3 5 6 8 9 10 12 15 16

*/


class Quicksort 
{
    static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;

    }
    static int partition(int A[], int low, int high)
    {
        // We first define our pivot as the first element in the array
        int pivot = A[low];
        int i = low;
        int j = high;

        // As long as low is smaller than high
        while(i<j)
        {
            // If the element is smaller than pivot than we continue traversing L->R
            while(A[i]<=pivot)
            {
                i++;
            }
            // If the element from the high side is greater than pivot we decrement R->L
            while(A[j]>pivot)
            {
                j--;
            }
            // We than swap the higher elements on the left side to the right side
            if(i<j)
            {
                swap(A,i,j);               
            }
        }
        // After the end of the loop we swap the pivot element with the element as j
        swap(A,low,j);
        return j;
    }

    // Recursive Function for QuickSort
    static void Quicksort(int[] arr, int low, int high)
    {
        if(low<high)
        {
            int j = partition(arr, low, high);
            Quicksort(arr, low,j);
            Quicksort(arr, j+1,high);
        }
        }
    
    // Function to print an array
    static void printArray(int[] arr, int size)
    {
        for(int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6,5,8,9,3,10,15,12,16};
        System.out.println(partition(arr, 0, arr.length-1));
        Quicksort(arr, 0, arr.length-1);
        System.out.println("Sorted Array: ");
        printArray(arr, arr.length);
    }
}



/**
 * 
 * N = 8
 * 
 * 8/2^3 = 1
 * 8 = 2^3
 * log 8 = 3
 * For an array of N size
 * we get logN passes 
 * O(N*log N)
 * 
 * 0 1 2 3 4 5 6 7
 * 9 3 7 5 6 4 8 2
 * So in merge sort
 * 9 3 7 5    6 4 8 2
 * 
 * 9 3   7 5                   6 4   8 2
 *  
 * 9   3     7   5             6   4    8    2
 *  
 * 3 9  5 7                    4 6         2 8
 *  [3 5 7 9]                       [2 4 6 8]
 * 
 * 2 3 4 5 6 7 8 9
 * 
 * this merging step takes linear time to merge
 * [3 5 7 9]
 * 
 * 
    mergeSort(int[] arr, int i, int j){
        if(i<j){
            int mid = i + (j-i)/2;
            9 3 7 5 6 4 8 2
            // In the first recursion call we are sorting the first half
            mergesort(arr, i, mid)
            3 5 7 9 6 4 8 2
            // In the second call we merge the second half
            mergesort(arr, mid+1, j);
            // And in the third call, we take the two halves and merge them together. 
            3 5 7 9 2 4 6 8
            merge(arr,i, mid, j);
            2 3 4 5 6 7 8 9 
        }
    }


    now for the time complexity we have

    8 
    and at each level we are splitting the array into two parts
    levels*N 
    so to determine the levels
    8 
    4 4
    2 2 2 2
    1 1 1 1 1 1 1 1

    O(log N)
    8 = 2^3
    log 8 = 3
    log N 

    so the time complexity would be O(N*LogN)

    O(N)+O(logN)

    O(N) space auxiliary space.
 */


