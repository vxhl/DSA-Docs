package DSA450Restart.Arrays;

public class MinOpsPalindrome {
    // My approach is kinda twisted and has not much going for it concept wise but this somehow
    // feels like a sliding windows problem. Before that, let's just implement what I came up with and then go from there


    public static int minopsP(int[] arr)
    {
        int count = 0;

        int i = 0;
        int j = arr.length-1;

        // This is pretty simple.
        // We need the operations, so whenever we have both pointers as equal we don't do any merging operations
        // but if one pointer element has value greater than the other, than we traverse the pointer with the smaller element
        // and keep on adding till the element becomes equal to the element at the greater side
        // We do this for both the left and right pointers and increment the count everytime we do one of these operations.
        while(i<=j)
        {
            if(arr[i]>arr[j])
            {
                j--;
                arr[j] += arr[j+1];
                count++;
            }

            else if(arr[i]<arr[j])
            {
                i++;
                arr[i] += arr[i-1];
                count++;
            }
            else
            {
                i++;
                j--;
            }
        }
        return count;


    }
}
