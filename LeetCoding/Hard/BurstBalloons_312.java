package LeetCoding.Hard;

import java.util.*;

public class BurstBalloons_312
{
    public static int burstBallonsCoins(int[] arr)
    {
        List<Integer> res = new ArrayList<>();

        for(int i: arr)
        {
            res.add(i);
        }
        int mid = 0;
        int coins = 0;
        for(int i=0; i<arr.length-1; i++)
        {
            mid = res.size()/2;

            // Condition for if the length of the list is even 
            // there will be two mids and we choose the mid that is smaller
            if(mid-1>=0 && mid+1<res.size())
            {
            if(res.size()%2==0 && res.get(mid-1)<res.get(mid))
            {
                mid = mid-1;
                coins+= res.get(mid-1)*res.get(mid)*res.get(mid+1);
                res.remove(mid);
            }
            else if(res.get(mid-1)<res.get(mid))
            {
                mid = mid-1;
                coins+= res.get(mid-1)*res.get(mid)*res.get(mid+1);
                res.remove(mid);
            }
            else if(res.get(mid+1)<res.get(mid))
            {
                mid = mid+1;
                
            }
                // }
                // else if(res.get(mid+1)<res.get(mid))
                // {
                // mid = mid+1;
                // coins+= res.get(mid-1)*res.get(mid)*res.get(mid+1);
                // res.remove(mid);
                // }
            }
            }

            // When outside the boundary conditions 
            else
            {   
                if(res.get(mid-1)<res.get(mid))
                {
                    mid = mid-1;
                    coins+= 1*res.get(mid)*res.get(mid+1);
                    res.remove(mid);
                }
                else
                {
                    coins+= res.get(mid-1)*res.get(mid)*1;
                    res.remove(mid);
                    
                }
            }

        }
        coins+=res.get(0);
        return coins;


    }

    public static void main(String[] args) {
        int[] arr = {9,21,64,76,99};
        System.out.println(burstBallonsCoins(arr));
    }
}