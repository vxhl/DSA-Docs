class Solution {
    public String largestPalindromic(String nums) {
        
        // If we use a map, we are not able to traverse it as we want from the back to get the largest value so instead
        
        int[] freq = new int[10];
        
        for(char c: nums.toCharArray()){
            freq[c-'0']++;
        }
        StringBuilder front = new StringBuilder();
        StringBuilder back = new StringBuilder();
        // maybe we can use a flag somehow
        // if our cases never pass for the while condition but we do find a freq[0] that has frequency greater than 0 then we return that in
        // case both front and back are empty
        boolean flag = false;
        if(freq['0'-'0']!=0){
            flag = true;
        }
        
        for(int i=9; i>=0; i--){
            // We iterate from the back since we need to get the largest value
            if(i==0 && front.toString()==""){
                continue;
            }
            while(freq[i]>1){
                front.append(Integer.toString(i));
                back.append(Integer.toString(i));
                freq[i]-=2;
            }
        }
        
        for(int i=9; i>=0; i--){
            if(freq[i]==1){
                front.append(Integer.toString(i));
                break;
            }
        }
        
        back.reverse();
        return front.isEmpty() && back.isEmpty() && flag ? "0":front.toString()+back.toString();
        
        
        
        
        
        
        
    }
}