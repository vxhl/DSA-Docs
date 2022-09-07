class BinarySearch{

    // O(N) in the worst case of never finding the element in the array
    boolean linearSearch(int[] arr, int key){
        for(int i=0; i<arr.length; i++){
            if(arr[i]==key){
                return true;
            }
        }
        return false;
    }

    // O(logN) time in the worst case 
    // in the best case it would take O(1) time 

    boolean binarySearch(int[] arr, int key, int left, int right){
            // We are doing this in case of a out of bounds exception
            // 1 2 3 4 5 
            int mid = left+(right-left)/2;
            if(arr[mid]==key){
                return true;
            }
            if(left == right){
                return false;
            }
            if(arr[mid]<key){
                return binarysearch(arr, key, mid+1,right);
            }else{
                return binarysearch(arr, key, left,mid-1);
            }
            return false;

    }


    public static void main(String[] args){
        int[] arr = { 1,2,7,10,12,18,25,30};
        int key = 10;
    }

}