class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            // it's impossible to reach the end of the array
            if(i > maxReach) return false;
            // current index + currentSteps
            maxReach = Math.max(maxReach, i+nums[i]);  
        }
        return true;
    }
}