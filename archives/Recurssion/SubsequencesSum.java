package Recurssion;
import java.util.*;

class SubsequncesSum
{

    static void printSSSum(int[] arr, int asum, ArrayList<Integer> ds, int ind, int sum) 
    {

        // Base case
        if(ind == arr.length)
        {
            if(asum == sum)
            {
                for(int x: ds) { System.out.print(x+ " "); }
                System.out.println();
            }
            return;
        }
        ds.add(arr[ind]);
        asum += arr[ind];
        printSSSum(arr, asum, ds, ind+1, sum);
        asum -= arr[ind];
        ds.remove(ds.size()-1);
        printSSSum(arr, asum, ds, ind+1, sum);
        
    }

    // Program to print just one subsequence sum that adds up to target
    static boolean printSSSumOne(int ind, ArrayList<Integer> ds , int asum, int[] arr, int k)
    {
        if(ind == arr.length)
        {
            // The Base Cases
            if(asum == k)
            {
                for(int i: ds) { System.out.print(i+ " ");}
                System.out.println();
                return true; 
            }
            else return false;
        }

        ds.add(arr[ind]);
        asum += arr[ind];
        if(printSSSumOne(ind+1, ds, asum, arr, k) == true) return true;

        asum -= arr[ind];
        ds.remove(ds.size()-1);
        if(printSSSumOne(ind+1, ds, asum, arr, k)== true) return true;
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {5, 12, 3, 17, 1, 18, 15, 3, 17};
        int k = 6;
        ArrayList<Integer> ds = new ArrayList<>();
        // printSSSum(arr, 0, ds, 0, k);
        printSSSumOne(0, ds, 0, arr, k);
    }   
}
