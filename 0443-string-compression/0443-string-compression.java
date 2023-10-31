class Solution {
    public int compress(char[] chars) {
         if (chars == null || chars.length <= 1) {
        return chars.length;
    }

    int writeIndex = 0;
    int anchor = 0;
    
    for (int readIndex = 0; readIndex < chars.length; readIndex++) {
        if (readIndex + 1 == chars.length || chars[readIndex] != chars[readIndex + 1]) {
            chars[writeIndex++] = chars[anchor];
            if (readIndex > anchor) {
                int count = readIndex - anchor + 1;
                if (count > 1) {
                    String countStr = String.valueOf(count);
                    for (char countChar : countStr.toCharArray()) {
                        chars[writeIndex++] = countChar;
                    }
                }
            }
            anchor = readIndex + 1;
        }
    }

    return writeIndex;
   
    }
}