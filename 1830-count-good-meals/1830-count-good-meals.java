class Solution {
    public int countPairs(int[] deliciousness) {
              Map<Integer, Integer> cnt = new HashMap<>();
        long ans = 0;
        for (int d : deliciousness) {
            for (int power = 1, i = 0; i < 22; ++i, power <<= 1) {
                ans += cnt.getOrDefault(power - d, 0);        
            }
            cnt.put(d, 1 + cnt.getOrDefault(d, 0));
        }
        return (int)(ans % 1_000_000_007);             
    }
}