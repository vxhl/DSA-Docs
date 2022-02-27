package DSA450Restart.Arrays;

public class DuplicateZeroes {

    public static int[] dupzero(int[] arr)
    {   

        // What if before setting our element as 0 we store the overrided element and then add it later? 
        int temp = 0;
        int zeroes = 0;
        for(int i: arr) if(i==0) zeroes+=1;

        for(int i = arr.length-1; i>0; i--)
        {
            if(arr[i] == 0)
            {
                temp = arr[i-1];
                arr[i-1] = 0;
            }
            else
            {
                arr[i] = temp;
            }
        }
        return arr;


        // We have now found the number of zeroes. So we add it to the resultant array but that doesn't make sense since it is actually not dynamic

        
    }
    public static void main(String[] args) {
        int[] arr = {1,0,2,3};
        int[] arr1 = {1,0,2,3,0,4,5,0};
        for(int i: dupzero(arr1))
        {
            System.out.println(i+" " );
        }
    }
}
