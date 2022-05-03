package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class shortestUnsorted
{

  public static int findUnsortedSubarray2(int[] nums)
  {
    int start = -1;
    int end = -1;

    int i = 1;
    int j = nums.length-1;

    while(start==-1 && i<nums.length)
    {
      if(nums[i] < nums[i-1])
      {
        start = i-1;
        break;
      }
      i++;
    }
    while(end==-1 && j>0)
    {
      if(nums[j] < nums[j-1])
      {
        end = j;
        break;
      }
      j--;
    }

    return end-start+1;
    

  }






  // O(NlogN) time and O(N) space
  public int findUnsortedSubarray(int[] nums) {
    int[] sortedNums = new int[nums.length];
    for(int i=0; i<nums.length; i++)
    {
        sortedNums[i] = nums[i];
    }
    Arrays.sort(sortedNums);
    
    int i = 0;
    int j = nums.length-1;
    int start = -1;
    int end = -1;
    while(start==-1 && i<nums.length)
    {
        if(nums[i]!=sortedNums[i])
        {
            start = i;
            break;
        }
        i++;
    }
    
    
    while(end==-1 && j>=0)
    {
        if(nums[j]!=sortedNums[j])
        {
            end = j;
            break;
        }
        j--;
    }
    if(start == -1 && end == -1)
    {
        return 0;
    }
    
    return end-start+1;
}
}
