package DSA450Restart.Arrays;


class Pair
    {
        long first, second;
        public Pair(long first, long second)
        {
            this.first = first;
            this.second = second;
        }
    }

public class MinMaxElement {
    
    static Pair getMinMax(long a[], long n)  
    {
        long min = a[0];
        long max = 0;
        
        for(int i=0; i<a.length; i++)
        {
            if(a[i]<min) 
            {
                min = a[i];
            }
            if(a[i]>max)
            {
                max = a[i];
            }
        }
        
        Pair p = new Pair(min, max);
        return p;
    }
    
}
