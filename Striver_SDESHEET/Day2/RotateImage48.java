/*
Problem Statement:
Just rotate image matrix like we always have
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
*/

package Striver_SDESHEET.Day2;

// import Arrays.rotate;


public class RotateImage48 {
    

    public static int[][] rotate(int[][] arr)
    {
        for(int i=0; i<arr.length; i++)
        {
            for(int j=i; j<arr[0].length; j++)
            {
                // First we transpose the elements
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for(int i=0; i<arr.length; i++)
        {
            int top = 0;
            int bottom = arr.length -1;

            while(top<=bottom)
            {
                int temp = arr[i][top];
                arr[i][top] = arr[i][bottom];
                arr[i][bottom] = temp;
                top++;
                bottom--;
            }

        }
        return arr;
    }
    
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},
                        {4,5,6},
                        {7,8,9}
                        };   

        System.out.println(rotate(arr).toString());
        

                    }
}
