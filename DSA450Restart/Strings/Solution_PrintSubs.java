import java.util.*;
public class Solution_PrintSubs
{
    public static int FindContiguousSeq(int input1, int[] input2){
        ArrayList<ArrayList<Integer>> subs = new ArrayList<>();
        return GetSum(subs, input2);
    }
    public static ArrayList<ArrayList<Integer>> helper_func(int[]arr, int i, ArrayList<Integer> ds)
    {
        // Maybe this will work
        int n = arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // THis is our base case
        if(i==n){
            ans.add(ds);
            return ans;
        }
        helper_func(arr, i+1, ds);
        if(arr[i]>=0){
            ds.add(arr[i]);
        }
        helper_func(arr, i+1, ds);
        if(ds.size()>0) ds.remove(ds.size()-1);
        return ans;
    }

    public static int GetSum(ArrayList<ArrayList<Integer>> subs, int[]arr){
        ArrayList<Integer> ds = new ArrayList<>();
        subs = helper_func(arr, 0, ds);
        int max = Integer.MIN_VALUE;
        for(ArrayList<Integer> i: subs){
            int sum = 0;
            for(int x: i){
                sum +=x;
            }
            max = Math.max(sum,max);
        }
        return max;

    }

    public static void main(String[] args) {
        int[] input2 = {1,2,4,-2,3};
        int input1 = 5;
        System.out.println(FindContiguousSeq(input1, input2)); 
    }
}