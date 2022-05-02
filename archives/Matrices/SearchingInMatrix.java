/*
Problem Statement:
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
*/

package Matrices;

public class SearchingInMatrix 
{
    // Binary Search O(logmxn)
    // Space: O(1)
    static boolean searchMatrix(int[][] matrix, int target) 
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int h = (n*m) - 1;
        while(l<=h)
        {
            int mid = l + (h-l/2); // To prevent integer overflow
            if(matrix[mid/m][mid%m] == target) 
            
            {return true;}

            if (matrix[mid/m][mid%m] > target) { h = mid-1; }
            else { l = mid+1; }
        }
        return false;  
    }

    // Approach 2: Using rotation
    static boolean searchMatrixRotation(int[][] matrix, int target)
    {
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m-1; // We set the pointer to the last column
        while(i<n && j>=0)
        {   

            if(matrix[i][j] == target) return true;
            
            if(matrix[i][j]>target)
            {
                j--;
            }
            else
            {
                i++;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        int[][] arr= {{1,3,5,7},{10,11,16,2},{23,30,34,60}};
        int x = 10;
        System.out.println(searchMatrixRotation(arr, x));
        
    
    }
}
