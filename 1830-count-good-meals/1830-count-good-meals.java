class Solution {
    public int countPairs(int[] deliciousness) {
            final int MOD = 1000000007;
        int maxDeliciousness = 0;
        for (int d : deliciousness) {
            maxDeliciousness = Math.max(maxDeliciousness, d);
        }

        int maxSum = maxDeliciousness * 2;
        long count = 0;
        Map<Integer, Integer> deliciousnessCount = new HashMap<>();

        for (int d : deliciousness) {
            for (int i = 0; i <= 21; i++) {  // Iterate up to 2^21
                int target = (1 << i);
                int complement = target - d;
                if (deliciousnessCount.containsKey(complement)) {
                    count = (count + deliciousnessCount.get(complement)) % MOD;
                }
            }
            deliciousnessCount.put(d, deliciousnessCount.getOrDefault(d, 0) + 1);
        }

        return (int) count;


   
    }
}