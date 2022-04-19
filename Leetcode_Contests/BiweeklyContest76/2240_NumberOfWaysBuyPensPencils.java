package Leetcode_Contests.BiweeklyContest76;

class Solution_PenPencils
{
    /*
        We have a total amount that we can have. Let us take it is 20
        we have cost1 for the first entity and cost2 for the other
        we are to find the total number of ways we can pick or not pick entities

        My takeway -> I was going too deep into this, the solution was very simple, but i went all the way in to understand it as a dp
        knapsack problem lmao, so fucked this one up. Anyway the solution is pretty self explanantory 

    */

    public static int ways(int total, int cost1, int cost2)
    {
        int ans = 0;
        for(int i=0; i<total; i+=cost1)
        {
            // Basically if we already bought cost2 then we have total-cost1/cost2 times to buy the other item. We do +1 for the picking nothing case
            ans +=(total - i)/cost2 + 1; 
        }
        return ans;
    }
}