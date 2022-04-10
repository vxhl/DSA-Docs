package DSA450Restart.Arrays;

public class SegregateNegPos {
    public static void rotate(int[] arr, int first, int last)
    {
        int temp = arr[last];

        for(int i=last; i>first; i--)
        {
            arr[i] = arr[i-1];
        }

        arr[first] = temp;
    }


     public void segregateElements(int arr[], int n)
    {
        int p1 = 0;
        int p2 = p1+1;
        while(p1<arr.length-2 && p2<arr.length-1)
        {
            if(arr[p1]>=0)
            {
                p1++;
                p2++;
            }
            else if(arr[p1]<0)
            {
                while(arr[p2]<0 && p2<arr.length-1)
                {   
                    p2++;
                }
                if(arr[p2]>0) { rotate(arr, p1, p2); p1++; } 
                else break;
                
                
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1,-2,3,4,-4,9}; // => 3,4,9,-1,-2,-4

        for(int i: segregate(arr))
        {
            System.out.print(i+ " ");
        }
    }
}
