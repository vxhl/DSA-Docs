package DSA450Restart.Arrays;
import java.util.*;
public class FactorialLargeNumbers {
    // For larger numbers factorial will cross the even 64 bit values
    // and thus cannot be returned as simple primitive values

    // For this purpose we will be using the Java BigInteger class 
    // BigInteger has no cap on it's maximum size as long as we don't run out of memory

    // Now what we need to return is an ArrayList<Integer> as the output
    // But as we have seen we will be using BigInteger class which cannot be stored
    // in the arraylist
    // So instead we store each individual digit from the result we get in 
    // BigInteger into our ArrayList

    public static ArrayList<Integer> FLN(int N)
    {
        ArrayList<Integer> res = new ArrayList<>();

        java.math.BigInteger F;
        F = java.math.BigInteger.valueOf(1);

        // We just use our standard algorithm for getting the factorial of the number first
        for(int i=2; i<=N; i++)
        {
            F = F.multiply(java.math.BigInteger.valueOf(i));
        }

        // Now comes the part where we take a digit one by one and add into our
        // res arraylist

        String value = F.toString();
        char[] valueArray = value.toCharArray();

        for(int i=0; i<valueArray.length; i++)
        {
            int k = Integer.parseInt(String.valueOf(valueArray[i]));
            res.add(k);
        }

        return res;
    }

    public static void main(String[] args) {
        int N = 5;
        for(int i=0; i<FLN(N).size(); i++)
        {
            System.out.print(FLN(N).get(i));
        }
    }
}
