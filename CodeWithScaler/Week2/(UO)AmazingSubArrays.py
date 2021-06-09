# Problem Statement : Amazing substring is one that starts with a vowel
# and does not take into consideration the elements that come before
# Time Complexity : O(N)
def amazingSubArray(S):
    # First let us define our vowels list
    vowels = ['A','E','I','O','U']
    result = 0;
    count = 0;
    for i in range(len(S)):
        if S[i] in vowels:
            count += 1;
            count -= i;
            i = 1
            while(len(S)>i):
                count+=1
                i+=1
                
    return count%10003;
S = "ABEC"
print(amazingSubArray(S))