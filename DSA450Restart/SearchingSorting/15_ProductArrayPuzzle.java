import java.util.*;

class Solution_Puzzles
{
    public static int[] puzzles(int[] arr)
    {
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
    public static void main(String[] args) {
        int[] arr = {10,3,5,6,2};
        for(int i: puzzles(arr))
        {
            System.out.print(i+ " ");    
        }
    }
}