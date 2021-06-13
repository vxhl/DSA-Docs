package CodeWithScaler.Week2;

import java.util.Arrays;

public class ZigZagString01 {
    
    static void zigzag(int n, String A)
    {
        if(n==1 || n>=A.length())
        {
            System.out.println(A);
        }
        int row = 0;
        String[] arr = new String[n]; // We assign a new character array for the number of rows in the zig zag pattern
        // ABCDEFGH
        // ACEG and BDFH so there are two rows here and the arr = ['ACEG','BDFH']
        Arrays.fill(arr,"");
        boolean down=true;
        for(int i= 0; i<A.length(); i++)
        {
            arr[row] += A.charAt(i);
            
            if (row==n-1)
            {
                down = false;
            }
            else if(row==0)
            {
                down= true;
            }
            if(down)
            {
                row++;
            }
            else
            {
                row--;
            }
        }
        for(int i=0; i<arr.length; i++)
        {
            System.out.println(arr[i]);
        }
    }
    
    
    public static void main(String[] args) 
    {
        int n = 3;
        String str1 = "GEEKSFORGEEKS";
        zigzag(n, str1);
    }

}
