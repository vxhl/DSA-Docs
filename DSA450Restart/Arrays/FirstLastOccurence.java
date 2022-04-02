package DSA450Restart.Arrays;
import java.util.*;
public class FirstLastOccurence {
    /*
    Not really in the mood to write by hand
    let's take our example ->
        2,4,10,10,10,18,20
i->     0,1,2,3,4,5,6,7
    Here as well we do the same search for the element x = 10 but instead we do not return the position of it right away
    We instead check if the element at mid-1 is smaller than mid if it is then we add mid to our arraylist
    what about the last occurence
    Ok let's see how our split will take place
    2,4,10,10,10,18,20
    After we find our element at mid then we check on both left and right sides and traverse them to find more occurences of 10
    For example - After we find 10 here we set our first occurence initially as that and then we traverse to see on the mid-1 if there are more 10s and
    respecitvely we do the same for mid+1. Let's see this will probably make more sense while implementing        
    Looking at the worst case we have

    10,10,10,10,10
*/
public static ArrayList<Integer> firstLast(int[] arr, int k)
{
    int left = 0;
    int right = arr.length-1;
    int first = -1;
    int last =-1;
    while(left<=right)
    {
        int mid = left+(right-left)/2;
        // We first write our primary condition then we will do for the standard binary cases
        if(arr[mid] == k)
        {
            first = mid;
            // The thing is we need to do both sides for find the first and the last
            // So the question is how to implement that? 
            right = mid-1;  
        }
        else if(arr[mid]>k)
        {
            right = mid-1;
        }
        else if(arr[mid]<k)
        {
            left = mid+1;
        }
    }
    left = 0;
    right = arr.length-1;
    while(left<=right)
    {
        int mid = left+(right-left)/2;
        // We first write our primary condition then we will do for the standard binary cases
        if(arr[mid] == k)
        {
            last = mid;
            // The thing is we need to do both sides for find the first and the last
            // So the question is how to implement that? 
            left = mid+1;  
        }
        else if(arr[mid]>k)
        {
            right = mid-1;
        }
        else if(arr[mid]<k)
        {
            left = mid+1;
        }
    }
    ArrayList<Integer> ans = new ArrayList<>();
    ans.add(first);
    ans.add(last);

    return ans;
}

public static void main(String[] args) {
    int[] arr = {1,1,10,10,10,10,20};
    int k = 10;
    for(int i=0; i<firstLast(arr, k).size(); i++)
    {
        System.out.print(firstLast(arr, k).get(i)+ " ");
    }
}
}
