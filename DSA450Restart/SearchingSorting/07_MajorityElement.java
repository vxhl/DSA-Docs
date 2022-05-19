package DSA450Restart.SearchingSorting;

class MajorityElement {
    static int majorityElement(int arr[], int size)
    {
        // your code here
        int life = 0;
        int curr = 0;
        for(int num: arr)
        {
            if(life == 0)
            {
                curr = num;
            }
            if(num==curr)
            {
                life++;
            }
            else
            {
                life--;
            }
        }
        if(isMajority(curr, arr))
        {
            return curr;
        }
        return -1;
    }
    
    static boolean isMajority(int curr, int arr[])
    {
        int count = 0;
        for(int n: arr)
        {
            if(n == curr)
            {
                count++;
            }
        }
        if(count>arr.length/2)
        {
            return true;
        }
        
        return false;
    }
}
