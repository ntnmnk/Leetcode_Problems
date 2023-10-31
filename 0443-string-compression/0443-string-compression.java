class Solution {
    public int compress(char[] chars) {
         int indexAns = 0;
    int index = 0;

    while (index < chars.length) {
        char currentChar = chars[index];
        int count = 0;

        while (index < chars.length && chars[index] == currentChar) {
            index++;
            count++;
        }

        chars[indexAns++] = currentChar;

        if (count > 1) {
            String countStr = String.valueOf(count);
            for (char c : countStr.toCharArray()) {
                chars[indexAns++] = c;
            }
        }
    }

    return indexAns;

   
    }
}