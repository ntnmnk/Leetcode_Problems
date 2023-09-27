class Solution {
    public String decodeAtIndex(String s, int k) {
    long size = 0; // Represents the size of the decoded string
    int n = s.length();
    

    // Calculate the size of the decoded string without actually decoding it
    for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int digit = Character.getNumericValue(c);
            size *= digit;
        } else {
            size++;
        }
    }

    

        // Start decoding the string in reverse to find the kth letter
    for (int i = n - 1; i >= 0; i--) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            int digit = Character.getNumericValue(c);
            size /= digit;
            k %= size; // Update k to its position within the current tape
        } else {
            // If k is 0 or size is equal to k (meaning k points to the current character),
            // return the current character.
            if (k == 0 || k == size) {
                return Character.toString(c);
            }
            size--; // Move one step back in the decoded string
        }
    }

     return "Invalid";   
    }
}