package LeetCoding.WeeklyContest281;
public class counteven {

    public static int countDigits(int x)
    {
        int sum = 0;
        while(x>0)
        {
            sum += x%10;
            x /= 10;
        }
        return sum;
    }
    public static int countEven(int nums) {
        int count = 0;
        int i = 2;
        while(i<=nums)
        {
            if(countDigits(i)%2 == 0)
            {
                count++;
            }
            i++;
        }
        return count;
        
        }

    public static void main(String[] args) {
        
            int n = 910;
            int n1 = 30;
            
            System.out.println(countEven(n1));
            System.out.println(countEven(n));
        }
    }
    

