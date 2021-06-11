class Solution:
    def convertToPalindrome(self,S):
        l = 0
        r = len(S)-1
        while(l<=r):
            if(S[l]!=S[r]):
                return isPalindrome(S,l-1,r) or isPalindrome(S,l,r-1)
            else:
                l+=1
                r-=1
        return 1

    def isPalindrome(self, S, i, j):
        l = i
        r = j
        while(l<=r):
            if(S[l]!=S[r]):
                return 0
            else:
                l+=1
                r-=1
        return 1
c1 = Solution.convertToPalindrome(S="abcdba")
print(c1)
