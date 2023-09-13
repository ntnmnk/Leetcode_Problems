class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
    
    // Sort the array in ascending order.
    Arrays.sort(nums);
    
    int n = nums.length;
    
    for (int i = 0; i < n - 2; i++) {
        if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
            int target = -nums[i];
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicate elements for both left and right pointers.
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
    
    return result;
   
    }
}