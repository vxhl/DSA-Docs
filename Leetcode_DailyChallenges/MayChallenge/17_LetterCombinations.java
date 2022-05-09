package Leetcode_DailyChallenges.MayChallenge;

import java.util.*;

class Letter_Combinations {
    static List<String> result = null;
    static String[] mapping = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public static List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        if (digits.length() == 0)
            return result;
        dfs(0, digits, new StringBuilder());
        return result;
    }

    public static void dfs(int length, String digits, StringBuilder temp) {
        if (length == digits.length()) {
            result.add(temp.toString());
            return;
        }
        char ch = digits.charAt(length);
        String str = mapping[ch - '0'];
        for (char c : str.toCharArray()) {
            temp.append(c);
            dfs(length + 1, digits, temp);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
