class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
             // Count the frequency of each unique value in the array
        Map<Integer, Integer> valueFrequencyMap = new HashMap<>();
        for (int num : nums) {
            valueFrequencyMap.put(num, valueFrequencyMap.getOrDefault(num, 0) + 1);
        }

        // Initialize the minimum group count with the length of the input array
        int minGroupCount = nums.length;

        // Find the minimum frequency among all values
        for (int frequency : valueFrequencyMap.values()) {
            minGroupCount = Math.min(minGroupCount, frequency);
        }

        // Iterate from the minimum frequency down to 1
        for (int groupSize = minGroupCount; groupSize >= 1; groupSize--) {
            int result = calculateGroups(groupSize, valueFrequencyMap);
            if (result > 0) {
                return result;
            }
        }

        // If no valid grouping is found, return the length of the input array
        return nums.length;
    }

    private int calculateGroups(int groupSize, Map<Integer, Integer> valueFrequencyMap) {
        int totalGroups = 0;
        int remainingValue = groupSize + 1;

        // Iterate through the frequencies of values
        for (int frequency : valueFrequencyMap.values()) {
            int remainder = frequency % remainingValue;
            int fullGroups = frequency / remainingValue;

            if (remainder == 0) {
                // The value can be fully grouped with the current group size
                totalGroups += fullGroups;
            } else if (fullGroups >= groupSize - remainder) {
                // The value can be grouped with an additional group
                totalGroups += fullGroups + 1;
            } else {
                // Cannot form valid groups with the current group size
                return 0;
            }
        }

        return totalGroups;
   
    }
}