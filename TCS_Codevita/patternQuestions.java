public class patternQuestions {
   static void pattern1(int n){
        for(int row=1; row<=n; row++){
            for(int col=1; col<=row; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
   } 

   static void pattern2(int n){
        for(int row = 0; row<n; row++){
            for(int col = n-row; col>=1; col--){
                System.out.print("*");
            }
            System.out.println();
        }
   }
   static void pattern3(int n){
        for(int row =0; row<2*n; row++){
            // If we exceed the length, we are gonna be printing for 
            int totalColumnsInRow = row>n? 2*n-row: row;
            for(int col=0; col<totalColumnsInRow; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
   }

   static void pattern4(int n){
        for(int row=1; row<=2*n; row++){
            // We are printing the * once
            // But we first print the spaces
            // For every place we have n-row spaces
            // for first row we have n-1 spaces
            // First print spaces for n-row/2 and then print 
            // row number of columns and again n-row/2 number of spaces
            
            int totalColumnsInRow2 = row>n? 2*n-row:row;
            int noOfSpaces = n-totalColumnsInRow2;

            for(int i=0; i<noOfSpaces; i++){
                System.out.print(" ");
            }
            for(int i=0; i<totalColumnsInRow2; i++){
                System.out.print("* ");
            }
            System.out.println();
        }
   }

   static void pattern6(int n){
        for(int row=1; row<=n; row++){
            // From row to 1
            for(int col = 0; col<n-row; col++){
                System.out.print(" ");
            }
            for(int col=row; col>=1; col--){
                System.out.print(col);
            }
            for(int col=2; col<=row; col++){
                System.out.print(col);
            }
            // Then from 1+1 to row number
            System.out.println();
        }
   }

   public static void main(String[] args) {
        int n = 3;
        pattern6(n);
   }
}
