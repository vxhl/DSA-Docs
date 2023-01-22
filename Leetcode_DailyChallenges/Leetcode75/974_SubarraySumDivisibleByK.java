class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       int[] map = new int[k];
        map[0] = 1;
        int count = 0, sum = 0;
        for(int i: nums){
            sum = (sum+i)%k;
            if(sum<0) sum+=k;
            count+=map[sum];
            map[sum]++;
        }
        return count;
    }
}
/*
Return the number of non empty subarrays that have a sum divisible by k? 

[4,5,0,-2,-3,1]
-------------------
count = 0;
map = [1,0,1,0,3]
sum = 0
map[0] = 1
-----------------
iter1:
sum = 4%5 = 4
count+=map[4] = 0
map[4] = 1
------------------
iter2:
sum = 9%5 = 4
count += map[4] = 1 // We had already encountered 4 remained before so that means we are subtracting with k
map[4] = 2
------------------
iter3:
sum = 4%0 = 4 // Again we already have 4 as remainder so our count increases again
count+=map[4] = 2
map[4] = 3
-------------------
iter4:
sum = 2%5 = 2 
count+=map[2] = 2 // Here we don't have 2 occuring again before so we don't increment count
map[2] = 1;
----------------------
iter5:
sum = -1%5 = -1
sum<0 so sum = -1 + 5 = 4
count += map[4] = 6 // once again we encounter 4 as the subarray sum remainder so we increment
map[4] = 4
----------------------
iter6:
sum = 5%5 = 0 // we again find the total sum to be 5 so we increment. 
count+=map[0] = 7
map[0] = 2
--------------------------

return 
*/