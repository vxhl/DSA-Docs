package Strings;

public class BalancedStrings {


    public static int balanced_strings(String s)
    {
        int c = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == 'R')
                c++;
            else
                c--;
            if(c == 0)
            {
                res++;
            }

        }
        return res;
    }
    // Compact syntax
    public static int balanced_strings2(String s)
    {
        int cnt = 0;
        int res = 0;
        for(int i=0; i<s.length(); i++)
        {
            cnt+=s.charAt(i)=='L'?1:-1;
            if(cnt==0) res+=1;
            
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "RLRRLLRLRL";
        System.out.println(balanced_strings(s));
    }
}
