class Solution {
    public int rob(int[] nums) {
        int prev2 = 0;
        int prev1 = nums[0];

        for(int i = 2; i < nums.length+1; i++) { 
            int current = Math.max(prev1, nums[i-1]+prev2); // care for nums's index

            // shift variables forward for the next iteration
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}