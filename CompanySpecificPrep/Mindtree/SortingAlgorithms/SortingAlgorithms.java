class SortingAlgorithms{
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
void bubbleSort(int[] arr){
    int n = arr.length;
    while(true){
        boolean flag = false;
        for(int i=0; i<n-1; i++){
            if(arr[i]>arr[i+1]){
                flag = true;
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        if(!flag){
            break;
        }
    }
    for(int i: arr){
        System.out.print(i+ " ");
    }
}
// In bubble sort our search space gets reduced by 1 every time we do a pass since
// each pass is trying to send our largest element to the end of the array
void recursiveBubbleSort(int[]arr, int n){
    if(n==1){
        return;
    }
    boolean flag = true;

    for(int i=0; i<n-1; i++){
        if(arr[i]>arr[i+1]){
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1]=temp;
            flag = false;
        }
    }
    if(flag){
        return;
    }
    recursiveBubbleSort(arr, n-1);
}


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
/*
Merge sort is a divide and conquer strategy where we divide the array
into smaller and smaller parts until sorting it becomes much easier. And in the
end we merge them all together into a single array to find our final sorted array. 

12 9 10 3 4 2 8
0  1  2 3 4 5 6
so we get the mid point and divide the array into two parts
12 9 10 3 and 4 2 8
*/
void merge(int arr[], int l, int m, int r)
{
    int[] part1 = new int[m-l+1];
    int[] part2 = new int[r-m];
    
    for (int i = 0; i < m-l+1; i++)
        part1[i] = arr[l + i];
    for (int j = 0; j < r-m; j++)
        part2[j] = arr[m + 1 + j];
    
    int i = 0;
    int j = 0;
    int k = l;

    while(i<m-l+1 && j<r-m){
        if(part1[i]<part2[j]){
            arr[k]=part1[i];
            i++;
        }else{
            arr[k]=part2[j];
            j++;
        }
        k++;
    }
    while(i<m-l+1){
        arr[k]=part1[i];
        i++;
        k++;
    }
    while(j<r-m){
        arr[k]=part2[j];
        j++;
        k++;
    }
    
}
void mergeSort(int arr[], int l, int r){
    if(l<r){
        int mid = l+(r-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }
    
}

// Quick Sort
public static void main(String[] args) {
        int[] arr = {7,9,1,3,10};
        SortingAlgorithms s1 = new SortingAlgorithms();
        s1.mergesort(arr, 0, arr.length-1);
        for(int i: arr){
            System.out.print(i+ " ");
        }
    }
}