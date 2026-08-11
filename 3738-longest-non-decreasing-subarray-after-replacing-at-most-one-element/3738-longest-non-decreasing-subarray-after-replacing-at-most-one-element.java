class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;

        // prefix array: non-decreasing array end at index i
        int[] L = new int[n];
        L[0] = 1;
        int maxLen = 1;
        for(int i = 1; i < n; i++) {
            if(nums[i] >= nums[i-1]) {
                L[i] = L[i-1] + 1;
            } else {
                L[i] = 1;
            }
            maxLen = Math.max(maxLen, L[i]);
        }

        // suffix array
        int[] R = new int[n];
        R[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            if(nums[i] <= nums[i+1]) {
                R[i] = R[i+1] + 1;
            } else {
                R[i] = 1;
            }
            maxLen = Math.max(maxLen, R[i]);
        }

        // 1 2 3 1 
        // Iterate through each index, treating it as the element to replace
        for(int i = 0; i < n; i++) {
            if(i >= 1) {
                maxLen = Math.max(maxLen, L[i-1] +1);
            }
            if(i <= n-2) {
                maxLen = Math.max(maxLen, R[i+1] + 1); //从后往前
            }

            if(i > 0 && i < n -1 && nums[i-1] <= nums[i+1]) {
                maxLen = Math.max( maxLen, L[i-1] + 1 + R[i+1]);
            }
        }
        return maxLen;
    }
}