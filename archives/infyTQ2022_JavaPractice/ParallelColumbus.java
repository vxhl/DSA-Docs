/*
Input Format:

The first line contains an integer, n, denoting the number of rows in the grid.
The next line contains an integer m, denoting the number of columns in the grid.
The next line contains an integer, x, denoting the American cell’s row.
The next line contains an integer, y, denoting the American cell’s column.

Sample Input 1:
2
2
2
1
Sample Output 1:
1

Explanation:
The only way possible is (1,1) ->(2,1) -> (2,2), so the answer is 1. 
*/

package infyTQ2022_JavaPractice;
import java.util.*;
class Main 
{
    static int f[] = new int[1000];
    static int Fact(int n)
    {
        if(f[n]==1) return f[n];
        return f[n] = n*Fact(n-1);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        n-=1;
        m-=1;
        x-=1;
        y-=1;

        f[0]=f[1]=1;
        int p=(Fact(m+n)/(Fact(m)*Fact(n)));
        int imp=((Fact(x+y)/(Fact(x)*Fact(y)))*(Fact(m-x+n-y)/(Fact(m-x)*Fact(n-y))));

        System.out.println(p-imp);

    }

}