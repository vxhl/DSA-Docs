package Leetcode_DailyChallenges.MayChallenge;

class Solution_BackspaceStringCompare {

    public boolean bcompare(String s, String t)
    {
        int i = s.length()-1;
        int j = t.length()-1;
        int skipS = 0;
        int skipT = 0;
        while(i>=0 && j>=0)
        {
            while(i>=0)
            {
                if(s.charAt(i) == '#')
                {
                    skipS++;
                    i--;
                }
                else if(skipS>0)
                {
                    skipS--;
                    i--;
                }
                else
                {
                    break;
                }
            }
            while(j>=0)
            {
                if(t.charAt(j) == '#')
                {
                    skipT++;
                    j--;
                }
                else if(skipT>0)
                {
                    skipT--;
                    j--;
                }
                else
                {
                    break;
                }
            }

            if(i>=0 && j>=0 && s.charAt(i)!=t.charAt(j))
            {
                return false;
            }

            if((i>=0) != (j>=0))
            {
                return false;
            }
            i--;
            j--;

        }
        return true;
    }







    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder t1 = new StringBuilder();
        
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i)!='#')
            {
                s1.append(s.charAt(i));
            }
            else if(s1.length() != 0)
            {
                s1.deleteCharAt(s1.length()-1);
            }
        }
        
         for(int i=0; i<t.length(); i++)
        {
            if(t.charAt(i)!='#')
            {
                t1.append(t.charAt(i));
            }
            else if(t1.length()!=0)
            {
                t1.deleteCharAt(t1.length()-1);
            }
        }
        
        s = s1.toString();
        t = t1.toString();
        if(s.length() != t.length())
        {
            System.out.print("failed");
            return false;
        }
        
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) != t.charAt(i))
            {
                return false;
            }
        }
        return true;
        
    
    }
}