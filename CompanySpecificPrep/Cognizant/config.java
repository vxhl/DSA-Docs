import java.util.Scanner;
public class config {
    public static int configurations(int n, int x){
        // n is the number of motors we have and y is the max speed
        int k=0;
        if(2*n-1<=x){
            k=x;
            for(int i=0; i<n-1; i++){
                k*=x/(2*(1+i));
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int res = configurations(n, x);
        System.out.print("Configurations: ");
        System.out.print(res);
    }

}
