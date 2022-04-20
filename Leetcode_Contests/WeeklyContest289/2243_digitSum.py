s = str(input())
s1 = ""
while(s>k):
    for i in range(0, n, k):
        count = 0
        for j in range(i, k):
            count += s[j]
        s1.append(count);
        s = s1;
