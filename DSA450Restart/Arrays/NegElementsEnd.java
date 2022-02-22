package DSA450Restart.Arrays;

public class NegElementsEnd {
    
    public static void swapping(int a, int b)
    {
        int temp = a;
        a = b;
        b = temp;
    }
    public static int[] negelementsend1(int[] arr)
    {
        int next = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]<0)
            {
                System.out.println("exec");
                next = i+1;
                for(int j=next; j<arr.length; j++)
                {
                    System.out.println("exec1");
                    if(arr[j]>0)
                    {
                        System.out.println("exec2");
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                } 
            }
        }
        return arr;
    }

    // Easier and better approach

    public static int[] negelementsend2(int[] arr)
    {
        // We first count our negative elements
        int count = 0;
        for(int i: arr)
        {
            if(i<0) count++;
        }
        int i = 0;
        int j = i+1;
        while(i!=count)
        {
            if(arr[i]<0 && j<arr.length)
            {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                j++;
            }
            else if(arr[i]>0)
            {
                i++;
                j=i+1;
            }
        }
        return arr;
    }

    // new copied approach
    public static int[] nege(int[] arr, int n)
    {
        // Count negative numbers
int count_negative = 0;
for (int i = 0; i < n; i++)
    if (arr[i] < 0)
        count_negative++;
 
// Run a loop until all
// negative numbers are
// moved to the beginning
int i = 0, j = i + 1;
while (i != count_negative)
{
 
    // If number is negative,
    // update position of next
    // positive number.
    if (arr[i] < 0)
    {
        i++;
        j = i + 1;
    }
 
    // If number is positive, move
    // it to index j and increment j.
    else if (arr[i] > 0 && j < n)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
        j++;
    }
}
return arr;
    }

    public static void main(String[] args) {
        int arr[] = {1, -1, 3, 2, -7, -5, 11,6};
        for(int i: nege(arr, arr.length))
        {
            System.out.print(i+" ");
        }
    }
}
