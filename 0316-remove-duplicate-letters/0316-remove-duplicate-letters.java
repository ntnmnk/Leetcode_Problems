class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26]; // Store the count of each character
    boolean[] inResult = new boolean[26]; // Track if a character is in the result
    Stack<Character> stack = new Stack<>();

    // Count the occurrences of each character in the string
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }

    for (char c : s.toCharArray()) {
        count[c - 'a']--; // Decrement the count of the character since we're considering it

        // If the character is already in the result, skip it
        if (inResult[c - 'a']) {
            continue;
        }

        // Remove characters from the stack that are larger and have more occurrences later
        while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
            inResult[stack.pop() - 'a'] = false;
        }

        // Add the current character to the stack and mark it as in the result
        stack.push(c);
        inResult[c - 'a'] = true;
    }

    // Build the result string from the stack
    StringBuilder result = new StringBuilder();
    for (char c : stack) {
        result.append(c);
    }

    return result.toString();

   
    }
}