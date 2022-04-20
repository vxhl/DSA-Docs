package Leetcode_Contests.WeeklyContest289;
import java.util.*;

class Solution {
    
    public static String digitSum(String s, int k) {
        
        while(s.length()>k)
        {
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<s.length(); i+=k)
            {
                String ns = s.substring(i, Math.min(i+k, s.length()));
                int count = 0;
                for(int j=0;j<ns.length(); j++)
                {
                    count += Character.getNumericValue(ns.charAt(j));
                }
                sb.append(Integer.toString(count));
            }
            s = sb.toString();
        }

        return s;
    }


    public static void main(String[] args) {
        String s = "11111222223";
        int k = 3;
        for(int i=0; i<digitSum(s, k).length(); i++)
        {
            System.out.print(digitSum(s, k).charAt(i)+ " ");
        }
    }
}