package DSA450Restart.Matrices;
import java.util.*;

class SolutionCont
{
    /*
    Pretty sure I have done this a long time back
    Find the element(s) that are present in all rows of the given atrix
    If not present then return -1? Or something else? 
    Depends on whether there are negative elements in the matrix or if all
    elements are non zero or not
            {{1, 2, 1, 4, 8},
             {3, 7, 8, 5, 1},
             {8, 7, 7, 3, 1},
             {8, 1, 2, 7, 9},
            };
        One technique is to go through the entire matrix and store the frequenceis of all
        the values in a map and then return all the values that occur arr[0].length-1 amount of
        times
        This approach will take O(n*n) time to traverse the matrix with additional constant time
        to get the element that occurs more arr[0].length-1 times 
        takes a space of n*n as well for the hashmap and storing all the values\

        Ok so, what other approaches can be there considering our previous problems
        There is no need for binary search ofc since we are not searching for anything specific here
        We are searching for occurences nad it has not been specified whether the matrix is sorted or not
       
        In the map implementation we first initialise our first row and then keep checing for
        occurences of these elements in the other rows. By th last row we check the occurences of the rows


        
    */

    public static ArrayList<Integer> findCommonElements(int[][] arr)
    {
        // Write your code here.
        ArrayList<Integer> commonElements = new ArrayList<>();
	    HashMap<Integer, Integer> mp = new HashMap<>();
        int n = arr.length;
        int m = arr[0].length;
        // We first initialise our first row and set the count for each element as 1 even if there are dupes

        for(int i=0; i<m; i++)
        {
            mp.put(arr[0][i], 1);
        }

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                // If the element is present in the map and
                // is not duplicated in the current row
                if(mp.get(arr[i][j])!=null && mp.get(arr[i][j]) == i)
                {
                    mp.put(arr[i][j], i+1);
                    
                    
                    if(i==n-1)
                    {
                        commonElements.add(arr[i][j]);
                    }
                }
            }
        }
        return commonElements;


        
        // for(Map.Entry trav_map : mp.entrySet())
        // {
        //     if((int)trav_map.getValue() == arr.length)
        //     {
        //         commonElements.add((int)trav_map.getKey());
        //     }
        // }
        
    }



}
class DriverClassMatrices
{
    
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 1, 4, 8},
        {3, 7, 8, 5, 1},
        {8, 7, 7, 3, 1},
        {8, 1, 2, 7, 9},
       };
       ArrayList<Integer> ans = SolutionCont.findCommonElements(arr);
       for(int i=0; i<ans.size(); i++)
       {
           System.out.print(ans.get(i)+ " ");
       }
    }
}