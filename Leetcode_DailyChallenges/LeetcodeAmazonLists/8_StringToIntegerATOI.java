class Atoi
{
    /*
      here are the cases we need to take care of

    If any leading whitespaces we just remove them
    If the sign is negative we traverse the string until alphabet or decimal is reached
    ans will store the number
     
    */
    public int myAtoi2(String s) {
        
        long ans = 0;
        int sign = 1;
        s = s.trim();
        if(s.length() == 0) return 0;
        if(s.charAt(0) == '-') sign = -1;
        
        int i = (s.charAt(0) == '+' || s.charAt(0) == '-')? 1: 0;
        
        while(i<s.length())
        {
            if(!Character.isDigit(s.charAt(i)) || s.charAt(i) == ' ')
            {
                break;
            }
            // 4901
            ans = ans*10 + (s.charAt(i) - '0');
            
            if(sign==-1 && -ans<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            
            if(sign==1 && ans>Integer.MAX_VALUE) return Integer.MAX_VALUE;
            i++;
        }
        return (int)(ans*sign); 
    }




    public int myAtoi(String s) {
        int res = 0;
        boolean sign = false;
        boolean ndetected = false;
        int countp = 0;
        boolean pdet = false;
        boolean ndet = false;
        int countmin = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(Character.isLetter(s.charAt(i)) || s.charAt(i) == '.' )
            {
                if(ndetected)
                {
                    break;
                }
                else
                {
                    return 0;
                }
            }
            
            if(ndetected && (s.charAt(i) == '-' || s.charAt(i)=='+' || s.charAt(i) == ' '))
            {
                break;
            }
            else if(Character.isDigit(s.charAt(i)))
            {
                
                ndetected = true;
                if(res > Integer.MAX_VALUE/10 || res*10>Integer.MAX_VALUE-(s.charAt(i)-'0'))
                {
                    return sign? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }
                res = res*10 +  (s.charAt(i)-'0');     
            }
            else if(s.charAt(i) == ' ' || s.charAt(i) == '+')
            {
                if(s.charAt(i) == '+') countp++;
                continue;
            }
            else if(s.charAt(i) == '-' && !ndetected && !sign)
            {
                countmin++;
                sign = true;
            }
        }
        if(sign  == true)
        {
            res = -res;
        }
        if(countmin>0 || countp>0)
        {
            if(countmin>1 || countp>1)
            {
                return 0;
            }
            if(countmin == countp)
            {
                return 0;
            }
        }
        return res;
    
    
    }
}