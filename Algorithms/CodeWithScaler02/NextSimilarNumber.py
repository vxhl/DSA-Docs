def findNext (A):
    A_list = list(map(int,A))
    l = len(A_list)
    # First we loop in the reverse order to find if there is an element greater
    # than any previously traversed element
    # If we do find one we break and continue to find the smallest number to the right of the
    # found number but if we don' it means the number is already in descending order
    # So there is no new combination to be found since it is already greater
    i = 0
    if l==1:
        return -1
    for i in range(l-2, 0, -1):
        if A_list[i] >  A_list[i-1]:
            break
    if i==1 and A_list[i]<=A_list[i-1]:
        return -1

    # From the above for loop we get the index (i-1) for the number that breaks
    # The condition for being descending order
    # basically now we are to find the numbers on the right side of i-1 and find the smallest
    # to swap with the (i-1)th number
    smallest = i 
    x = A_list[i]
    # Now we loop through the right most elements in the string
    # and find the smallest
    for j in range(i+1, l):
        if A_list[j] > x and A_list[j]<A_list[smallest]:
            smallest = j
    # Now after finding the smallest we swap the numbers
    A_list[smallest], A_list[i-1] = A_list[i-1], A_list[smallest]

    final_A = [str(int) for int in A_list]
    super_final_A = "".join(final_A)
    return super_final_A
A = "740948"
print(findNext(A))

# Working Solution 
def solve(self, A):
        A_list = list(map(int, A))
        l = len(A_list)
        i = 0
        for i in range(l-1, 0, -1):
            if A_list[i] > A_list[i-1]:
                break
        if i == 1 and A_list[i] <= A_list[i-1]:
            return -1
        if i == 0:
            return -1
        
        
        # from the executed for loop we have found the index of the number
        #smaller to the previously traversed number to be i-1
        #Now we are to find numbers on right side of i-1 and find the smallest number
        # to swap with the (i-1)th number
        pos = i # The start index for rightmost part of the string after i-1
        x = A_list[i-1]
        for j in range(i+1, l):
            if A_list[j] > x and A_list[j]<A_list[pos]:
                pos = j
        # After finding the smallest element we swap it with the (i-1)th element
        A_list[i-1],A_list[pos] = A_list[pos], A_list[i-1]
        
        # final_A = [str(int) for int in A_list]
        # super_final_A = "".join(final_A)
        super_final_A = 0
        for j in range(i):
            super_final_A = super_final_A* 10 + A_list[j]
        A_list = sorted(A_list[i:])
        for j in range(l-i):
            super_final_A = super_final_A * 10 + A_list[j]
        return super_final_A