class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];

        // house 1 ~ n -1
        int max1 = robMoney(nums, 0, nums.length - 2);
        // house 2nd to last house (n)
        int max2 = robMoney(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    private int robMoney(int[] nums, int start, int end) {
        int prev2 = 0;
        int prev1 = nums[start];

        for(int i = start+1; i <= end; i++) {
            int current = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}