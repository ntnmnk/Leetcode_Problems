class Solution {
    public int[] searchRange(int[] nums, int target) {
              int[] result = {-1, -1};

        int left = findPosition(nums, target, true);
        int right = findPosition(nums, target, false);

        if (left <= right) {
            result[0] = left;
            result[1] = right;
        }

        return result;
    }

    private static int findPosition(int[] nums, int target, boolean findLeft) {
        int left = 0;
        int right = nums.length - 1;
        int position = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                position = mid;

                if (findLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return position;
  
    }
}