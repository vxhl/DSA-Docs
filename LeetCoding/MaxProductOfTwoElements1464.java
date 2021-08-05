package LeetCoding;

import java.util.Arrays;
import java.util.TreeSet;

class Solution {
    public int maxProduct(Integer[] arr) {
    Arrays.sort(arr);
    return ((arr[arr.length-1]-1)*(arr[arr.length-2]-1));
    }
    public static void main(String[] args) {
        Integer[] nums = {1,5,4,5};
        Solution s = new Solution();
        System.out.println(s.maxProduct(nums));
        
    }
    
}