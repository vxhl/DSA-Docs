class sortIt{
    void quickSort(int [] arr,int low, int high){
        if(low<high){
            int j = partition(arr, low, high);
            quickSort(arr, low,j);
            quickSort(arr, j+1, high);
        } 
    }

    int partition(int[] A, int low, int high){
        // When do we get the parititon position? 
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

    void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,2,3,7,11,3,2,1,0};
        sortIt q = new sortIt();
        q.quickSort(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}