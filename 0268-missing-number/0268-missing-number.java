class Solution {
    public int missingNumber(int[] nums) {
         int n = nums.length;
    
    // Create a HashMap to store the numbers in the array as keys
    Map<Integer, Integer> numMap = new HashMap<>();
    for (int num : nums) {
        numMap.put(num, 1);
    }
    
    // Check for the missing number in the range [0, n]
    for (int i = 0; i <= n; i++) {
        if (!numMap.containsKey(i)) {
            return i;
        }
    }
    
    // Return -1 if no missing number is found (this should not happen)
    return -1;

    }
}