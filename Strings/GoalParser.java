package Strings;

public class GoalParser {
    static String GoalParser(String command)
    {
        String ans = "";
        for(int i=0; i<command.length(); i++)
        {
            if(command.charAt(i) == 'G')
            {
                ans += command.charAt(i);
            }
            else if(command.charAt(i) == '(')
            {
                if(command.charAt(i+1) == ')')
                {
                    ans += 'o';
                }
                else if(command.charAt(i+1) == 'a')
                {
                    ans += "al";
                }
                else
                {
                    continue;
                }
            }
        }
        return ans;
        
    }

    static String goalParser_RegEx(String command)
    {
        return command.replaceAll("\\(\\)", "o").replaceAll("\\(al\\)", "al");
    }
}
