class Solution {
    public int countPairs(int[] deliciousness) {
            TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int d : deliciousness) {
            cnt.put(d, 1 + cnt.getOrDefault(d, 0));
        }
        long ans = 0;
        while (!cnt.isEmpty()) {
            var e = cnt.pollLastEntry();
            int key = e.getKey(), v = e.getValue(), p = 1;
            while (p <= key) {
                p <<= 1;
            }
            if (Integer.bitCount(key) == 1) {
                ans += 1L * v * cnt.getOrDefault(0, 0);    
                ans += (v - 1L) * v / 2;   
            }else if (cnt.containsKey(p - key)) {
                ans += 1L * v * cnt.get(p - key);
            }
        }
        return (int)(ans % 1_000_000_007);         
      

    
    }
}