class Solution {
    public int countKDifference(int[] nums, int k) {
              Map<Integer, Integer> numCount = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            // Check how many elements have a difference of 'k' with the current number
            count += numCount.getOrDefault(num - k, 0);
            count += numCount.getOrDefault(num + k, 0);

            // Update the count of the current number in the map
            numCount.put(num, numCount.getOrDefault(num, 0) + 1);
        }

        return count;


    }
}