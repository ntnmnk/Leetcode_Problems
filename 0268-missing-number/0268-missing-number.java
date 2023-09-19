class Solution {
    public int missingNumber(int[] nums) {
       int n = nums.length;
    
    // Perform cyclic sort to rearrange numbers to their correct positions
    for (int i = 0; i < n; i++) {
        while (nums[i] >= 0 && nums[i] < n && nums[i] != nums[nums[i]]) {
            swap(nums, i, nums[i]);
        }
    }
    
    // Find the first index where nums[i] != i, that's the missing number
    for (int i = 0; i < n; i++) {
        if (nums[i] != i) {
            return i;
        }
    }
    
    // If all numbers from 0 to n-1 are present, return n
    return n;
}

// Helper method to swap elements in the array
private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

    
}