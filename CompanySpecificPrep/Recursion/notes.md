## Recursion
1. Tail Recursion
```c
int func(int n){
    if(n==0){
        return 0;
    }
    print(n+ " ");
    return func(n-1);
}

```
2. Head Recursion
   Here the recursion call happens at the start of the function. 
```c
int func(int n){
    if(n==0){
        return 0;
    }
    func(n-1);
    print(n);
}
```

3. What is the need for recursion? 
-> Recursion can retrace it's path and it also makes the code much more concise.

4. 