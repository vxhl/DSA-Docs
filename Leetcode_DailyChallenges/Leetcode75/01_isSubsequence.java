class Solution {
    public boolean isSubsequence(String s, String t) {
       int m = s.length();
       int n = t.length();
       
       if(helper(s,t,m,n)){
           return true;
       }
       return false;
    }
    private boolean helper(String s, String t, int m, int n){
        if(m==0) return true;
        if(n==0) return false;

        if(s.charAt(m-1)==t.charAt(n-1)){
            return helper(s,t,m-1,n-1);
        }
        return helper(s,t,m,n-1);
    }
    public boolean isSubsequence2(String s, String t) {
        int ptr1 = 0;
        int ptr2 = 0;
        int l1 = s.length();
        int l2 = t.length();
        if(l1>l2) return false;
        if(l1==0) return true;
        while(ptr2<l2){
            if(ptr1<l1 && t.charAt(ptr2)==s.charAt(ptr1)){
                ptr2++;
                ptr1++;
            }else{
                ptr2++;
            }
        }
        if(ptr1==l1){
            return true;
        }
        return false;
        
    }
    
}