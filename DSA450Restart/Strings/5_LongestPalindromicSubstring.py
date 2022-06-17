class Solution:
    def longestPalindrome(self, s: str) -> str:
        res = ""
        reslen = 0
        
        for i in range(len(s)):
            # We go through every single position in the string considering it to be the center
            
            # odd lengths
            # In case of odd lengths our left and right pointers are at the same position initially
            l, r = i, i
            
            # We check whether the elements are in bounds and the current substring is in fact a palindrome
            while(l>=0 and r<len(s) and s[l]==s[r]):
                # If it is then we update our result if it is greater than the result that we already have
                if(r-l+1)>reslen:
                    # And we also trim our substring to the resultant length
                    res = s[l:r+1]
                    reslen = r-l+1
                l -= 1;
                r += 1;
            
            # Even length
            l, r = i, i+1
            
            # While we are in bounds and the elemets are equal
            while(l>=0 and r<len(s) and s[l] == s[r]):
                if(r-l+1)>reslen:
                    res = s[l:r+1]
                    reslen = r-l+1
                l-=1
                r+=1
        return res
                