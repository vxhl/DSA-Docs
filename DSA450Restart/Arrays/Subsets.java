package DSA450Restart.Arrays;
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
        
        printSS(arr, n, ind+1, ds);
        ds.add(arr[ind]);
        printSS(arr, n, ind+1, ds);
        ds.remove(ds.size()-1);
    }
}


// GFG Version
class Solution{
    
    // We first of all have our comparator that is used to sort the different ArrayLists in the order of their occurence from smallest to the largest elements
    static class MIN implements Comparator<ArrayList<Integer>>
    {
        public int compare(ArrayList<Integer> a,ArrayList<Integer> b)
        {
            for(int i=0;i<Math.min(a.size(),b.size());i++)
            {
                if(a.get(i)>b.get(i)) return 1;
                else if(a.get(i)<b.get(i)) return -1;
                else continue;
            }
            return a.size()-b.size();
        }
    }
    
    // static HashSet<ArrayList<Integer>> map;
    static void helper(ArrayList<Integer> temp,int ind , ArrayList<Integer> A, ArrayList<ArrayList<Integer>> res){
        if(ind == A.size()){
            res.add(new ArrayList<>(temp));
            if(temp.size()-1 >= 0)
            	temp.remove(temp.size()-1);
            return;
        }
        ArrayList<Integer> t1 = temp;
        t1.add(A.get(ind));
        helper(temp,ind + 1,A, res);
        helper(t1,ind  + 1,A, res);
    }
    
    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> superSet){
        //code here
	    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
	    ArrayList<Integer> t1 = new ArrayList<>();
	    helper(t1,0,superSet, res);
	    Collections.sort(res,new MIN());
        return res;
    }
}