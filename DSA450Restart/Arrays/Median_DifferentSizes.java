package DSA450Restart.Arrays;

public class Median_DifferentSizes {
    
    /*
    arr1[] = {1,3,4,7,10,12} => {1,2,3,3,4,6,7,10,12,15} => The Median - 5 
    arr2[] = {2,3,6,15}
    
    In this problem we cannot say whether our final array will be even or odd so
    what do we do instead? 
    
    From our previous approach of two pointers, is there a way possible to solve this? 

    {1,3,4,7,10,12}
    {2,3,6,15,18}
    i, j => We traverse these in the same way, but wait up
    can't this be done with the merge without extra space thing we did earlier? 
    We try doing the technique for merge sort we do in the same size one
    ofc that works here as well

    If our array is even we get the (n-1)th and (n)th elements
    while we do our merge sort merging operation and if our array is odd we
    get just the (n-1)th element 
  */
  private static double median(int[] arr, int s, int e)
  {
      
          if(arr.length%2==0) { return (arr[(s + e) / 2] + arr[(s + e + 1) / 2]) / 2; } 
          else return arr[arr.length/2];
   }

  public static double median_diffSize_LogN(int[] arr1, int[] arr2, int sa,int ea, int sb, int eb)
  {
    // For same size arrays
    if(eb-sb==1 && eb-sb==1)
    {
        if((arr1.length+arr2.length)%2 == 0)
        return (Math.min(arr1[ea], arr2[eb]) + Math.max(arr1[sa], arr2[sb]))/2;
    }
    // For different size arrays


      double m1 = median(arr1, sa, ea);
      double m2 = median(arr2, sb, eb);

      if(m1==m2)
      {
          return m1;
      }
      if(m1>m2)
      {
          return median_diffSize_LogN(arr1, arr2, sa,(sa+ea+1)/2, (sb+eb+1)/2, eb);
      }
      else
      {
      return median_diffSize_LogN(arr1, arr2, (sa+ea+1)/2, ea, sb, (sb+eb+1)/2);
      }

  }


  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // We do this according to sizes so we set the smaller array forward
    if(nums2.length < nums1.length) return findMedianSortedArrays(nums2, nums1);
    int n1 = nums1.length;
    int n2 = nums2.length;
    
    int low = 0;
    // We do binary search for the smaller array
    int high = n1;
    
    while(low<=high)
    {
        
        // We first find the cut in our first array
        // We start from the very end of the first array? 
        int cut1 = (low+high)/2;
        // Our second cut will be after our first cut obviously 
        int cut2 = (n1+n2+1)/2 - cut1;
        // We now set our left1, left2, right1 and right2
        // Our left1 will be the cut1-1th element in the first array so
        // Before that we need to set our left1 as -infinity if our cuts get out of bounds
        // same for the right ones which we set to MAX_VALUE if they get out of bounds
        
        int left1 = cut1== 0 ? Integer.MIN_VALUE  : nums1[cut1-1];
        int left2 = cut2==0 ? Integer.MIN_VALUE : nums2[cut2-1];
        int right1 = cut1 == n1 ? Integer.MAX_VALUE: nums1[cut1];
        int right2 = cut2 == n2 ? Integer.MAX_VALUE: nums2[cut2];
        
        
        // Now if our condition gets satisfied we simply get the median for the respective l1,l2,r1 and r2 values
        if(left1<=right2 && left2<=right1)
        {
            if((n1+n2)%2 == 0)
            {
                // For even we use a distinct formula
                return (Math.max(left1, left2) + Math.min(right1, right2))/2.0;
            }
            else
            {
                // But for odd, we get the maximum between the two elements from the left1 and left2 since we need the element at the nth place which will be element
                // at the exact middle. The other smaller one between left1 and left2 will be on the n-1th position
                return Math.max(left1,left2);
            }
            
        }

        // Now when our condition does not get satisfied we do the following
        else if(left1>right2)
        {
            // We reduce our high which was at n1 initially to cut1-1 so we basically cut the array in half 
            high = cut1-1;
        }
        // Otherwise we increase left1
        else
        {
            // Same goes for our low which we increase by 1 if our left2 was greater than right1, basically what we do is we move forward in our arr2 and get a 
            // value that is greater than element at left2
            low = cut1+1;
        }
        
    
    }
    
    return 0.0;
}

  public static void main(String[] args) {
    int[] arr1 = {1,2,3,6};
    int[] arr2 = {4,6,8,10};

    // System.out.print(median_samesize(arr1, arr2));
    int n = arr1.length;
    System.out.print(median_diffSize_LogN(arr1, arr2, 0,n-1 , 0, n-1));
  }

}
