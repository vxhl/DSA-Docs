class Solution {
    public int leastInterval(char[] tasks, int n) {
        /*
        So what do we need
        We need the count for the number of elements that are occuring a max number of times
        And we need that max
        and we need the empty slots
        and we need the idle slots
        and we need the partCounts
        and we need the cooldowns
        */
        int max = 0;
        int maxCount = 0;
        
        int[] charCount = new int[26];
        
        for(char task: tasks)
        {
            // So we increase the count
            charCount[task-'A']++;
            
            // If we find the current characters count to be equal to what we already have in our max we increment the maxCount
            if(charCount[task-'A']==max)
            {
                maxCount++;
            }
            // Otherwise if we find the current characters count to be greater than our curretn max we update our max
            else if(charCount[task-'A'] > max)
            {
                max = charCount[task-'A'];
                maxCount = 1;
            }
        }
        
        // So we have stored the number of times the max occurs in maxCount
        // And we have stored the max as well
        
        // For example if we had A ?? A ?? A -> In this case for 3 A's we have 2 groups where we can add elements
        // and the number of elements we can add to these groups depends on the cooldown that is defined
        int partCount = max-1;
        // Now we get the number of empty slots that are left to arrange
        // If we had A A A B B B C D X Y in that case we would need to store A and B first in the following way for 3 cooldwons
        // AB ?? AB ?? AB -> As we can see compared to the previous, our emptySlots decreases when the count of the eleemnts having the
        // maxCount increases so we need to take that into consideration when finding the empty slots
        int emptySlots = partCount*(n-maxCount+1);
        // So for this example: A A A B B B C D X Y we have already used up A and Bs so we have only CDXY to care about 
        int availableTasks = tasks.length - max*maxCount;
        
        int idle = Math.max(0, emptySlots-availableTasks);
        
        return tasks.length+idle;
    }
}