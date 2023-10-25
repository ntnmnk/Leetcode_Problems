class Solution {
    public int countPairs(int[] deliciousness) {
               int[] target = new int[22];
        for (int i = 0; i < 22; i++) {
            target[i] = 1 << i;
        }
        long ans = 0;
        Map<Integer, Integer> dp = new HashMap<>();
        
        for (int candidate : deliciousness) {
            for (int miniTarget : target) {
                int complement = miniTarget - candidate;
                ans += dp.getOrDefault(complement, 0);
            }
            dp.put(candidate, dp.getOrDefault(candidate, 0) + 1);
        }
        
        return (int)(ans % 1_000_000_007);         

    
    }
}