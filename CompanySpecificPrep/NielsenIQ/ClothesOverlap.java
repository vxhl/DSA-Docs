import java.util.*;
class ClothesOverlap1{
    /*
     * 
     * So we are given two integers first of all
     * N = 10
     * N = 5 
     * - > 0,4 6,3 1,5 6,4 7,2
     * 0 6 1 6 4 7 are index

    0 1 6 6 7
    4 5 3 4 2

    0 1 2 3 4 5 6 7 8 9 10
0    |-------|
   (0)       4
1               |-----|        we check if the order of placing 6 has already been visited, if it has been visited then we don't increment the counter
               (6)    9
2      |---------|
     (1)        6
3                |--------|    when we visit this, we find  that we have not visited the 3rd index before, so we increment
               (6)       10
4                  |---|       when we reach here we again increment since we had not visited the 4th index before
                 (7)  9

+1 + 1 + 1 + 1
    From the front we see
    0,1 visible but how? 

    because we don't see anything else overlapping it. If we had something over there already at let's say
    2nd index was 0,10 then we couldn't see this cloth,
    So check in the MAP if something is already placed in this range first

    0,4  | 0
    6,9 | 1
    1,5 | 2
    6,10 | 3
    7,9 | 4

    Now let's say we loop over each interval after sorting them
    if we are at 0, we check whether, there are other interval
    How do we preverse the indexes? 

    0,1 -> 0
    6,3 -> 1
    Here we get 5 as the answer if we do it,     
We are suppsoed to find the number of clothes that can be viewed from the front? 
*/


    public int sol(int[][] arr, int line, int clothes){
        // We first put them all into a map
        Map<int[], Integer> mp = new HashMap<>();
        int i=0;
        for(int[] x: arr){
            mp.put(x,i);
            i++;
        }
        // Now let's sort
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        // for(int[] i: arr){
        //     for(int x: i){
        //         System.out.print(x);
        //     }

        //     System.out.print(" ");
        // }
        int count = 0;
        // return 0;
        // Now let us traverse the array
        int[] vis = new int[5];
        for(int k=0; k<clothes;k++){
            if(vis[mp.get(arr[k])]==0){
                vis[mp.get(arr[k])]=1;
                count++;
            }   
            System.out.println("loop");
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,4},{6,3},{1,5},{6,4},{7,2}};
        int line = 10;
        int clothes = 5;
        System.out.println("The number of clothes visible");
        ClothesOverlap1 obj1 = new ClothesOverlap1();
        System.out.print(obj1.sol(arr, line, clothes));
    }
}
