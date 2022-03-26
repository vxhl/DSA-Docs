package DSA450Restart.Matrices;
import java.util.*;
class Solution
{

  
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int arr[][])
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        
        // The really tricky part about this problem is keeping care and track of the different variable that
        // we use to keep track of everything
        
        // So how do we start this
        
        // We need a 
        int startRow = 0;
        int endRow = arr.length-1;
        int startCol = 0;
        int endCol = arr[0].length-1;
        // We need these inorder to keep track of the reducing size of the matrix
        // Basically we keep track of these while
        // So when we are done traversing both and the values become equal for startRow and endRow and vice versa for startCola and endCol
        // That means we are done with the entire matrix and reached the last element that is at the center of the spiral
        while(startRow<=endRow && startCol <= endCol)
        {
            // First of all we are going to traverse and get the first row
            
            for(int i=startCol; i<=endCol;  i++)
            {
                res.add(arr[startRow][i]);
            }
            // Work for first row is done so we increment it
            startRow++;
            
            for(int i=startRow; i<=endRow; i++)
            {
                res.add(arr[i][endCol]);
            }
            // For for last column is done so we decrement it
            endCol--;
            
            if(startRow<=endRow)
            {
                for(int i=endCol; i>=startCol; i--)
                {
                    res.add(arr[endRow][i]);
                }
                // The work for last row is done so we decrement our row 
                endRow--;
            }
            
            if(startCol<=endCol)
            {
                for(int i=endRow; i>=startRow; i--)
                {
                    res.add(arr[i][startCol]);
                }
                // Work for first column is done so we increment it
                startCol++;
                
            }
        }
        
        
        return res;
        
        
        
        
        
    }

    public static void main(String[] args) {
        int arr[][] =  {{1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11,12},
                        {13, 14, 15,16}};
        for(int i: spirallyTraverse(arr))
        {
            System.out.print(i + " ");
        }
    }
}
