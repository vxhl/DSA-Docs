package Arrays;

public class MajorityElementsI {
    public int majorityElement(int[] arr) 
    {
        // We set our current element and it's life as 0
        int cand = Integer.MIN_VALUE; 
        int count = 0;
        
        for(int i=0; i<arr.length; i++)
        {
            // We check whether our curr element is same
            // as our candidate
            // if it is then ofc we increase our count.
            if(arr[i] == cand)
            {
                count++;
            }

            // When our count is 0 or the life becomes 0
            // We set our candidate as then current element
            else if(count == 0)
            {
                cand = arr[i];
            }
            else
            {
                // Whenever we find that our current element is not the same as our present
                // candidate then we reduce our count.
                count--;
            }
        }

        // The intuition
        /*
        We set a candidate. And for every repetition of candidate we increment our count and for every element
        that is not our candidate we decrement our count. In this way, at the end of the array the element that has it's life as not 0 gets
        retured as the element that gets repeated more than n/2 number of times.
        But whenever at the middle of the array our count gets decremented to 0, we set the current element where our count becomes 0 as the new candidate and keep traversing
        to find whether our element gets incremented by any repetition in the array. If by the end of the array our count remains 0 then we have no elements that
        get repeated more than n/2 times
        */
        
        return cand;
    }
}
