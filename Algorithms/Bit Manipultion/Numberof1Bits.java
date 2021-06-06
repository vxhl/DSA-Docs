package Stacks;

public class dsa1TimeComplexity {
    
    public static int numSetBits(long a) {
        int setCount = 0;
        while (a!=0) {
            a &= (a-1);
            setCount++;

        }
        return setCount;
        }
    public static void main(String[] args) {
        long a = 13;
        System.out.println(numSetBits(a));
        
    }
    }

