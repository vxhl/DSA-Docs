import java.util.*;
class MinSwapsSort {
    //Function to find the minimum number of swaps required to sort the array.
    static class Pair
    {
        int value;
        int index;
        Pair(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }
    
    public int minSwaps(int nums[])
    {
        Pair[] newArr = new Pair[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            newArr[i] = new Pair(nums[i], i);
        }
        
        Arrays.sort(newArr, (a,b)->a.value-b.value);
        int ans = 0;
        for(int i=0; i<newArr.length; i++)
        {
            // System.out.print(newArr[i].value + " " + newArr[i].index + "  ");
            Pair p = newArr[i];
            int val = p.value;
            int ind = p.index;
            if(ind != i)
            {   
                ans++;
                Pair temp = newArr[i];
                newArr[i] = newArr[ind];
                newArr[ind] = temp;
                // THe key here is i--, since after we swap we may or may not have the position with
                // the correct value of index, so we check it once again and keep checking until we 
                // find the positions index to be same as the index in our pair, only when it is equal do we move forward
                i--;
            }
        }
        return ans;
        
    }
}
