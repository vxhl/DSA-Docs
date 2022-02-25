package DSA450Restart.Arrays;

public class MinJumpsEnd {
    // Literally a differnet question
    public static int minJumps(int[] arr)
    {
        
        int jumps = 0;
        if(arr[0]<=0) return -1;
        int pos = 0;
        while(true)
        {
            if(arr[pos]>0)
            {
                jumps+=1;
                pos+=arr[pos];
               //  pos = pos - 1;
                if(pos>=arr.length-1) break;
                
            }
            else
            {
                return -1;
            }
        }
        return jumps;

    }


    // O(N) approach
    public static int minJumps_sol(int[] arr)
    {
        // First of all we intialise our values for the first element
        // These are of course only possible if our first element is not 0 
        int reach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        if(arr[0] == 0) return -1;
        if(arr.length==1) return 0; // since there are no jumps to be made

        // Now we define our actual conditions

        // We traverse from our 2nd element
        for(int pos=1; pos<arr.length; pos++)
        {
            // If our pos reach arr.length-1 we have reached the end of our array
            if(pos == arr.length-1)
                return jumps;
            // We increment our current reach and compare with previous reach
            // whether it is greater. If it is then we reset our reach
            reach = Math.max(reach, pos+arr[pos]);
            // everytime we do we decrement our steps
            steps--; 
            if(steps==0)
            {
                // If our steps count as 0 we increment our jump
                jumps+=1;

                // We check if our position moves forward and our steps becomes 0
                // after we pass our reach
                // Basically if at any place we find 0
                if(pos>=reach) return -1; 
                // And then we set our steps as the current reach.
                steps = reach - pos;
            }

        }
        return jumps;
        
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr1 = {1, 4, 3, 2, 6, 7};
        int[] arr2 = {2,3,1,1,2,4,2,0,1,1};
        System.out.println(minJumps_sol(arr2));
    }
}
