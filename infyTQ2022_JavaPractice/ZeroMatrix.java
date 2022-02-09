package infyTQ2022_JavaPractice;
import java.util.*;
// The Zero matrix problem basically tries to turn all the rows and columns into zero
// If any element is zero we turn all the rows and columns going across it as 0
public class ZeroMatrix {



    public static int[][] zeromatrix_boolean(int[][] arr)
    {
        boolean[] zero_rows = new boolean[arr.length];
        boolean[] zero_cols = new boolean[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            zero_rows[i] = false;
            zero_cols[i] = false;
        }
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                if(arr[i][j] == 0)
                {
                    zero_rows[i] = true;
                    zero_rows[j] = true;
                }
            }

            for(int k=0; k<arr[0].length; k++)
            {
                if(zero_rows[k] == true)
                {
                    arr[k][i] = 0;
                }
            }
            
            for(int l=0; l<arr[0].length; l++)
            {
                if(zero_cols[l] == true)
                {
                    arr[i][l] = 0;

                }
            }
        }
        // Now that we have our elements where we have to implement our answer
        return arr;
    }


    // Incorrect
    public static int[][] zeroMatrix(int[][] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                if(arr[i][j] == 0)
                {
                    // First we traverse all the rows and make all the elements 0
                    for(int k=0; k<arr.length; k++)
                    {
                        arr[k][j] = 0;
                        arr[i][k] = 0;
                    }
                }
            }
        }

        
        return arr;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{4,2,0,6},
                        {3,2,9,7},
                        {1,9,2,0},
                        {3,6,1,4}};
        zeromatrix_boolean(arr);
        for(int i=0;i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
