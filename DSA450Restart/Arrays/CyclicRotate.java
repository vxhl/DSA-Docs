package DSA450Restart.Arrays;

public class CyclicRotate {
    public static int[] rotate(int[] arr)
    {

        int x = arr[arr.length-1];
        
        for(int i=arr.length-1; i>0; i--)
        {
            arr[i] = arr[i-1];
        }
        
        arr[0] = x;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for(int i: rotate(arr))
        {
            System.out.print(i+" ");
        }
    }
}
