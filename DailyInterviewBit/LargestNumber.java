// Problem Statement : Find the largest number that can be formed using the elements
// of the given array
// Time complexity : O(NlogN)
// Logic : I guess this is more language specific since i used the comparator
// interface to manipulate the sorting mech
package DailyInterviewBit;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
    public static String largestNumber(int[] A) 
    {
        if(A.length == 0)
        {
            return "";
        }
        String[] sa = new String[A.length];
        for(int i=0; i<A.length; i++)
        {
            sa[i] = Integer.toString(A[i]);
        }
        Arrays.sort(sa, new Comparator<String>(){
            public int compare(String a, String b)
            {
                String o1 = a+b;
                String o2 = b+a;
                
            return o2.compareTo(o1);
            }
        });
        if(sa[0].equals("0"))
        {
            return "s";
        }
        StringBuilder sb = new StringBuilder();
        for(String s:sa)
        {
            sb.append(s);
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        int[] arr = {1,55,66,77,999};
        System.out.println(largestNumber(arr));


    }
}
