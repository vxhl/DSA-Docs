package DSA450Restart.Matrices;
import java.util.*;


class Solution {
    static class pair{
        
        long height;
        long index;
        
        pair(long height, long index){
            
            this.height = height;
            this.index = index;
            
        }
        
    }
    private static void findnsl(long nsl[], long hist[],long n){
        
        Stack<pair> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            // check if the stack is empty
            if( st.size() == 0 ) nsl[i] = -1;
            
            // check if the stack has element
            else if( st.peek().height < hist[i]) {
                   
                   nsl[i] = st.peek().index;    
            
            }
            else {
                
                // remove from stack till a smaller element is found
                while(st.size()!=0 && st.peek().height >= hist[i] ) st.pop();
                
                if( st.size() == 0 ) nsl[i] = -1;
                else if( st.peek().height < hist[i] ) nsl[i] = st.peek().index;
                
            }
            
            st.push(new pair( hist[i] , (long)i));
        }
        
    }
    
        private static void findnsr(long nsl[], long hist[],long n){
        
        Stack<pair> st = new Stack<>();
        
        for(int i= (int)n-1 ;i >= 0 ;i--){
            // check if the stack is empty
            if( st.size() == 0 ) nsl[i] = n;
            
            // check if the stack has element
            else if( st.peek().height < hist[i]) {
                   
                   nsl[i] = st.peek().index;    
            
            }
            else {
                
                // remove from stack till a smaller element is found
                while(st.size()!=0 && st.peek().height >= hist[i] ) st.pop();
                
                if( st.size() == 0 ) nsl[i] = n;
                else if( st.peek().height < hist[i] ) nsl[i] = (long)st.peek().index;
                
            }
            
            st.push(new pair( hist[i] , (long)i));
            
        }
        
    }
    
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        
         long []nsl = new long[(int)n];
         long []nsr = new long[(int)n];
         
         // find the index of next smaller element in left
         findnsl(nsl,hist,n);
         
         //find the index of next smaler element in right
         findnsr(nsr,hist,n);
          
         long res = 0;
         
         for(int i=0;i<n;i++){
             long areaHist = (nsr[i] - nsl[i] - 1)*hist[i];
             res = Math.max(res,areaHist);
         }
        
        return res;
    }
    
    
    
    
    public int maxArea(int arr[][], int n, int m) {
        // add code here.
        long[] hist = new long[m];
        
        for(int j=0; j<m; j++)
        {
            hist[j] = arr[0][j];
        }
        // We get the histogram for the first row
        int mx = (int)getMaxArea(hist, m);
        
        for(int i=1; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                if(arr[i][j] == 0)
                {
                    hist[j] = 0;
                }
                else
                {
                    hist[j] += arr[i][j];
                }
            }
            mx = Math.max(mx, (int)getMaxArea(hist, m));
        }
        
        return mx;
        
        
    }
}