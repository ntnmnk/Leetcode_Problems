class Solution {
    public int compress(char[] chars) {
    if (chars == null || chars.length == 0) {
        return 0;
    }

    // Create a hashmap to count character occurrences
    HashMap<Character, Integer> charCount = new HashMap<>();

    int n = chars.length;
    int write = 0; // Pointer for writing compressed characters

    for (int read = 0; read < n; read++) {
        char currentChar = chars[read];
        
        // Update the character count in the hashmap
        charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);

        if (read == n - 1 || chars[read] != chars[read + 1]) {
            chars[write++] = currentChar; // Write the character

            int count = charCount.get(currentChar);
            if (count > 1) {
                char[] countChars = Integer.toString(count).toCharArray();
                for (char c : countChars) {
                    chars[write++] = c;
                }
            }

            // Clear the character count in the hashmap
            charCount.remove(currentChar);
        }
    }

    return write;
        
    }
}