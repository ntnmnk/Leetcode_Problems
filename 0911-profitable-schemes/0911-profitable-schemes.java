class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
             int MOD = 1_000_000_007;
        int len = group.length;
        
        // Initialize DP array
        int[][][] dp = new int[len + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        
        for (int i = 1; i <= len; i++) {
            int g = group[i - 1];
            int p = profit[i - 1];
            
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    // Initialize dp[i][j][k] by copying from the previous row
                    dp[i][j][k] = dp[i - 1][j][k];
                    
                    // If we choose the current crime
                    if (j >= g) {
                        dp[i][j][k] += dp[i - 1][j - g][Math.max(0, k - p)];
                        dp[i][j][k] %= MOD;
                    }
                }
            }
        }
        
        // Calculate the total number of profitable schemes
        int totalSchemes = 0;
        for (int j = 0; j <= n; j++) {
            totalSchemes += dp[len][j][minProfit];
            totalSchemes %= MOD;
        }
        
        return totalSchemes;
   
    }
}