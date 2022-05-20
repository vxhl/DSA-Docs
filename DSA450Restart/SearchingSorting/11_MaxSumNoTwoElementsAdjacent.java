package DSA450Restart.SearchingSorting;

class sticklerthief
{
public int FindMaxSum(int arr[], int n)
{
    if(n==0)
    {
        return 0;
    }
    if(n==1)
    {
        return arr[0];
    }
    
    if(n==2)
    {
        return Math.max(arr[0], arr[1]);
    }
    int[] dp = new int[n];
    // Arrays.fill(dp,-1);

    // return f(arr, n, dp);
    
    // We first initialise the first and second values
    dp[0] = arr[0];
    dp[1] = Math.max(arr[0], arr[1]);
    
    for(int i=2; i<n; i++)
    {
        dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
    }
    
    return dp[n-1];
    
    
    // return -1;
}

public static int f(int arr[], int n, int[] dp)
{
    if(n==0)
    {
        return 0;
    }
    if(n==1)
    {
        return arr[0];
    }
    
    if(dp[n-1]!=-1)
    {
        return dp[n-1];
    }
    
    int pick = arr[n-1] + f(arr, n-2, dp);
    int notPick = f(arr, n-1, dp);
    return dp[n-1] = Math.max(pick, notPick);
}
}
