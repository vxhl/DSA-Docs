package Arrays.SlidingWindowsProblems;
import java.util.*;
public class CountAnagrams {
    // WOW JUST WOW
    // THIS WAS AMAZING

    /*
    str -> aabaabaa
    ptr -> aaba
    
    How to brute force this? 
    Ok so, if we make all the anagrams for ptr the the total number of anagrams
    that will be made is !ptr.count(letter)
    

    aabaabaa    output -> 4 
    aaba

    */
    public static int countAnagram_GFG(String s1, String s2)
    {
        // SO we first convert our strings into arrays
        char []c = s2.toCharArray();
        char[] c1 = s1.toCharArray();

        // We then make two maps to store our occurences for the pattern
        Map<Character,Integer> m=new LinkedHashMap<>();
        Map<Character,Integer> m1=new LinkedHashMap<>();
        for(int j=0;j<s2.length();j++){
            // m.put(c[j],(m.get(c[j])==null?1:m.get(c[j])+1));

            if(!m.containsKey(c[j]))
            {
                m.put(c[j], 1);
            }
            else
            {
                m.put(c[j], m.get(c[j])+1);
            }
        }

        // We set out left and right boundaries for our windows and our final answer
        int i=0;
        int j=0;
        int finalAns=0;

        // K is to be size of our window
        int k=s2.length();
        while(j<s1.length()){
        
            // We take our 2nd map and store the occurences for the 
            // elements in our current window
            if(!m1.containsKey(c1[j]))
            {
                m1.put(c1[j], 1);

            }
            else
            {
                m1.put(c1[j], m1.get(c1[j])+1);
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){

                // We use the equals method to compare both our hashmaps keys
                // and value pairs, if all of them are equal then our just increment our answer

                if(m1.equals(m)) {
                    finalAns++;
                }

                // Now since we are sliding across our windows
                // we decrement the count of the previous ith element from the 
                // map for the previous window 
                m1.put(c1[i], m1.get(c1[i])-1);
                // And then we check whether that element that we removed was the only
                // occurence of the element and if it was then we just remove that element
                if(m1.get(c1[i])==0){
                    m1.remove(c1[i]);
                }

                // After we are done with this sliding step we increment our window to move to the next
                // window
                i++;
                j++;
            }
        }
        return finalAns;
    }

    public static void main(String[] args) {
        String s1 = "aabaabaa";
        String s2 = "aaba";
        System.out.print(countAnagram_GFG(s1, s2));
    }

}
