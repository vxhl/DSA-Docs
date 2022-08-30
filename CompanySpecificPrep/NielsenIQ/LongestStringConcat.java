import java.util.*;
class Solution_Neil{
    
    /*
    We are to return a string S, 
    It should be a concatendation of some strings from ARR
    such that ->
        Condition: Every Letter is the resultant string should be different

    StringStrBishal X 
    StringBishal X

    String[] arr = {"String", "RMZ", "Bishal", "Interviewer", "NielsenIQ"}
    Input: strings[] arr = { ”abcd”, “efgh”, “efgh” }
    Output: 8
    Explanation: 
        All possible combinations are {“”, “abcd”, “efgh”, “abcdefgh”}. 
    Therefore, maximum length possible is 8.

    First picking one string or the other is easy, but including one string, needs to pass  some conditions like
    If the string we have already formed, does not contain any characters from the current string
    or we can use a vis[26] array that increments everytime we put in strings with the particular value
    Also need to make sure that the current string does not have any duplicate letters
    So maybe we can use a hashset for that

    Input: strings = “123467890” 
    Output: 10
    Explanation: 
        All possible combinations are: “”, “1234567890”. 
    Therefore, the maximum length possible is 10. 
*/
    public int Longest_Concatenated_UniqueString(String[] arr){
        if(arr.length==0){
            return 0;
        }
        int max = 0;
        Set<Character> vis = new HashSet<>(); 
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return helper(0, arr,vis,dp);

    } 

    private int helper(int ind, String[] arr,Set<Character> vis,int[]dp){
        if(ind==arr.length){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int include = 0;
        int exclude = 0;
        boolean flag = false;
        // First this is the condition
        
        // For checking whether the current strings characters have already occured
        for(char c: arr[ind].toCharArray()){    
            if(vis.contains(c)){
                flag = true;
                break;
            }
        }
        // For checking the current string
        int[] vis1 = new int[26];
        for(char c: arr[ind].toCharArray()){
            if(vis1[c-'a']!=0) {
                flag = true; 
                break;
            }
            vis1[c-'a'] = 1;
        }

        if(!flag){
            for(char c: arr[ind].toCharArray()){
                if(!vis.contains(c)){
                    vis.add(c);
                }
            }
            include = arr[ind].length() + helper(ind+1,arr,vis,dp);
        }
        exclude = helper(ind+1, arr, vis,dp);

        return dp[ind]=Math.max(include, exclude);
    }

    public static void main(String[] args) {
        Solution_Neil obj1 = new Solution_Neil();
        String[] arr = {"abcd", "efgh", "efgh" };
        System.out.println(obj1.Longest_Concatenated_UniqueString(arr));
    }


}