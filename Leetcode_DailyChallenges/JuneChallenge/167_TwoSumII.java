class Solution {





    


    // Failed solution.
    public int[] twoSum(int[] arr, int target) {
        
        if(arr.length==2)
        {
            if(arr[0]+arr[1] == target)
            {
                return new int[]{1,2};
            }
        }
        int nearestTarget =  greatestIndexNotExceeding(arr, 0, arr.length-1, target);
        int newTarget = target - arr[nearestTarget];
        System.out.print(newTarget);
        int[] res = new int[2];
        res[1] = nearestTarget+1;
        
        int start = 0;
        int end = arr.length-1;
        
        
        
        while(start<end)
        {
            int mid = start+(end-start)/2;
            
            if(arr[mid] == newTarget && mid!=nearestTarget)
            {
                System.out.print("Yes");
                res[0] = mid+1;
                break;
            }
            else if(arr[mid]<newTarget)
            {
                start = mid+1;
            }
            else
            {
                end = mid;
            }
            
        }
        
        if(res[0]>res[1])
        {
            int temp = res[0];
            res[0] = res[1];
            res[1] = temp;
        }
        
        return res;
        
        
    }
    
    public static int greatestIndexNotExceeding(int[] arr, int lb, int ub, int target)
    {
        final int mid = (lb+ub)/2;
        
        // Our edge case
        if(mid == lb && arr[mid]>target)
        {
            return -1;
        }
        
        // Our base case 
        if(arr[mid]<=target && (mid == ub || arr[mid+1]>target))
        {
            return mid;
        }
        
        
        else if(arr[mid]<=target)
        {
            return greatestIndexNotExceeding(arr, mid+1, ub, target);
        }
        else
        {
            return greatestIndexNotExceeding(arr, lb, mid, target);
        }
        
    }
}