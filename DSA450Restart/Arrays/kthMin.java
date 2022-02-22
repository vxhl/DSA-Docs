package DSA450Restart.Arrays;
import java.util.*;

public class kthMin {
    
    // We need to find the kth smallest element
    public static int kthMinUtil(int arr[], int k)
    {
        Stack<Integer> st = new Stack<>();

        // convert arr to arraylist
        List<Integer> res = new ArrayList<>();
        for(int i: arr)
        {
            res.add(i);
        }
        while(k>0)
        {
            int min = res.get(0);
            for(int i=0; i<res.size(); i++)
            {
                if(res.get(i)<min)
                {
                    min = res.get(i);
                }
            }
            res.remove(new Integer(min));
            // At the end of the loop we add that min into the stack
            st.push(min);
            // and remove it from the res arraylist
            
            k--;
        }
        return st.pop();
        
    }

    // Approach 2: Quick Select Algorithm with O(N) average time. 
    // We do the partition funciton for this
    // Also this is similar to the quick sort algorithm apparently
    // If we want the smaller element we traverse the left side of pivot otherwise the right side

    // Let's try implementing it from logic

    // first the partition function
    public static int partition(int[] arr, int high, int low)
    {

        int pivot = arr[high];
        int pivotloc = low;
        for(int i=low; i<=high; i++)
        {
            // We insert the elements having values smaller than our pivot to the left
            if(arr[i]>pivot)
            {
                int temp =arr[i];
                arr[i] = arr[pivotloc];
                arr[pivotloc] = temp;
                pivotloc++;
            }
        }
        int temp = arr[high];
        arr[high] = arr[pivotloc];
        arr[pivotloc] = temp;
        return pivotloc;

    }
    public static void swap(int a, int b)
    {
        int temp = a;
        a=b;
        b = temp;
    }
    public static void main(String[] args) {
        int[] arr = {7,10,4,20,15};
        System.out.println(partition(arr, arr.length-1, 0));
        //System.out.print(kthMinUtil(arr, 2));
    }
}
