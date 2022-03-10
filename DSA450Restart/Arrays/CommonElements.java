package DSA450Restart.Arrays;
import java.util.*;

public class CommonElements {
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        // code here
        int i=0; int j=0; int k = 0;
        HashSet<Integer> res1 = new HashSet<>();
        ArrayList<Integer> res = new ArrayList<>();
        while(i<n1 && j<n2 && k<n3)
        {
            if(A[i] == B[j] && B[j] == C[k])
            {
                
                res1.add(A[i]);
                i++;
                j++;
                k++;
            }
            else if(A[i]<B[j])
            {
                i++;
            }
            else if(B[j] < C[k])
            {
                j++;
            }
            else
            {
                k++;
            }
            
        }
        for(int x: res1)
        {
            res.add(x);
        }
        Collections.sort(res);
        
        return res;
    }
}
