package Leetcode_DailyChallenges.MayChallenge;

class NumberOfStepsReduceNumber0 {
    public int numberOfSteps(int num) {
        int count = 0;
        while(num!=0) 
        {
            if(num%2==0) // (num&1!=1)
            {
                num/=2; // num = num>>1;
            }
            else
            {
                num-=1;
            }
            count++;
        }
        return count;
    }
}
