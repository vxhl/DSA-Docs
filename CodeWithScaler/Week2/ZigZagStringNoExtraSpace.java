package CodeWithScaler.Week2;


public class ZigZagStringNoExtraSpace {
    static String zigzagoptimised(String s, int numRows)
    {
        if(numRows == 1 || numRows >= s.length())
        {
            return s;
        }
        int cycle = (2*numRows - 2);
        StringBuilder sb = new StringBuilder();
        for(int row=0; row<numRows; row++)
        {
            for( int ele = row; ele<s.length(); ele+=cycle)
            {
                sb.append(s.charAt(ele));
                int k  = ele + cycle - (2*row);
                if(row!=0 && row!=numRows-1 && k<s.length())
                {
                    sb.append(s.charAt(k));
                }

            }

        }
        String result = sb.toString();
        return result;
         
        }
        public static void main(String[] args) {
            String s = "GEEKSFORGEEKS";
            int n = 3;
            System.out.println(zigzagoptimised(s,n));

        }

    }



/*
Approach 2 : 
int n = 3
"GEEKSFORGEEKS"
row = 0 = GSGS = 0, 4, 8, 12 = 0,+4,+4,+4
row = 1 = EKFREK = 2, 4, 6, 8 = 2, +2, +2, +2
row = 2 = EOE = 2, 6, 10 = 2, +4, +4
cycle = 2*3 - 2 
middle_cycle = row + cycle - (2*)
*/