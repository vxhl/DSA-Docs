package DSA450Restart.Arrays;

public class SquareAndSort {

    // Well this is pretty simple but 
    // the tricky part is doing this in O(N)
    
    // First we will be doing the two pointer method
    // Cause i don't really get that partition method
    public static int[] sortandsquare(int[] arr)
    {
        int start = 0;
        int end = arr.length -1;

        // We have our new res array where we add our elements
        // I don't think this is possible to do in O(1) space but yeah I can
        // do it in O(N) time atleast
        
        // This adds O(n) to the space complexity
        int[] res = new int[arr.length];
       for(int i=arr.length-1; i>=0; i--)
        {
            if(Math.abs(arr[start])>Math.abs(arr[end]))
            { 
                // If the start is greater then we square it and push it into our new array
                res[i] = arr[start]*arr[start];
                start++;
            }
            else
            {
                res[i] = arr[end]*arr[end];
                end--;
            }
        }
        return res;


    }



    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        for(int i:sortandsquare(arr))
        {
            System.out.println(i+" ");
        }
    }
}
