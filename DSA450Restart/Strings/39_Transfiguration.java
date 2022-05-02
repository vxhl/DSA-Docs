package DSA450Restart.Strings;

import java.util.HashSet;
import java.util.Set;

import Arrays.rotate;

class Solution_transfiguration
{
    public static int transfigure (String A, String B)
    {
        if(A.length()!=B.length())
        {
            return -1;
        }
        int ans = 0;
        int i = 0;
        boolean flag = false;
        while(i<A.length()-1)
        {
            
            if(A.charAt(i) == B.charAt(0))
            {
                while(A.charAt(i) == B.charAt(ans))
                {
                    flag = true;
                    i++;
                    ans++;
                }
            }
            if(flag == true)
            {
                break;
            }
            i++;
        }
        return ans;

    }

    public static void rotate(String A, int i, int j)
    {
        char c = A.charAt(j);
        char[] arr = A.toCharArray();
        for(int k = j; k>0; k--)
        {
            System.out.println("rotated");
            arr[k] = arr[k-1];
        }
        arr[i] = c;
        A = String.valueOf(arr);

    }
    public static int trans(String A, String B)
    {
        // Let's say we traverse both strings from the back and get the point of mismatch
        int i = A.length()-1;
        int j = B.length()-1;
        if(A.length()!=B.length())
        {
            return -1;
        }
        Set<Character> setA = new HashSet<>();
        for(int k=0; k<A.length(); k++){
            setA.add(A.charAt(k));
        }
        Set<Character> setB = new HashSet<>();
        for(int k=0; k<B.length(); k++){
            setB.add(B.charAt(k));
        }   

        if(!setA.equals(setB))
        {
            return -1;
        }
        int count = 0;
        while(i>=0 && j>=0)
        {
            if(A.charAt(i) == B.charAt(j))
            {i--;
            j--;}
            else
            {
                while(i>=0 && A.charAt(i)!=B.charAt(j))
                {
                    i--;
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String A = "geeksforgeeks";
        String B = "forgeeksgeeks";
        System.out.println(trans(A, B));

    }
}