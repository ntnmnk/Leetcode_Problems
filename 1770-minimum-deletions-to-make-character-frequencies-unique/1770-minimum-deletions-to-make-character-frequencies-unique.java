class Solution {
    public int minDeletions(String s) {
     Map<Character, Integer> charFrequency = new HashMap<>();
    Set<Integer> uniqueFrequencies = new HashSet<>();

            int deletions = 0;
        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }
        // Iterate through the frequencies
        for (int freq : charFrequency.values()) {
            while (uniqueFrequencies.contains(freq)) {
                // Increment deletions and reduce the frequency until it's unique
                freq--;
                deletions++;
            }
            if (freq > 0) {
                uniqueFrequencies.add(freq);
            }
        }

        return deletions;


   
    }
}