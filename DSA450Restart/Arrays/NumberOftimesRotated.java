package DSA450Restart.Arrays;

public class NumberOftimesRotated {
    // Here we need to find the value of k for the number of rotations

    /*
    5 1 2 3 4
    Here we see 5 is at the last place indicating the array was rotated once
    so our output becomes 1

    We can do this in linear time by couting the number of time arr[i]>arr[i+1]
    How to do in logN time tho? 

    5 1 2 3 4
    Mechanical Keyboard
    
    */
    static int findKRotation(int arr[], int n) {
        // code here
        int low = 0;
        int high = arr.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            // We are not searching for anything we just know that we need the peak, so this time
            // instead of checking for a specific element we check on the two sides of mid
            
            if(arr[low] <= arr[high]) return low;
            if(arr[mid]<=arr[(mid+1)%arr.length] && arr[mid]<=arr[(mid+arr.length-1)%arr.length])
            {
                return mid; // We just return the mid as our peak
            }
            
            // case 2: 
            else if(arr[low]<=arr[mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }            
        }
        return 0;
    }    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};

        System.out.print(findKRotation(arr, arr.length));
    }
    

}
