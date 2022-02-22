package DSA450Restart.Arrays;

public class sort012 {

    public static void swap(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    public static int[] sort012_(int[] arr)
    {
        int mid = 0;
        int low = 0;
        int high = arr.length-1;
        int temp = 0;

        while(mid<=high)
        {
        switch(arr[mid])
        {
        
        case 0:
        {
            temp = arr[mid];
            arr[mid] = arr[low];
            arr[low]  = temp;
            
            low++;
            mid++;
            break;
        }
        case 1:
        {
            mid++;
            break;
        }
        case 2:
        {
        
            temp = arr[mid];
            arr[mid] = arr[high];
            arr[high]  = temp;
            high--;
            break;
        
        }
    }
        
    }
        return arr;
        
    }

    public static void main(String[] args) {
        int[] arr = {0,2,1,2,0};
        sort012_(arr);
        for(int i: sort012_(arr))
        {
            System.out.print(i+" ");
        }
    }
}
