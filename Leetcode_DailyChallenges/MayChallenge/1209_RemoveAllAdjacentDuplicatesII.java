package Leetcode_DailyChallenges.MayChallenge;
import java.util.*;
class Solve1209
{

    // DEEEDBBCCCBDAA
    public static String adjDupesII(String s, int k)
    {
        Deque<Character> st = new LinkedList<>();
        // We have a count array for each character? Idk 
        int[] count = new int[s.length()];
        // We have a stringBuilder for our eventual answer
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray())
        {
            sb.append(c);
            // We get the index for the last element entered
            int last = sb.length()-1;
            // Now if the previous is equal we add 1 to the previous count or instead we just do 1+0;
            count[last] = 1 + (last>0 && sb.charAt(last) == sb.charAt(last-1) ? count[last-1]:0);
            // If our count reaches beyond our threshold we delete the elements
            if(count[last]>=k) sb.delete(sb.length()-k, sb.length());
        }
        return sb.toString();
    }
}