class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int[] kVal = new int[k];
        return helper(0,cookies, k, kVal);
    }
    
     
    private int helper(int ind, int[] cookies, int k, int[] kVal){
        // Base conditions
        if(ind == cookies.length){
            // If we have reached the base condition we get the max valued cookies we have given to a student 
            int res = 0;
            for(int i: kVal) res = Math.max(res,i);
            return res;
        }

        // Otherwise we start calculating for our array
        int res = Integer.MAX_VALUE;
        for(int i=0; i<k; i++){
            // We give the ind cookie to the first student and then
            // We let them hold the minimum number of cookies they can
            kVal[i] += cookies[ind];
            res = Math.min(res, helper(ind+1, cookies, k, kVal));
            kVal[i] -= cookies[ind];
        }
        return res;
    }
    
    
}
