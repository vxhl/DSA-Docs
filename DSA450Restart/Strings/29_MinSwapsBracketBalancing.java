package DSA450Restart.Strings;

class Sol_bracketBalancing
{
    static int minimumNumberOfSwaps(String S){
        // code here
       int swap = 0;
       int count = 0;
       
       for(int i=0; i<S.length(); i++)
       {
           
           if(S.charAt(i) == '[')
            {
                count--; // We reduce the number of brackets we need to swap    
            }
            else
            {
                // We increase the count
                count++;
                
                // The logic is that, if our entire string is balanced our answer will always be 0, otherwise it will be
                // greater than 0
                if(count>0)
                {
                    swap += count;
                }
            }    
        
           
       }
       return swap;
    }
}