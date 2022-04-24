package DSA450Restart.Strings;
import java.util.*;
class shitSolutionThatIdoNotLike {

    // Encodes a URL to a shortened URL.
    
    HashMap<String, String> mp = new HashMap<>();
    
    public String encode(String longUrl) {
        StringBuilder sb = new StringBuilder();
        // We append one character
        sb.append((char)Math.floor(Math.random()*100));
        while(mp.containsKey(sb.toString()))
        {
            sb.append((char)Math.floor(Math.random()*100));
        }
        mp.put(sb.toString(), longUrl);
        return sb.toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return mp.get(shortUrl);
    }
}

class goodSolutionThatILike
{
    // Encodes a URL to a shortened URL.
    static HashMap<String, String> mp = new HashMap<>();
    static int length = 6;
    
    /*
    Our hashing depends on the following criteria. 
    We only hash the last distinct string in our longURL into a 6 string encoded
    random string that is put into our HashMap for only that particular distinct strig
    for example - design-tinyURL ~ de4cA

    Some properties of our hashing function is that it converts the string
    into a hashcode of lowercase, uppercase and numbers
    */
    public String hashing(String longURL)
    {
        String hashCode = "";

        for(int i=0; i<length; i++)
        {   
            int random  = (int) Math.floor(Math.random()*100);

            // We create cases where if 0 then number
            // if 1 then lowercase
            // otherwise uppercase
            if(random == 0)
            {
                // We get numbers between 1-9
                hashCode += ('0' + random%10);
            }
            else if(random == 1)
            {
                hashCode += ('a' + (char)(random % 26));
            }
            else{

                hashCode += ('A' + (char)(random%26));
            }
        }
        
        if(mp.containsKey(hashCode))
        {
            hashing(longURL);
        }
        mp.put(hashCode, longURL);
        
        return hashCode;
    }



    public String encode(String longURL)
    {
        String hashCode = hashing(longURL);

        return "https://tinyurl.com/"+hashCode;
    }
    public String decode(String shortURL)
    {   
        String hashCode = shortURL.substring(20, shortURL.length());
        return mp.get(hashCode);
    }
    
}
