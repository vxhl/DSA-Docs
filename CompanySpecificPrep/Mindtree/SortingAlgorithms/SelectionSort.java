class SelectionSort{
/*
 * In selection sort we repeatedly find the minimum element for the current
 * position and move forward accordingly.
 * This takes a time complexity in the worst case of O(N*N) and
 * even in the best case it is O(N*N) since we are searching both times anyway
 * 
 */
    void selectionSort(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++){
                if(arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            // We swap the two position
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        for(int i: arr){
            System.out.print(i+ " ");
        }
    }

// Bubble Sort

// Insertion Sort
void insertionSortRecursive(int[] arr, int i){
    int key = arr[i];
    int j = i-1;
    while(j>=0 && arr[j]>key){
        arr[j+1] = arr[j];
        j--;
    }
    arr[j+1] = key;
    if(i+1<=arr.length){
        insertionSortRecursive(arr, i+1);
    }
}
// Binary Insertion Sort
// In this sorting technique we can find the position that is just greater than the current element and 
int binarySearch(int[]arr, int left, int right, int key){
    while(left<=right){
        int mid = left + (right-left)/2;
        if(arr[mid]==key){
            return mid+1;
        }
        else if(arr[mid]<key){
            left = mid+1;
        }else{
            right = mid-1;
        }
    }
    return left;
}

void binaryInsertionSort(int[]arr){
    for(int i=1; i<arr.length; i++){
        int key = arr[i];
        int j = i-1;
        int loc = binarySearch(arr, 0, j, key);
        while(j>=loc){
            arr[j+1] = arr[j];
            j-=1;
        }
        arr[j+1] = key;
    }
    for(int i: arr){
        System.out.print(i+" ");
    }
}
// Merge Sort

// Quick Sort
    public static void main(String[] args) {
        int[] arr = {7,9,1,3,10};
        SelectionSort s1 = new SelectionSort();
        s1.binaryInsertionSort(arr);
    }
}