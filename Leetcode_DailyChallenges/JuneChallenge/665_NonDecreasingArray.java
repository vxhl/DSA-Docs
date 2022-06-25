class Solution {
    public boolean checkPossibility(int[] arr) {
        // So we are to check if we can make the given array non decreasing by manipulating at most one element
        // 4 2 3 => true since we can change 4 to 1
        // 4 2 1 => false since we need to change 4 and as well as 1 to make it increasing
        
        // 4 2 3 
        // We can try and do a binary search
        
        // 3 2 3 dips are also possible!
        // 3 4 5 6 2 3 7
        
        if(arr.length == 1) return true;
        if(arr.length == 0) return false;
        int count = 0;
        
        for(int i=1; i<arr.length; i++)
        {
            if(arr[i-1]>arr[i])
            {
                // So the count is for the modifications
                // There are only two ways to modify the array let us see them
                count++;
                
                // 4 2 3 -> In this example when we are idx -> 1 all we can do is update the previous element to 
                // either itself or something less than it and it becomes
                // 2 2 3 -> When we are at 3 the condition does not satisfy and we return our mods as 1
                if(i-2<0 || arr[i-2]<=arr[i]) arr[i-1]=arr[i];
                // In the case for 4 2 1 we have 2 2 1 as usual first and then we again need to modify the 2nd index 
                // with 2 since the i-2th index is greater than the current index, since we do this we get 2 operations instead of 1 and so we return 2
                else arr[i] = arr[i-1];
                
            }
        }
        
        return count>1?false: true;
        
    }
    
}