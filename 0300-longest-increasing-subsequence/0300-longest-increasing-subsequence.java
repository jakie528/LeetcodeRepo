class Solution {
    public int lengthOfLIS(int[] nums) {
        //the length of the longest increasing subsequence that ends exactly at index i
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        // when nums.length = 1, it's 1
        dp[0] = 1;

        int res = 1;

        for(int i = 1; i < dp.length; i++) { // i = 5
            for(int j = 0; j < i; j++) { // j = 2
                // when nums[j] > nums[i]
                if(nums[i] > nums[j]) { // 5 > 2
                dp[i] = Math.max(dp[i], dp[j] + 1);
                res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}