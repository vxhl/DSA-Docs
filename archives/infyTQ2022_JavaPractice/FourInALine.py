r=int(input())
a=[]
for i in range(r):
 b=list(map(int,input().split()))
 a.append(b)

c=len(a[0])
ans=set()
i=0
while i<r:
 j=0
 while j<(c-3):
  if a[i][j]==a[i][j+1] and a[i][j]==a[i][j+2] and a[i][j]==a[i][j+3]:
   ans.add(a[i][j])
   j+=4

  else:
   j+=1

 i+=1

j=0
while j<c:
 i=0
 while i<(r-3):
  if a[i][j]==a[i+1][j] and a[i][j]==a[i+2][j] and a[i][j]==a[i+3][j]:
   ans.add(a[i][j])
   i+=4

  else:
   i+=1

 j+=1

for i in range(r):
 i1=i
 j=0
 while (i1+3)<r and (j+3)<c:
  if a[i1][j]==a[i1+1][j+1] and a[i1][j]==a[i1+2][j+2] and a[i1][j]==a[i1+3][j+3]:
    i1+=4
    j+=4
    ans.add(a[i1][j])

  else:
   i1+=1
   j+=1

for j1 in range(1,c):
 j=j1
 i1=0
 while (i1+3)<r and (j+3)<c:
  if a[i1][j]==a[i1+1][j+1] and a[i1][j]==a[i1+2][j+2] and a[i1][j]==a[i1+3][j+3]:
    ans.add(a[i1][j])
    i1+=4
    j+=4

  else:
   i1+=1
   j+=1

for i in range(r):
 i1=i
 j=(c-1)
 while (i1+3)<r and (j-3)>=0:
  if a[i1][j]==a[i1+1][j-1] and a[i1][j]==a[i1+2][j-2] and a[i1][j]==a[i1+3][j-3]:
    i1+=4
    j-=4
    ans.add(a[i1][j])

  else:
   i1+=1
   j-=1

for j1 in range(c-2,-1,-1):
 j=j1
 i1=0
 while (i1+3)<r and (j-3)>=0:
  if a[i1][j]==a[i1+1][j-1] and a[i1][j]==a[i1+2][j-2] and a[i1][j]==a[i1+3][j-3]:
    ans.add(a[i1][j])
    i1+=4
    j-=4

  else:
   i1+=1
   j-=1

if len(ans)>=1:
 print(min(ans))

else:
 print(-1)