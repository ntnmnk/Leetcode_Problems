class Solution {
    public int numIdenticalPairs(int[] nums) {
    Map<Integer,Integer> map =new HashMap<>();
    int goodPairs=0;
        for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                // Elements at indices i and j are equal, indicating a good pair
                goodPairs++;
            }
        }
    }

    return goodPairs;

    }
}