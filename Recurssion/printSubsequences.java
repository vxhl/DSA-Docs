package Recurssion;
import java.util.*;

class printSubsequncesmain
{
    public static void main(String[] args) {
        int[] arr = {3,1,2};
        int n = arr.length;
        ArrayList<Integer> ds = new ArrayList<>();
        int i = 0;
        printSSFunc.printSS(arr, n, i, ds);
    }
}
class printSSFunc {
    static void printSS(int[] arr, int n, int ind, ArrayList<Integer> ds)
    {
        // First we define our base conditions
        if(ind == n)
        {
            for(int x: ds) 
            {
                System.out.print(x+" ");
            }
            System.out.println();
            if(ds.size() == 0) System.out.println("{}");
            return;
        }

        // Now we start defining our recursive function
        // First we do the take function
        printSS(arr, n, ind+1, ds);
        ds.add(arr[ind]);
        printSS(arr, n, ind+1, ds);
        ds.remove(ds.size()-1);
    }
}