class NthFibo{

// 0, 1, 1, 2, 3, 5, 8, 13, 12, 7, 10, 8, 9, ... 5 , 8
// 
    public int nthFiboNumber(int N){
        int[] dp = new int[N];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<N; i++){
            dp[i]= digitSum(dp[i-1])+digitSum(dp[i-2]);
        }
        return dp[N-1];
    }

    private int digitSum(int N){
        int sum = 0;
        while(N>0){
            sum+=(N%10);
            N/=10;
        }
        return sum;
    }
    public static void main(String[] args){
        int n = 10;
        NthFibo obj1 = new NthFibo();
        System.out.println(obj1.nthFiboNumber(n));
    }

}