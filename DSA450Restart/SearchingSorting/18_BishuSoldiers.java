import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int noOfSoldiers = sc.nextInt();
        int[] powerOfSoldiers = new int[noOfSoldiers]; 
        for(int i=0;i<noOfSoldiers; i++)
        {
            powerOfSoldiers[i] = sc.nextInt();
        }

        int rounds = sc.nextInt();
        int iter = 0;
        while(iter<rounds)
        {
            int power = sc.nextInt();
            int cummulativePower = 0;
            int soldiersDefeated = 0;
            for(int i=0; i<noOfSoldiers; i++)
            {
                if(powerOfSoldiers[i]<=power)
                {
                    cummulativePower += powerOfSoldiers[i];
                    soldiersDefeated++;
                }
            }
            System.out.println(soldiersDefeated + " " + cummulativePower);

            iter++;

        }

    }
}