import java.util.PriorityQueue;
public class SecondLargestElement {
    
    public int SecondLargestElement1(int[] arr){
        int max = Integer.MIN_VALUE;
        int prev = 0;
        for(int i: arr){
            if(i>max){
                prev = max;
                max = i;
            }
        }
        return prev;
    }
    public static void main(String[] args) {
        int[] arr = {1,6,7,10,11};
        SecondLargestElement obj1 = new SecondLargestElement();
        System.out.print(obj1.SecondLargestElement1(arr));
    }
}
