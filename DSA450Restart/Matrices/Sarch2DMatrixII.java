package DSA450Restart.Matrices;

public class Sarch2DMatrixII {
    /*
    In the first part of this variation of problem we had the entire matrix sorted row-wise consecutively
    but in this one we have the row-column wise sorted thing so the elements will not be continuously sorted this time around
    */

     // Ok so this should be similar to how we did the previous one
        // But this time we don't need to find he minimum or anything we just need
        // to search for one element

        // We do need to implement that lessEqualK thing i guess, but this time 
        // what are the changes that need to be made

        // Ok wait what are the things I am missing out on here

        // Even if i am talking about that lessequalk function I don't understand how to code it out tho

        // Ik i need to search for elements that are lesser than the current mid
        // and get the rank of it that is what it does




    // Ok this is pretty rad
    // We start our mid from (0, m-1) as it is the mid 

        public boolean searchMatrix(int[][] arr, int target) 
        {
            int n = arr.length;
            int m = arr[0].length;
            int i = 0;
            int j = m-1;
            int mid = arr[i][j];
                
            while(i>=0 && i<n && j>=0 && j<m)
            {
                if(arr[i][j] == target)
                {
                    return true;
                }
                else if(arr[i][j]>target)
                {
                    j--;
                }
                else if(arr[i][j]<target)
                {
                    i++;
                }
            }
            
            return false;
        }
        
}
