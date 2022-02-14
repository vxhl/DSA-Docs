/*
Problem Statement:
Given an m x n integer matrix matrix, 
if an element is 0, set its entire row and column to 0's.

*/
package Striver_SDESHEET.Day1;

public class ZeroMatrix {

    public static void printMatrix(int[][] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] zeroMatrixUtil(int[][] arr)

    {
        int[] rows = new int[arr.length];
        int[] cols = new int[arr[0].length];
        for(int i=0; i<rows.length; i++)
        {
            rows[i] = 0;
        }
        for(int i=0; i<cols.length; i++)
        {
            cols[i] = 0;
        }

        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<arr[0].length; j++)
            {
                if(arr[i][j] == 0)
                {
                    rows[i] = 1;
                    cols[j] = 1;
                }

            }

            for(int k=0; k<arr[0].length; k++ )
            {
                if(rows[k] == 1)
                {
                    arr[k][i] = 0;
                }
            }
            for(int l =0; l<arr[0].length;l++)
            {
                if(cols[l] == 1)
                {
                    arr[i][l] = 0;
                }

            }
        }
        return arr;

        // In place matrix transformation
    }

    public static void setZeroes(int[][] arr)
    {
        int col0 = 1;
        int rows = arr.length;
        int cols = arr[0].length;

        // We get the dummy variables and set them as the following 
        for(int i=0; i<rows; i++)
        {
            if(arr[i][0] == 0) col0 = 0;
            for(int j = 1; j<cols; j++)
            {
                if(arr[i][j] == 0)
                {
                    arr[i][0] = arr[0][j] = 0;
                }
            }
        }
        
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        zeroMatrixUtil(matrix);
        printMatrix(matrix);
    }
}
