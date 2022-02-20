package LeetCoding.Hard;

import java.util.*;

public class BurstBalloons_312
{
    public static int burstBallonsCoins(int[] arr)
    {
        // We are not coding just yet but just basing the foundations for what I know will work
        List<Integer> res = new ArrayList<>();

        // We set two conditions for if the length is even or odd. 
        int mid = 0;
        int coins = 0;
        for(int i = 0; i<arr.length-1; i++)
        {

            // We need to keep updating our mid everytime our element gets removed from the array
            mid = arr.length/2;
            // While we are inside our boundaries
            if(i>=0 || i<arr.length)
            {
            if(arr.length % 2== 0)
            {
                if(arr[mid]>arr[mid-1])
                    coins = arr[mid-1]*arr[mid]*arr[mid+1];
                else 
                    coins = arr[mid]

            }
            }

        }


    }

    public static void main(String[] args) {
        
    }
}