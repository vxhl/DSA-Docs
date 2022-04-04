package DSA450Restart.Strings;

class Solution {
    public static boolean rotationCheck(String s, String goal)
    {
        if(s.length() != goal.length()) return false;
        return (s+s).contains(goal);
    }
}
