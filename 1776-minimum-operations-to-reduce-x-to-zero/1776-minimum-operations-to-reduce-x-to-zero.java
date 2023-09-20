class Solution {
    public int minOperations(int[] nums, int x) {
      int n = nums.length;
    int targetSum = Arrays.stream(nums).sum() - x;
    
    if (targetSum == 0) {
        return n; // The entire array can be removed
    }
    
    Map<Integer, Integer> sumMap = new HashMap<>();
    sumMap.put(0, -1); // Initialize the map with a sum of 0 at index -1
    int currentSum = 0;
    int maxLength = -1; // Initialize to -1 to handle the edge case
    
    for (int i = 0; i < n; i++) {
        currentSum += nums[i];
        
        if (sumMap.containsKey(currentSum - targetSum)) {
            // A subarray with the desired sum is found
            maxLength = Math.max(maxLength, i - sumMap.get(currentSum - targetSum));
        }
        
        // Store the current sum in the map if not already present
        if (!sumMap.containsKey(currentSum)) {
            sumMap.put(currentSum, i);
        }
    }
    
    if (maxLength == -1) {
        return -1; // No subarray with the desired sum is found
    }
    
    // Calculate the minimum number of operations to achieve the desired sum
    return n - maxLength;

    }
}