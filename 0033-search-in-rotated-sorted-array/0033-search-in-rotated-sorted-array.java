class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length - 1;
        int low = 0;
        int high = n;

        // return index

        while(low <= high) {
        
        int mid = low+ (high - low) / 2;

        if(nums[mid] == target) {
            return mid;
        }

        // left half is sorted
        if(nums[mid] >= nums[high]) { 
            
            //Is the target inside nums[low] ~ nums[mid]
            if(nums[low] <= target && target < nums[mid])
            high = mid - 1;
            else 
            low = mid + 1;
        } else // right half [mid..high] is sorted
        {
            if(nums[mid] < target && target <= nums[high]) 
            low = mid + 1;
            else 
            high = mid - 1;
        }
    }

    return -1;
}
}