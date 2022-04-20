package Leetcode_Contests.WeeklyContest289;
import java.util.*;
class Solution2
{
    public static int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<tasks.length; i++)
        {
            if(!mp.containsKey(tasks[i]))
            {
                mp.put(tasks[i], 1);
            }
            else
            {
                mp.put(tasks[i], mp.get(tasks[i])+1);
            }
        }
        
        if(mp.containsValue(1))
        {
            return -1;
        }
        int round = 0;
        for(Map.Entry mapElement: mp.entrySet())
        {
            if((int)mapElement.getValue()==2 || (int)mapElement.getValue()==3)
            {
                round+=1;
            }
            if((int)mapElement.getValue()>3)
            {
                if(((int)mapElement.getValue()%3)==0)
                {
                    round+= (int)mapElement.getValue()/3;
                }
                else if(((int)mapElement.getValue()%3)==1)
                {
                    round+= (int)(mapElement.getValue())/3 + (int)(mapElement.getValue())%3;
                }
                else
                {
                    round += (int)(mapElement.getValue())/3+1;
                }
            }
        }
        return round;
            
    }
    public static void main(String[] args) {
        int[] arr = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(arr));
    }
}