package DSA450Restart.Arrays;

public class TrappingRainWater {
    // OK I thought of something though let's see if it works.
    private static int helper_max(int[] arr, int start, int end)
    {
        int max = 0;

        for(int i=start; i<end; i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Approach - O(N^2)
    public static int trap_water(int[] arr)
    {
        int water = 0;
        // We are traversing from the second element to the last 2nd element since boundaries cannot hold any water anyway
        for(int i =0; i<arr.length; i++)
        {
            int L = helper_max(arr, 0, i);
            int R = helper_max(arr, i+1, arr.length);
            int count = Math.min(L,R) - arr[i];
            if(count>0)
            {
                water+=count;
            }
            count = 0;
        }

        return water;
    }
    // Approach - O(N) time and N space approach using prefix and suffix max

    public static int trap_water_1(int[] arr)
    {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0] = arr[0];
        right[0] = arr[arr.length-1];
        // We first of all fill our prefix and suffix max from both sides 
        for(int i=1; i<left.length; i++)
        {
            left[i] = Math.max(left[i-1], arr[i]);

        }

        for(int i=arr.length-2; i>=0; i--)
        {
            right[i] = Math.max(right[i+1], arr[i]);
        }
        int ans = 0;
        for(int i=0; i<arr.length; i++)
        {
            int count = Math.min(left[i], right[i]) - arr[i];
            if(count>0)
            {
                ans+=count;
            }
        }

        return ans;

         
    }
    // O(N) time and constant space approach
    
    public static int trap_water2(int[] arr)
    {
        int l = 0;
        int r = arr.length-1;

        int leftmax = 0;
        int rightmax = 0;
        int res = 0;
        

        while(l<=r)
        {
            if(arr[l]>=arr[r])
            {
                if(arr[l]>=leftmax) leftmax = arr[l];
                else res += (leftmax-arr[l]);
                l++;
            }
            else
            {
                if(arr[r]>=rightmax) rightmax = arr[r];
                else res+= (rightmax-arr[r]);
                r--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {3,0,0,2,0,4};
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap_water2(arr1));
    }
}
