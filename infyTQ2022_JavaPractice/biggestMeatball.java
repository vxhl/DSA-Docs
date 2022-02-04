/*
Problem Statement:
Sample Input 1:
4
2
[7 8 9 3]
Sample Output 1:
3

Explanation:
The seekh or meatball queue has [7 8 9 3] this distribution. At the first serving they will cut 2 kgs of meatball from the first meatball and add it to the last of the seekh, so after 1st time it is:
[8 9 3 5]
Then, it is: [9 3 5 6],  [3 5 6 7], [5 6 7 1], [6 7 1 3], [7 1 3 4], [1 3 4 5], [3 4 5], [4 5 1], [5 1 2], [1 2 3], [2 3], [3], [1], [0]
So the last served meatball belongs to the 3rd person.
*/

package infyTQ2022_JavaPractice;
import java.util.*;

class Solution
{
    // Approach 1: Brute Force
    static int biggestMeatBall(int N, int D, int[] arr)
    {
        if(N==1)
        {
            return 1; // since 1 based indicing
        }
        //
        Queue<Integer> q = new LinkedList<>();
        // We add all the elements of our array into the queue
        for(int j: arr)
        {
            q.add(j);
        }

        // We run the while loop for as long as the last element we have remaining
        // is not equal to 0
        // If i want the index to be tracked then the most obvious answer is ofc a HashMap
        // But is using both queue and a hashmap a very effective approach? 
        int i = 0;

        while(!q.isEmpty())
        {

            i++;
            if(i==N)
            {
                i = i-N+1;
            }

            int x = q.poll();
            int readd = x-D;
            q.add(readd);
        }
        return i;
    }
}
class DriverClass
{
    public static void main(String[] args) {
        int N = 4;
        int D = 2;
        int arr[] = {7,8,9,3};
        Solution.biggestMeatBall(N,D,arr);
    }
}