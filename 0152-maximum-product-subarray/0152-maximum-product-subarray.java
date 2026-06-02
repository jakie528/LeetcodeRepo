class Solution {
    public int maxProduct(int[] nums) {

        // Replace this placeholder return statement with your code
        if (nums.length == 0) {
            return 0;
        }
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int res = maxProduct;

        for (int i = 1; i < nums.length; i++) {
            int preMax = maxProduct;
            // order matter
            maxProduct = Math.max(Math.max(nums[i], maxProduct * nums[i]), minProduct * nums[i]);
            minProduct = Math.min(Math.min(nums[i], minProduct * nums[i]), preMax * nums[i]);
            // compare only the max
            res = Math.max(res, maxProduct);
        }

        return res;

    }
}