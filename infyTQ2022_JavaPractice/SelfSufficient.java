/*
Problem Statement:
N -> How many books he has to buy that day
EarnArray[] -> Array of his earnings for the ith book
CostArray[] -> Array of the actual cost of the ith book

Sample Input 1:
3
[3 4 2]
[5 3 4]

Sample Output 1:
3

Explanation -> 
At first he buys the 2nd book which costs 3 so he saves 1.
Then he buys the fist book that take 2 rupees more. So he spends his stored 1 rupee and hence he
needs 1 rupee more. Than he buys the last book. 
*/

package infyTQ2022_JavaPractice;
import java.util.*;
public class SelfSufficient {
    static int selfsuff(int N, int[] ea, int[] ca)
    {
        int res = 0;
        for(int i=0; i<N; i++)
        {
            res += (ea[i] - ca[i]);
        }
        return Math.abs(res);
    }
    public static void main(String[] args) {
        int N = 3;
        int[] ea ={ 3,4,2};
        int[] ca = {5,3,4};
        System.out.println(selfsuff(N, ea, ca));
    }
}
