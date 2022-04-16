package DSA450Restart.Strings;
import java.util.*;

class KeypadSequence
{
    public static String kseq(String s)
    {
        /*
        Well we put all characters from A to C in a list according to our
        keypad 
        and then we append our corresponding string index in the list for
        our given list
        Or we can use the corresponding ASCII values of A
        
        geeksforgeeks
        
        */
        String output = "";
        String str[] = {"2","22","222",
                        "3","33","333",
                        "4","44","444",
                        "5","55","555",
                        "6","66","666",
                        "7","77","777","7777",
                        "8","88","888",
                        "9","99","999","9999"
                    };
        int n = s.length();
        for(int i=0; i<n; i++)
        {
            if(s.charAt(i) == ' ')
            {
                output = output + '0';
            }
            else
            {
                int position = s.charAt(i) - 'A';
                output = output + str[position];
            }
        }

        return output;
    }

    public static void main(String[] args) {
        String op = "GEEKSFORGEEKS";
        for(int i=0; i<kseq(op).length(); i++)
        {
            System.out.print(kseq(op).charAt(i));
        }

        System.out.println('G'-'A');
    }
}