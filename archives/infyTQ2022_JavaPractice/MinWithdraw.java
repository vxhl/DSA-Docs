package infyTQ2022_JavaPractice;
import java.util.*;


public class MinWithdraw 
{

    public static int minWithdrawals(int N, int[] arr, int k )
    {
        // Here N is number of elements in the ATM
        // arr describes those N elements
        // K is the amount of money Sarah wants to withdraw
        int total = 0;
        for(int i=0; i<N; i++)
        {
            total+=arr[i];
        }
        if(total<k)
        {
            return -1;
        }

        int cash = 0;
        int res = 0;

        for(int i=0; i<N; i++)
        {
            if(arr[i] == k) return 1;
            
            if(arr[i]<k && arr[i]!=0) 
            {
                cash+=arr[i];
                res++;
            }
        }
        return res;

    }
    public static void main(String[] args) {
        int N = 3;
        int arr[] = {1,0,0,0,0,0,1};
        int k = 3;
        
        System.out.println(minWithdrawals(N, arr, k));
        }
}
