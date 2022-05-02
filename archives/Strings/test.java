package Strings;

public class test {
    public static void main(String[] args) {
        int n=5;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (j==1||i==1||i==n/2+1){
                    System.out.print("* ");
                }}
            System.out.println();
        }int m=5;
        System.out.println();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (j==1||j==n||i==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }}
            System.out.println();
        }System.out.println();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (i==1||i==n||j==1){
                    System.out.print("*");
                }}
            System.out.println();
        }System.out.println();
        int x=n/2+1;
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n/2+1;j++){
               if (j==1||j==x){
                   System.out.print("* ");
               }else{
                   System.out.print(" ");
               }}
            if(i<=n/2){x--;
            }else{x++;
            }System.out.println();
        }System.out.println();
        System.out.println();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (j==1||j==n||i==1||i==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }}
            System.out.println();
        }System.out.println();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (j==1||i==1||i==n/2+1){
                    System.out.print("* ");
            }}
            System.out.println();
        }System.out.println();
        for (int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                if (j==1||i==1||i==n/2+1){
                    System.out.print("* ");
                }}
            System.out.println();
        }}
}
