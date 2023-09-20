class Solution {
        private int countSoldiers(int[] row) {
        int count = 0;
        for (int value : row) {
            if (value == 1) {
                count++;
            }
        }
        return count;
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        // Create an array of indices and initialize it with row numbers
        Integer[] indices = new Integer[m];
        for (int i = 0; i < m; i++) {
            indices[i] = i;
        }
        
    // Sort the indices array based on custom comparator
    Arrays.sort(indices, (row1, row2) -> {
    int count1 = countSoldiers(mat[row1]);
    int count2 = countSoldiers(mat[row2]);
    return count1 != count2 ? Integer.compare(count1, count2) : Integer.compare(row1, row2);
});

        
        // Create the result array with the k weakest row indices
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = indices[i];
        }
        
        return result;
   
    }
}