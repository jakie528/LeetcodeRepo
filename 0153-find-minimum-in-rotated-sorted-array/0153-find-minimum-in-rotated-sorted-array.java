class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = left + (right - left) / 2;

            // the point is must between right and mid (not included)
            if(nums[right] < nums[mid]){
                left = mid + 1;
           
            } else
            // sorted, the min is at mid or to its left.
             if(nums[right] > nums[mid]) {
                right = mid;
            }
        }

        return nums[right];
    }
}