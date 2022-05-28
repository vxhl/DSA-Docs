class Solution_MissingNumber {
    public int missingNumber(int[] nums) {
        int m_xor = 0;
        int xor = 0;
        int n = nums.length;
        for(int i=0; i<n+1; i++)
        {
            xor ^= i;
        }
        for(int i=0; i<n; i++)
        {
            m_xor ^= nums[i];
        }
        
        int result = xor ^ m_xor;
        return result;
    }
}