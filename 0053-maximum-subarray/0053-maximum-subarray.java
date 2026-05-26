class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        // Replace this placeholder return statement with your code
        for (int i = 1; i < nums.length; i++) {
            //extend the previous subarray or start from the current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;

    }
}