package DSA450Restart.Arrays;
import java.util.*;
class SolutionLeetcode11
{
    /*
    We could just take two pointer one for the left and one for the right

    We have another array that contains the area for each index traversed
    
    Let's take an example

    1 5 6 3 8

    Initially we are at left-> 1 and right->8
    we calculate the area and find it as right-left+1*arr[left] if left is smaller and vice versa
    We then move the smaller pointer forward/backward depending on the situation and again calculate the area for the two pointers depending on which one is smaller
    */

    public static int containerMostWater(int[] arr)
    {
        int n = arr.length;
        int left = 0;
        int right = arr.length-1;
        ArrayList<Integer> areaMax = new ArrayList<>();
        while(left<=right)
        {
            if(arr[left]<=arr[right])
            {
                areaMax.add(arr[left]*(right-left));
                left++;
            }
            else{
                areaMax.add(arr[right]*(right-left));
                right--;
            
            }
        }

        int max = 0;

        for(int i=0; i<areaMax.size(); i++)
        {
            if(areaMax.get(i)>max)
            {
                max = areaMax.get(i);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        int[] arr1 = {1,1};
        System.out.print(containerMostWater(arr));
        System.out.println(containerMostWater(arr1));
    }
}