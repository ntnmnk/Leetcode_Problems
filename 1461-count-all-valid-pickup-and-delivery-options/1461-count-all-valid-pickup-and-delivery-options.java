class Solution {
    public int countOrders(int n) {
       final int MOD=1_000_000_007;
       long dp[]=new long [n+1]; 
           dp[1] = 1;


           for (int i = 2; i <= n; i++) {
               dp[i] = (dp[i - 1] * (2 * (i - 1) + 1) * i) % MOD;

    }
    return ((int)dp[n]);
}
}