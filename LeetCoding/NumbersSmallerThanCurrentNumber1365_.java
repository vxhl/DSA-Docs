/* Problem Statement: 
Given the array nums, for each nums[i] find out how many numbers 
in the array are smaller than it. That is, for each nums[i] you 
have to count the number of valid j's such that j != i and nums[j] < nums[i].

*/

package LeetCoding;

public class NumbersSmallerThanCurrentNumber1365_
{
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int l = nums.length;
        int count = 0;
        int res[] = new int[l];
        for (int i=0; i<l; i++)
        {
            for(int j=0; j<l; j++)
            {
                if(nums[j]<nums[i])
                {
                    count+=1;
                }
            }
            res[i] = count;
            count = 0;
        }
        return res;      
    }
    public static void main(String[] args) {
        int[] nums = {8,1,2,2,3};
        System.out.print(smallerNumbersThanCurrent(nums));
    }
}
