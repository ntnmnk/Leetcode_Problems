class Solution {
    public int numIdenticalPairs(int[] nums) {
        int[] count = new int[101]; // We assume the range of integers in nums is from 1 to 100
    int goodPairs = 0;

    for (int num : nums) {
        // Increment the count of the current number and add the current count to the goodPairs
        goodPairs += count[num];
        count[num]++;
    }

    return goodPairs;
    
    }
}