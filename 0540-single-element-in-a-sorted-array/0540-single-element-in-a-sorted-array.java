class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) { //odd number
                // let it start from even number(potential pair)
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } else {
                // the single number is in mid or previous numbers
                right = mid;
            }
        }
        return nums[left];

    }
}