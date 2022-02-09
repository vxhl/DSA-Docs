package infyTQ2022_JavaPractice;
import java.util.*;


public class teamDivision {

    // Did some actual shit with this so let us now try and solve this ourselves from what we have learnt
    // So what do we need? 
    // Well first we need to get the minimumDifference recursion function sorted
    // Other than that for getting the actual pairs of the partition sum we need to apply a formula where
    // ( total/2 - mD/2 ) and ( total/2 + min/2 ) are our elements
    // How will I explain this when I am actually doing the problem tho?



    private static int minDifference(int[] arr, int N, int S1, int S2, int lenS1, int lenS2)
    {
        // Here we have S1 and S2 that are the sum of each combinations that we are gonna create
        // lenS1 and lenS2 however are the lengths of the combinations to make sure that neither is greater than another by 2
        // Base cases
        if(N<0)
        {
        if(Math.abs(lenS1-lenS2)>1)
        {
            // then ofc we do not execute
            return Integer.MAX_VALUE;
        }
        return Math.abs(S2-S1);
        }

        // We have here defined our actual recursion code
        return Math.min(minDifference(arr, N-1, S1, S2, lenS1, lenS2), minDifference(arr, N-1, S1+arr[N], S2-arr[N], lenS1+1, lenS2-1));
    }

    public static List<Integer> teamDiv(int[] arr)
    {
        List<Integer> ans = new ArrayList<>();
        int totalSum = 0;
        for(int i: arr)
        {
            totalSum+=i;
        }

        int min = minDifference(arr, arr.length-1, 0, totalSum, 0, arr.length);
        ans.add((int) ((float)totalSum/2 -(float) min/2));
        ans.add((int)((float)totalSum/2 + (float) min/2));
        return ans;
    }





    // public static List<Integer> teamDivWrong(int[] arr)
    // {
    //     int total = 0;
    //     int[] vis = new int[arr.length];
    //     for(int i: vis )
    //     {
    //         i= 0;
    //     }
    //     for(int i: arr)
    //     {
    //         total+=i;
    //     }

    //     List<Integer> arr1 = new ArrayList<>();
    //     List<Integer> arr2 = new ArrayList<>();
    //     int ptotal = 0;
    //     for(int i=0; i<arr.length; i++)
    //     { 
            
    //         while(ptotal!=total/2)
    //         {
    //             vis[i] = 1;  
    //             ptotal+=arr[i];
    //             arr1.add(arr[i]);
                
    //         }
    //     }


    //     // int ptotal2 = 0;
    //     // for(int i=0; i<arr.length; i++)
    //     // {
    //     //     if(vis[i]==0)
    //     //     {
    //     //         ptotal2 += arr[i];
    //     //     }
    //     // }
    //     System.out.println(arr1);
    //     List<Integer> res = new ArrayList<>();
    //     res.add(ptotal);
    //     // res.add(ptotal2);
    //     return res;


    // }

    public static void main(String[] args) {
        int[] arr = {87,100,28,67,68,41,67,1};
        System.out.println(teamDiv(arr));
    }
}
