class Solution {
    /*
    We are to compute the water it can trap after raining? 
    
        0 1 0 2 1 0 1 3 2 1 2 1
        
        Case 0: 
        We have 1 as the near greater to left and 3 as nearest greater to right
        1 0 3 
        In this case we can store let's say 1 amount of water here since that is smaller out of the two values
        Our water storage is calculated as -> Math.min(ngl(i),ngr(i))-arr[i] -> 1-0 = 1
        Case 1: 
        2 1 0 1 3
        at the first 1 we can store Math.min(2,3)-arr[i] => 2-1 = 1
        at the 0 we can store Math.min(2,3)-arr[i]=> 2
        at the second 1 we can store Math.min(2,3)-1 => 1
        So that's how we calculate fine
        
    */
    
    private int FG(int[] arr, int start, int end){
        int max = 0;
        for(int i=start; i<end; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    public int trap(int[] arr) {
        int n = arr.length;
        int[] fgl = new int[n];
        int[] fgr = new int[n];
        fgl[0]=arr[0];
        fgr[n-1]=arr[n-1];
        for(int i=1; i<n; i++){
            fgl[i]=Math.max(fgl[i-1],arr[i]);
        }
        for(int i=arr.length-2; i>=0; i--){
            fgr[i] = Math.max(fgr[i+1], arr[i]);
        }
        
        int water = 0;
        for(int i=0; i<arr.length; i++){
            int count = Math.min(fgl[i],fgr[i])-arr[i];
            if(count>0){
                water+=count;
            }
        }
        for(int i=0; i<n; i++){
            System.out.print(fgr[i]+" ");
        }
        return water;
        
    }
}