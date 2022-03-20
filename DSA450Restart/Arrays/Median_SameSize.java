package DSA450Restart.Arrays;

public class Median_SameSize {
    
    // First let's do the O(N) approach for this

    // arr1[] = {1,2,3,3};    => {1,2,3,4,6,6,8,10} => (4,6) => 5 
    // arr2[] = {4,6,8,10};

    public static int median_samesize(int[] arr1, int[] arr2)
    {
        // Here we will be using th
        int m1 = 0; // Will be set to m2 
        int m2 = 0; // And m2 will be set to the current element
        int start1 = 0;
        int start2 = 0;

        for(int i=0; i<=arr1.length; i++)
        {
            if(start1 == arr1.length)
            {
                m1 = m2;
                m2 = arr2[0];
                break;
            }
            if(start2 == arr2.length)
            {
                m1 = m2;
                m2 = arr1[0];
                break;
            }

            if(arr1[start1]<=arr2[start2])
            {
                m1 = m2;
                m2 = arr1[start1];
                start1++;
            }

            else
            {
                m1 = m2;
                m2 = arr2[start2];
                start2++;
            }

        }
        return (m1+m2)/2;
    }

    // arr1 = {1,2,3,6,9}; => 3 is the median  
    // arr2 = {4,6,8,10,11}; => 8 is the median 

    private static int median(int[] arr, int s, int e)
    {
        int n = e-s+1;
        if(n%2==0)
        {
            return(arr[s + (n/2)] + arr[s + (n/2-1)])/2;
        }
        else
        {
            return arr[s + n/2];
        }
    }

    public static int median_sameSize_LogN(int[] arr1, int[] arr2, int sa,int ea, int sb, int eb)
    {
        // We can use recursion for this
        // Base case? 
        if(ea-sa == 1)
        {
            return (Math.max(arr1[sa], arr2[sb]) + Math.min(arr1[ea],arr2[eb]))/2;
        }

        int m1 = median(arr1, sa, ea);
        int m2 = median(arr2, sb, eb);

        if(m1==m2)
        {
            return m1;
        }
        if(m1>m2)
        {
            // We 
            return median_sameSize_LogN(arr1, arr2, sa,(sa+ea+1)/2, (sb+eb+1)/2, eb);
        }
        else
        {
        return median_sameSize_LogN(arr1, arr2, (sa+ea+1)/2, ea, sb, (sb+eb+1)/2);
        }

    }
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,6};
        int[] arr2 = {4,6,8,10};

        // System.out.print(median_samesize(arr1, arr2));
        int n = arr1.length;
        System.out.print(median_sameSize_LogN(arr1, arr2, 0,n-1 , 0, n-1));
        
    
    }
}
