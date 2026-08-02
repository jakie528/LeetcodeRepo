class Solution {
    public int rob(int[] nums) {
        // pick current one
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i = 2; i < nums.length+1; i++) { 
            dp[i]  = Math.max(dp[i-1], nums[i-1]+dp[i-2]); // care for nums's index
        }

        return dp[nums.length];
    }
}