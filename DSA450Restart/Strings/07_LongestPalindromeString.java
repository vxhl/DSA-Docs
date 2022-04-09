package DSA450Restart.Strings;

class Solution_LPString
{
    /*
    I know how to get the length of the largest palindrome substring but
    not how to print it. Ik how to print the Longest subset and all so let's apply that
    here. 
    Need to look it up a bit again ofc. 
    */
    static String longestPalin(String S){
        // code here
        // We use the two pointer approach again, but a bit differently
        
        // First let us initialise our base conditions alr
        
        int n = S.length();
       
        if(n<2) 
        {
            return S;
        }
        // Ok so we need to traverse the entire string right
        int high, low;
        int start = 0;
        int maxLength = 1;
        // So we do the following
        for(int i=0; i<S.length(); i++)
        {
            low = i-1;
            high = i+1;
            
            // For moving our high pointer
            
            while(high<n && S.charAt(high) == S.charAt(i))
            {
                high++;
            }
            
            while(low>=0 && S.charAt(low) == S.charAt(i))
            {
                low--;
            }
            
            while(low>=0 && high<n && S.charAt(low) == S.charAt(high))
            {
                
                low--;
                high++;
            }
            
        int length = high-low-1;
        if(maxLength<length)
        {
            maxLength = length;
            start = low+1;
        }
        }
        return S.substring(start, start+maxLength);
    }

    
}