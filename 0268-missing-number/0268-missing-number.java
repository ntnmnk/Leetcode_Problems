class Solution {
    public int missingNumber(int[] nums) {
      int missing = nums.length; 
          // XOR all numbers from 0 to n
    for (int i = 0; i < nums.length; i++) {
        missing ^= i ^ nums[i];
    }
    
    return missing;

    }
}