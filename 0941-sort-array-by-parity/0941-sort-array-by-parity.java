class Solution {
    public int[] sortArrayByParity(int[] nums) {
                      Comparator<Integer> customComparator = (a, b) -> {
            if (a % 2 == 0 && b % 2 != 0) {
                return -1; // Even comes before odd
            } else if (a % 2 != 0 && b % 2 == 0) {
                return 1; // Odd comes before even
            } else {
                return a - b; // Maintain the relative order
            }
        };

                Integer[] integerArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, customComparator);

        // Convert the sorted Integer array back to int array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = integerArray[i];
        }

        return nums;



               
    }
}