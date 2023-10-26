class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
             int MOD = 1000000007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();

        for (int num : arr) {
            dp.put(num, 1L);

            for (int factor : arr) {
                if (factor >= num) {
                    break;
                }

                if (num % factor == 0) {
                    int complement = num / factor;
                    if (dp.containsKey(factor) && dp.containsKey(complement)) {
                        dp.put(num, (dp.get(num) + dp.get(factor) * dp.get(complement)) % MOD);
                    }
                }
            }
        }

        long total = 0;
        for (long count : dp.values()) {
            total = (total + count) % MOD;
        }

        return (int) (total % MOD);
   
    }
}