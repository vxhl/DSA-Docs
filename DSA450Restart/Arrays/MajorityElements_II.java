package DSA450Restart.Arrays;
import java.util.*;

public class MajorityElements_II
{

    // O(N) space and O(N) time approach
    public List<Integer> majorityElement(int[] arr) 
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        // We get the frequency Map for the array
        for(int i: arr)
        {
            if(!mp.containsKey(i))
            {
                mp.put(i, 1);
            }
            else
            {
                mp.put(i, mp.get(i)+1);
            }
        }
        
        int target = arr.length/3;
        List<Integer> res = new ArrayList<>();
        for(Map.Entry mapElement : mp.entrySet())
        {
            if((int)mapElement.getValue()>target)
            {
                res.add((int)mapElement.getKey());
            }
        }
        
        return res;
        
    }

    // O(1) Space and O(?) time approach
    // We apply here the algorithm that we applied earlier for the previous problem Majority Elements 1
    // But this time since we have N/3 we can only have 2 elements atmost as the maximum element

    public List<Integer> me(int[] arr)
    {
        int curr1  = Integer.MIN_VALUE;;
        int curr2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i] == curr1)
            {
                count1++;
            }
            else if(arr[i] == curr2)
            {
                count2++;
            }
            else if(count1 == 0)
            {
                curr1 = arr[i];
                count1 = 1;
            }
            else if(count2 == 0)
            {
                curr2 = arr[i];
                count2 = 1;
            }
            else
            {
                count1--;
                count2--;
            }

        }
        List<Integer> res = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int i=0; i<arr.length; i++)
        {
            if(curr1 == arr[i]) count1++;
            if(curr2 == arr[i]) count2++;
        }
        if(count1>(arr.length/3)) res.add(count1);
        if(count2>(arr.length/3)) res.add(count2);

        return res;

        
    }

    /*
        THE INTUITION =>
        We set a candidate. And for every repetition of candidate we increment our count and for every element
        that is not our candidate we decrement our count. In this way, at the end of the array the element that has it's life as not 0 gets
        retured as the element that gets repeated more than n/2 number of times.
        But whenever at the middle of the array our count gets decremented to 0, we set the current element where our count becomes 0 as the new candidate and keep traversing
        to find whether our element gets incremented by any repetition in the array. If by the end of the array our count remains 0 then we have no elements that
        get repeated more than n/2 times

        Adding to the above intuition that was from the previous problem, now in this problem we need elements that are repeated more than N/3 times. 
        When we look at our test cases we can have at most 2 elements that can be repeated more than N/3 times.

        
        */

}