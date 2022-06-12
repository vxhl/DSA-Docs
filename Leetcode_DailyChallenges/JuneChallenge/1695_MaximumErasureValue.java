class Solution {
    public int maximumUniqueSubarray(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
	    int n = arr.length;
        int left =0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        while(right<n && left<=right)
        {
            
            if(!mp.containsKey(arr[right]))
            {
                
                mp.put(arr[right], 1);
                ans += arr[right];
                max = Math.max(ans, max);
                right++;	
            }
            else
            {
                ans = ans-arr[left];
                mp.remove(arr[left]);
                left++;
            }

        }
        return max;
    }

    public int maximumUniqueSubarray(int[] arr) {
        Set<Integer> mp = new HashSet<>();
	    int n = arr.length;
        int left =0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int ans = 0;
        while(right<n && left<=right)
        {
            
            if(!mp.contains(arr[right]))
            {
                
                mp.add(arr[right]);
                ans += arr[right];
                max = Math.max(ans, max);
                right++;	
            }
            else
            {
                ans = ans-arr[left];
                mp.remove(arr[left]);
                left++;
            }

        }
        return max;
}
}