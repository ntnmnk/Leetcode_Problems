class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
             int MOD = 1000000007;
        int n = locations.length;
        
        // Initialize the dp array
        int[][] dp = new int[n][fuel + 1];
        dp[start][fuel] = 1;

        // Iterate over remaining fuel values
        for (int f = fuel; f >= 0; f--) {
            // Iterate over all cities
            for (int i = 0; i < n; i++) {
                // Skip if fuel is not enough to reach this city
                if (dp[i][f] == 0) continue;
                
                // Try moving to other cities
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        int cost = Math.abs(locations[i] - locations[j]);
                        if (f >= cost) {
                            dp[j][f - cost] = (dp[j][f - cost] + dp[i][f]) % MOD;
                        }
                    }
                }
            }
        }

        // Sum all the ways to reach the finish city with any remaining fuel
        int result = 0;
        for (int f = 0; f <= fuel; f++) {
            result = (result + dp[finish][f]) % MOD;
        }

        return result;
   
    }
}