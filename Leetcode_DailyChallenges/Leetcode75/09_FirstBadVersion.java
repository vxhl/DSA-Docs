/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

      public class Solution extends VersionControl {
        public int firstBadVersion(int n) {
            if(n==1) return 1;
            int low = 1;
            int high = n;
            while(low<=high){
                int mid = low+(high-low)/2;
                if(isBadVersion(mid)){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            return low;
    
    
    
        }
    }
    /*
    Looks like a binary search problem. 
    we basically need to find the leftmost good version to get the first bad version 
    by doing the goodversion+1
    
    */