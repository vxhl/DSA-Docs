package Leetcode_DailyChallenges.AprilChalleges;
import java.util.*;


class Solution_682
{

    // Not as fast but intuitive
    public int calPoints(String[] ops) {
        Deque<Integer> rec = new ArrayDeque<>();
            
        for(int i=0; i<ops.length; i++)
        {
            if(ops[i].equals("C"))
            {
                rec.pop();
            }
            else if(ops[i].equals("D"))
            {
                rec.push(rec.peek()*2);
            }
            else if(ops[i].equals("+"))
            {
                int k1 = rec.peek();
                rec.pop();
                int k2 = rec.peek();
                rec.push(k1);
                rec.push(k1+k2);
            }
            else 
            {
                rec.push(Integer.parseInt(ops[i]));
        
            }
        }
        
        int ans = 0;
        while(!rec.isEmpty())
        {
            ans+=rec.pop();
        }    
        return ans;
    }
    // Fastest solution using linkedlists
    public int calPoints2(String[] ops) {
        LinkedList<Integer> list = new LinkedList<>();
         int sum = 0;
         for(var op : ops){
             switch (op){
                 case "C":{
                     sum -= list.removeLast();
                     //list.removeLast();
                     break;
                 }
                 case "D":{
                     int item = list.getLast();
                     list.addLast(item*2);
                     sum+=item*2;
                     break;
                 }
                 case "+":{
                     int value = list.get(list.size()-2)+list.getLast();
                     list.addLast(value);
                     sum+=value;
                     break;
                 }
                 default:{
                     list.addLast(Integer.parseInt(op));
                     sum+=Integer.parseInt(op);
                     break;
                 }
             }
         }
         return sum;
     }

}