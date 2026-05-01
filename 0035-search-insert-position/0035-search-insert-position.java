class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int pivot =0;
        
        while(left <= right) {
            pivot = left + (right - left) / 2;
            if(target < nums[pivot]) {
                right = pivot -1;

            } else if (target > nums[pivot]) {
                left = pivot + 1;
            } else {
                return pivot;
            }
        }
        return left;

    }
}