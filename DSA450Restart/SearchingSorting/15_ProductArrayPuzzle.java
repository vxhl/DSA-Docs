import java.util.*;

class Solution_Puzzles
{
    // Optimised O(N) time and constant space
    public int[] productExceptSelf1(int[] arr)
    {
        int product = 1;
        int countOfZeroes = 0;
        
        for(int i: arr)
        {
            if(i!=0)
            {
                product = product*i;
            }
            else
            {
                countOfZeroes++;
            }
        }
        
        int[] res = new int[arr.length];
        
        for(int i=0; i<arr.length; i++)
        {
            // So now the conditions
            // 0,0,2,3,4 => 0,0,0,0,0 
            if(arr[i]!=0 && countOfZeroes>0 || arr[i] == 0 && countOfZeroes-1>0)
            {
                res[0] = 0;
            }
            else if(arr[i]!=0)
            {
                res[i] = product/arr[i];
            }
            else if(arr[i] == 0)
            {
                res[i] = product;
            }
        }
        
        return res;
        
        
    }

            // Brute force O(n2)    
            public int[] productExceptSelf2(int[] arr) {
                int[] res = new int[arr.length];
        
                for(int i=0; i<arr.length; i++){
                    int iter = 0; // So this will loop over our entire array
                    int prod = 1; // this is what we need in our result array
                    while(iter!=arr.length){
                        
                        // So we multiply prod as long as it is not ith
                        if(iter!=i)
                        {
                            // 3*5*6*2
                            prod = prod*arr[iter];
                        }
                        iter++;
                    }
                    // We store the prod in our res[i];
                    // Then we move on to the next element
                    res[i] = prod;
                }
        
                return res;
            }
            
            // Using prefix and suffix products
            public static int[] productExceptSelf(int[] arr) {
                int[] res = new int[arr.length];
                // We simply use the prefix sum thing but how?
                int[] left = new int[arr.length];
                int[] right = new int[arr.length];
                left[0] = arr[0];
                right[arr.length-1] = arr[arr.length-1]; 
                for(int i=1; i<arr.length; i++)
                {
                    left[i] = arr[i]*left[i-1]; 
                    System.out.print(left[i]+" ");
                }
                 
                    System.out.println();
                for(int i=arr.length-2; i>=0; i--)
                {
                    right[i] = arr[i]*right[i+1];
                     
                    System.out.print(right[i]+" ");
                }
                
                for(int i=0; i<arr.length; i++)
                {
                    // We have corner case for the first and the last element right
                    if(i==0)
                    {
                        res[i] = right[i+1];
                    }
                    else if(i==arr.length-1)
                    {
                        res[i] = left[i-1];
                    }
                    
                    else
                    {
                        res[i] = left[i-1]*right[i+1];
                    }
                }
                return res;
                
                
            
            }
    public static void main(String[] args) {
        int[] arr = {10,3,5,6,2};
        for(int i: productExceptSelf(arr))
        {
            System.out.print(i+ " ");    
        }

    }
}
