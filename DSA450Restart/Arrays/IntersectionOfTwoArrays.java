package DSA450Restart.Arrays;
import java.util.*;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> res= new ArrayList<>();
        for(int i: nums1)
        {
            for(int j: nums2)
            {
                if(i == j)
                {
                    if(!res.contains(i))
                        res.add(i);
                }
            }
        }
        
        int[] arr = new int[res.size()];
        
        for(int i=0; i<res.size(); i++)
            arr[i] = res.get(i);
        return arr;
    
    }
}
