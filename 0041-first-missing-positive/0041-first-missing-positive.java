class Solution {
    public int firstMissingPositive(int[] nums) {
          int n = nums.length;
    Set<Integer> set = new HashSet<>();

    // Step 1: Add all positive integers to the set
    for (int num : nums) {
        if (num > 0) {
            set.add(num);
        }
    }

    // Step 2: Find the smallest missing positive integer
    for (int i = 1; i <= n; i++) {
        if (!set.contains(i)) {
            return i;
        }
    }

    // If all positive integers from 1 to n are present, return n + 1
    return n + 1;


}}
