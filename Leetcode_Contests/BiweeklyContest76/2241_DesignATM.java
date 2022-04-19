package Leetcode_Contests.BiweeklyContest76;
import java.util.*;
class ATM {
	int[] nominals;
    
    long[] counts;

    public ATM() {
        nominals = new int[]{20, 50, 100, 200, 500};
        counts = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < 5; i++)
            counts[i] += banknotesCount[i];
    }

    public int[] withdraw(int amount) {
        // We need our ans array
        int[] delivery = new int[5];
        // We set a currentAmount as amount
        long currentAmount = amount;
        // We traverse in a reverse manner in the array since we need to calculate with higher value notes first
        for (int i = 4; i >= 0; i--) {
            // If our currentAmount is greater than our number of notes formed from current amount of notes with current elements in the ATM
            // we set that as the number of notes in our answer array
            if (currentAmount > nominals[i]*counts[i])
                delivery[i] = (int) counts[i];
            else
                // Otherwise we divide our amount with the note value and get the number of notes
                delivery[i] = (int) currentAmount/nominals[i];
            // we then decrement the value for our ans[i]*current notes value
            currentAmount -= (long) nominals[i]*delivery[i];
            // If our amount reaches 0 then we break
            if (currentAmount == 0)
                break;
        }
        
        // If our loop doesn't break then we return -1
        if (currentAmount > 0)
            return new int[]{-1};
        
        // Otherwise we just return the values we took from our counts array back to it by adding delivery[i] back to it
        for (int i = 0; i < 5; i++)
            counts[i] -= delivery[i];
        // then we ofc return the delivery array
        return delivery;
    }
}
/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */