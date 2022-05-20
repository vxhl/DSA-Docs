package DSA450Restart.SearchingSorting;

class SearchingWhereAdjacentDifferAtmostk {
    public static int search (int arr[], int n, int x, int k) {
        //Complete the function
        int i=0;
        while(i<n)
        {
            if(arr[i]==x)
            {
                return i;
            }
            else if(arr[i]!=x && x>arr[i]+k)
            {
                System.out.print("executes");
                i+=2;
            }
            else
            {
                i+=1;
            }
        }
        
        return -1;
    }
}
