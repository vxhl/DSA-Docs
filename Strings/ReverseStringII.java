package Strings;

public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        {
            char[] s1 = s.toCharArray();
            int start = 0;
            k = k-1;
            while(start<=k)
            {
                char temp = s1[start];
                s1[start] = s1[k];
                s1[k] = temp;
                start++;
                k--;
            }
            
            return String.valueOf(s1);
        }   
    }
    public static void main(String[] args) {
        String s = "hello";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }
}
