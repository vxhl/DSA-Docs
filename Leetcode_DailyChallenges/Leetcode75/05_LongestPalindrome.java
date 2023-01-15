class Solution {
    
    public int longestPalindrome(String s) {
        if(s.length()==0 || s==null) return 0;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                set.remove(s.charAt(i));
                count++;
            }else{
                set.add(s.charAt(i));
            }
        }
        if(!set.isEmpty()){ return count*2+1;}
        return count*2;
    }
}

/*

bananas
a 2
n 2
s 1
b 1


Given a string s
has both lowecase and uppercase characters
find the longest palindrome that can be formed with them.

abccccdd

here dccaccd is the longest palindrome that can be built

how do we determine this. 
given that Aa cannot be considered a palindrome so here we need to consider
the ascii values for the characters while considering palindromes

here 

abccccdd
a 1
b 1
c 4
d 2
here c can form palindrome
+ 2 d's can form a palindrome even larger
+ 1 of a or b can form a palindrome 
so 4+2+1 can form a palindrome. 


let us take a different example.

abCcCcDd

a 1
b 1
C 2
c 2
d 1
D 1

here we have 2c 2C (1d || 1b || 1a) so 5 is the longest palindrome. 
seems pretty simple just using a hashtable










*/