class Solution {
    public double champagneTower(int poured, int queryRow, int queryGlass) {
            double[][] glasses = new double[queryRow + 1][queryRow + 1];
        glasses[0][0] = poured; // Pour the initial amount into the top glass
        
        for (int i = 0; i < queryRow; i++) {
            for (int j = 0; j <= i; j++) {
                double overflow = (glasses[i][j] - 1.0) / 2.0; // Calculate overflow
                if (overflow > 0) {
                    glasses[i + 1][j] += overflow; // Distribute overflow to left glass
                    glasses[i + 1][j + 1] += overflow; // Distribute overflow to right glass
                }
            }
        }
        
        // Ensure the value is between 0 and 1 (full)
        return Math.min(1.0, glasses[queryRow][queryGlass]);
    
    }
}