package DSA450Restart.Arrays;
import java.util.*;

public class LongestConsecutiveSubsequence {
    // Sorting this will ofc be the easiest solution
    // We can spend O(N) auxiliary spcae tho
    public static int findLConseqSeq(int[] nums)
    {
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        
        for(int i: nums)
        {
            if(!mp.containsKey(i))
            { mp.put(i, 1); }
            else
            {
                mp.put(i, mp.get(i)+1);
            }
            
        }
        
        int max = 0;
        for(int i=0; i<nums.length; i++)
        {
            int count = 1;
            
            if(!mp.containsKey(nums[i]-1))
            {
                while(mp.containsKey(nums[i]+1))
                {
                    count++;
                    nums[i] = nums[i]+1;
                }
            }
            else
            {
                continue;
            }
            
            if(count>max)
            {
                max = count;
            }
        }
        
        return max;
        

    }
    public static void main(String[] args) {
        int[] arr = {8,8,9,9,3,4};

        System.out.println(findLConseqSeq(arr));


    }
}
