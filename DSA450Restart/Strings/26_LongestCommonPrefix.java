class Solution {
    public String longestCommonPrefix(String[] arr) {
        if(arr.length==0) return "";
        String ans = arr[0];
        
        for(int i=1; i<arr.length; i++)
        {
            while(!arr[i].startsWith(ans))
            {
                // If our prefix does not start with the current string we keep reducing the length of the prefix
                // till it matches the current string.
                 ans = ans.substring(0, ans.length()-1);                     
            }
         
        }
        
        return ans;
    }
}