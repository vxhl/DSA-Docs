/*
Problem Statement:
Implement the Merge Sorting technique ( Recursive )
*/
package Algorithms.Sorting;

public class MergeSort
{

    static void Merge(int[] A, int low,int mid,int high)
    {
        int i = low;
        int k = low;
        int j = mid+1;
        int[] new_A = new int[A.length];

        // Set the partition point as mid and set a pointer i
        // to track mid
        while(i<=mid && j<=high)
        {
            // If our current element in one half is smaller than 
            // the element in the other half
            if(A[i]<A[j])
            {   
                new_A[k] = A[i]; // We assign the element to our new sorted array
                i++;
             
            }
            else // Otherwise if the other side is smaller we add that into our sorted array
            {
                new_A[k] = A[j];
                j++;
            }
            k++;
        }

        if(i>mid) // If our i pointer reaches the end of the partition 
        {
            while(j<=high)
            {
                new_A[k] = A[j];
            }
        }
        else
        {
            while(i<=mid)
            {
                new_A[k] = A[i];
                i++;
                k++;
            }
        }
        for(k=low; k<=low; k++)
        {
            A[k] = new_A[k];
        }

    }
    static void MergeSort(int[] A, int low, int high )
    {
        if(low<high)
        {
            int mid = low + (high-low)/2;
            MergeSort(A, low, mid);
            MergeSort(A, mid+1, high);
            Merge(A, low, mid, high);
        }
    }

    static void print_sorted(int[] A)
    {
        for(int i=0; i<A.length; ++i)
        {
            System.out.print(A[i] + " ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        int arr[] = {34,13,67,1,788,10,7,6,4};
        MergeSort ob = new MergeSort();
        ob.MergeSort(arr, arr[0], arr[arr.length-1]);
        System.out.println("Sorted Array:  ");
        print_sorted(arr);
    }
}