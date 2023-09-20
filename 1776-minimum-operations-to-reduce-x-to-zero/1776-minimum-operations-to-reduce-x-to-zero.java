class Solution {
    public int minOperations(int[] nums, int x) {
   int sum = 0;
    for (int num : nums)
        sum += num;

    int maxLength = -1, currSum = 0;
    int left = 0, right = 0;

    for (right = 0; right < nums.length; right++) {
        currSum += nums[right];

        while (left <= right && currSum > sum - x){
            currSum -= nums[left]; left++;
        }
        if (currSum == sum - x)
            maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}