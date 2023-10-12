/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
             int peakIndex = findPeak(mountainArr, 0, mountainArr.length() - 1, target);
        if (peakIndex == -1) {
            return -1; // Peak not found
        }
        int ascendingIndex = findAscending(mountainArr, target, 0, peakIndex);
        if (ascendingIndex != -1) {
            return ascendingIndex;
        }
        return findDescending(mountainArr, target, peakIndex, mountainArr.length() - 1);
    }

    private int findPeak(MountainArray mountainArr, int left, int right, int target) {
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            int midPlusOneValue = mountainArr.get(mid + 1);
            if (midValue < midPlusOneValue) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int findAscending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private int findDescending(MountainArray mountainArr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midValue = mountainArr.get(mid);
            if (midValue == target) {
                return mid;
            } else if (midValue < target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
   
    }
}