class Solution {
    private class countClass{
        int val;
        int idx;
        public countClass(int val, int idx)
        {
            this.val=val;
            this.idx = idx;
        }
    }
        
    public List<Integer> countSmaller(int[] nums) {
        
        if(nums==null || nums.length == 0) return new LinkedList<Integer>();
        int n = nums.length;
        countClass[] arr = new countClass[n];
        List<Integer> ans = new LinkedList<>();
        int[] result = new int[n];
        for(int i=0; i<n; i++)
        {
            arr[i] = new countClass(nums[i], i);
        }
        
        mergeSortAndCount(arr, 0, n-1, result);
        
        for(int i: result)
        {
            ans.add(i);
        }
        
        return ans;
    }
    
    // Here arr stores the arrays along with the count of elements that are smaller than it on the right
    private void mergeSortAndCount(countClass[] arr, int start, int end, int[] result)
    {
        // We define both the left and the right subarrays along with the result
        if(start>=end) return;
        
        int mid = (start+end)/2;
        // We do the standard partition with the merge sort
        mergeSortAndCount(arr, start, mid, result);
        mergeSortAndCount(arr, mid+1, end, result);
        // After that we start comparing our values
        List<Integer> merged = new ArrayList<>();
        
        // For getting the count of all the values on the right side that are smaller than the ones on the left side 
        int countSmallerRightSide = 0;
        
        // For travesing the left and thr right sides of the subarrays
        int leftPos = start;
        int rightPos = mid+1;
        
        List<countClass> finalised = new LinkedList<>();
        
        
        while(leftPos<mid+1 && rightPos<=end)
        {
            // Now these code blocks define what we really need to achieve with this problem
            if(arr[leftPos].val>arr[rightPos].val)
            {
                // Anytime we encounter an element from the right side to be smaller than that from the left side we incremenet the 
                // countSmallerRightSide and add it into the merged array
                // we also incrememnt rightPos
                countSmallerRightSide++;
                finalised.add(arr[rightPos]);
                rightPos++;
            }
            else
            {
                // Now the moment we find an element from the right side to be greater, we take the element from the left side and add the countSmallerRightSide value to it, thus getting
                // all the elements smaller than it on the right side
                result[arr[leftPos].idx]+=countSmallerRightSide;
                // We also add it into the merged array
                finalised.add(arr[leftPos]);
                // And we increment our leftPos
                leftPos++;
            }
        }
        
        // Now in case our leftPos or rightPos is yet to end we add two more loops
        while(leftPos<mid+1)
        {
            result[arr[leftPos].idx]+=countSmallerRightSide;
            finalised.add(arr[leftPos]);
            leftPos++;
        }
        while(rightPos<=end)
        {
            finalised.add(arr[rightPos]);
            rightPos++;
        }
        
        int pos = start;
        
        for(countClass i: finalised)
        {
            arr[pos] = i;
            pos++;
        }
    }
    
    
    
}