package DSA450Restart.SearchingSorting;


class Pair
{
    int first;
    int second;
    public Pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Sol_MaxMin
{

    public static Pair MaxMin(int[] arr)
    {
        Pair p = new Pair(Integer.MAX_VALUE, 0 );
        for(int i=0; i<arr.length; i++)
        {
            Pair x;
            if(arr[i]>p.second)
            {
                p.second = arr[i];
            }
            else if(arr[i]<p.first)
            {
                p.first = arr[i];
            }
        }

        return p;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,56,1000,167};

        System.out.print(MaxMin(arr).first + " " + MaxMin(arr).second);
    }

}