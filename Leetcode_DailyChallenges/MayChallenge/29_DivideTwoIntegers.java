class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        // We are gonna be using the formula => dividend-divisor*(2**x) >= 0
        // If we have 40/8 => 40-8*(2**2) = 8 >= 0
        // 8 - 8*2**0 => 0>=0
        // 2**2 + 2**0 => 4+1 = 5  and 40/8 = 5
        int quotient = 0;
        boolean flag_divisor = false;
        if(divisor<0)
        {
            flag_divisor = true;
            divisor = -divisor;
        }
        boolean flag_dividend = false;
        
        if(dividend<0)
        {
            flag_dividend = true;
            dividend = -dividend;
            
        }
        
        while(dividend>=divisor)
        {       
            int i=0;
            for(i=0; ;i++)
            {
                if(((1<<i)*divisor)>dividend)
                    break;
            }
            
            dividend -= divisor*(1<<(i-1));
            quotient += (1<<(i-1));
            
        }
        if(flag_divisor && flag_dividend)
        {
            return quotient;
        }
        else if(flag_divisor || flag_dividend)
        {
            quotient = -quotient;
        }
        return quotient;
            
    }

    public static int res(int dividend, int divisor)
    {
         // We are gonna be using the formula => dividend-divisor*(2**x) >= 0
        // If we have 40/8 => 40-8*(2**2) = 8 >= 0
        // 8 - 8*2**0 => 0>=0
        // 2**2 + 2**0 => 4+1 = 5  and 40/8 = 5
        if(dividend == 1<<31 && divisor==-1) return Integer.MAX_VALUE;
        // if(dividend == -1<<31 && divisor<0) return Integer.MAX_VALUE;
        
        // int quotient = 0;
        // boolean flag_divisor = false;
        boolean sign = (dividend>=0) == (divisor>=0) ? true: false;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        
        // boolean flag_dividend = false;
        
        int quotient = 0;
        while(dividend-divisor>=0)
        {       
            int count = 0;
            while(dividend-(divisor << 1 << count)>=0)
            {
                count++;
            }
            quotient+= 1<<count;
            dividend -= divisor<<count;
        }
        
        return sign?quotient: -quotient;
            
    }
}
