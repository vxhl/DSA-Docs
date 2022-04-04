package DSA450Restart.Arrays;
public class SearchinNearlySortedArray

{
    public static int searchNearlySorted(int[] arr, int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(arr[mid] == target || arr[(mid+n-1)%n] == target || arr[(mid+1)%n] == target )
            {
                if(arr[mid] == target)
                {
                    return mid;
                }
                if(arr[(mid+n-1)%n] == target )
                {
                    return (mid+n-1)%n;
                }
                if(arr[(mid+1)%n] == target)
                {
                    return (mid+1)%n;
                }
            }
            else if(arr[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }


        }

        return -1;


    }

    public static void main(String[] args) {
        int[] arr = {10,3,40,20,50,80,70};
        int target = 3;

        System.out.print(searchNearlySorted(arr, target));
    }
}