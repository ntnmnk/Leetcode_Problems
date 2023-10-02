class Solution {
    public boolean winnerOfGame(String colors) {
        if (colors.length() == 1 || colors.length() == 2)
        return false;

    int countA = 0;
    int countB = 0;
    int[] va = new int[colors.length() + 1];
    va[1] = 0;
    va[2] = 0;

    for (int i = 3; i < va.length; i++) {
        if (colors.charAt(i - 2) == 'A' && colors.charAt(i - 3) == 'A' && colors.charAt(i - 1) == 'A') {
            va[i] = va[i - 1] + 1;
        } else {
            va[i] = va[i - 1];
        }
    }
    countA = va[colors.length()];

    for (int i = 3; i < va.length; i++) {
        if (colors.charAt(i - 2) == 'B' && colors.charAt(i - 3) == 'B' && colors.charAt(i - 1) == 'B') {
            va[i] = va[i - 1] + 1;
        } else {
            va[i] = va[i - 1];
        }
    }
    countB = va[colors.length()];

    return countA > countB;


    }
}