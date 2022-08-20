public class CountGreaterLeft {
    // Function to get the count of greater
// elements on left of each array element
static void countGreater(int arr[], int N)
{
     
    // Store distinct array
    // elements in sorted order
    Set<Integer> St = new TreeSet<>();
   
    // Stores the count of greater
    // elements on the left side
    int[] countLeftGreater = new int[N];
   
    // Traverse the array
    for(int i = 0; i < N; i++)
    {
         
        // Insert array elements
        // into the set
        St.add(arr[i]);
   
        int it = 0;
         
        // Find previous greater element
        Iterator<Integer> iterator = St.iterator();
        while (iterator.hasNext())
        {
           if (arr[i] < iterator.next())
           {
               break;
           }
           it++;
        }
   
        // Find the distance between the
        // previous greater element of arr[i]
        // and last element of the set
        countLeftGreater[i] = Math.abs(it - St.size());
    }
}    
}
