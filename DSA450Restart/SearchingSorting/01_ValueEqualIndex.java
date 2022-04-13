package DSA450Restart.SearchingSorting;
import java.util.*;
class Sol_ValueEqualIndex {
    ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<n-1; i++)
        {
            if(arr[i] == i+1)
            {
                res.add(arr[i]);
            }
        }
        if(arr[n-1] == n)
        {
            res.add(arr[n-1]);
        }
        
        return res;
    }
}
