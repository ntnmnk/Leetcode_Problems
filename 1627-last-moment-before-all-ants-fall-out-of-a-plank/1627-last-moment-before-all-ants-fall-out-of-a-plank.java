class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
         int maxLeft = 0;
    int maxRight = 0;

    for (int position : left) {
        maxLeft = Math.max(maxLeft, position);
    }

    for (int position : right) {
        maxRight = Math.max(maxRight, n - position);
    }

    return Math.max(maxLeft, maxRight);
   
    }
}