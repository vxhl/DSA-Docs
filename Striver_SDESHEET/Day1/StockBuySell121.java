/*
Problem Statement: 

*/
package Striver_SDESHEET.Day1;
import java.util.*;

public class StockBuySell121
{

    public static int buysellcopied(int[] arr)
    {
        int profit = 0;
        int buy = arr[0];

        for(int i = 1; i<arr.length; i++)
        {
            buy = Math.min(buy, arr[i]);
            profit = Math.max(profit, arr[i] - buy);
        }
        return profit;
    }




    public static int buysell(int[] arr)
    {
           
        int buy = Integer.MAX_VALUE;
        int sell = 0;
        int profit = 0;
        int curr = 0;
        
        for(int i = 0; i<arr.length; i++)
        
        {
            curr = sell-buy; 
            if(curr>0) profit = curr;
            if(arr[i] < buy  )   buy = arr[i];    
            else if(arr[i] > buy && arr[i] > sell ) sell = arr[i];
            
        }
        if(profit<0 || sell == 0) return 0;
        return profit;
    }

    

    public static void main(String[] args) {
        // THis feels somewhat similar to the kadane's algorithm
        int[] arr = {2,4,1};
        int[] arr1 = {7,6,4,3,1};
        int[] arr2 = {7,1,5,3,6,4};
        int[] arr3 = {1,2};
        System.out.println("res1: " + buysellcopied(arr));
        System.out.println("res2: " + buysellcopied(arr1));
        System.out.println("res3: "+ buysellcopied(arr2));
        System.out.println("res4: " + buysellcopied(arr3) );
        
    }
}