/*
Problem Statement: 
Given an array of integers heights representing the histogram's bar height 
where the width of each bar is 1, return the area of the largest rectangle in the histogram

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.

*/

package Matrices;
import java.util.*;

public class MaxRectHistogram 
{
    static int largestRectangleArea(int[] hist)
    {
        int hist_size = hist.length;

        // For finding the left and right limits of the array
        int[] left = new int[hist_size];
        int[] right = new int[hist_size];
        Stack<Integer> stack = new Stack<>();

        // Finding the left limits for each element in the array
        for(int i=0; i<hist_size; i++)
        {
            if(stack.isEmpty())
            {
                left[i] = 0;
            }
            else
            {
                while(!stack.isEmpty() && hist[stack.peek()]>= hist[i])
                {
                    stack.pop();
                }
                left[i] = stack.empty() ? 0: stack.peek()+1;  
            }
            stack.push(i);
        }
        // Now that we have used the stack for the left limit we now clear it for the right par
        stack.clear();

        for(int i = hist_size-1; i>=0; i--)
        {
            if(stack.empty())
            {
                right[i]= hist_size-1;
            }
            else
            {
                while(!stack.isEmpty() && hist[stack.peek()]>=hist[i])
                {
                    stack.pop();
                }
                right[i] = stack.empty() ? hist_size-1: stack.peek()-1;
            }
            stack.push(i);
        }
        int maxArea=0;
        for(int i = 0; i<hist_size; i++)
        {
            int area = hist[i]*(right[i] - left[i] + 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;


    }
    public static void main(String[] args) {
        int[] hist = {2,1,5,6,2,3};
        System.out.print("The largest rectangle area is: ");
        System.out.println(largestRectangleArea(hist));
    }
}