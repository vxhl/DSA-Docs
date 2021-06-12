package CodeWithScaler.Week2;
public class AddingTwoBinaries 
{
    public static String binaryAddition(String A, String B)
    {
        // We first initialise our result string
        String result = "";
        int sum = 0;
        int i = A.length()-1;
        int j = B.length() - 1;
        while(i>=0 || j>=0 || sum == 1)
        {
            sum += ((i>=0)? A.charAt(i) - '0': 0);
            sum += ((j>=0)? A.charAt(j) - '0': 0);
            // If current digit sum is 1 or 3
            // We concatente 1 to the result
            result = (char)(sum%2 + '0')+result;
            sum /= 2;
            i--;
            j--;
            
        }
        return result;

    }
}