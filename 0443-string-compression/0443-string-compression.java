class Solution {
    public int compress(char[] chars) {
         int write = 0; // Pointer for writing compressed characters

    for (int read = 0; read < chars.length; ) {
        int count = 0;
        char currentChar = chars[read];

        while (read < chars.length && chars[read] == currentChar) {
            read++;
            count++;
        }

        chars[write++] = currentChar; // Write the character

        if (count > 1) {
            for (char c : Integer.toString(count).toCharArray()) {
                chars[write++] = c;
            }
        }
    }

    return write;
   
    }
}