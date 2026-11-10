class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                if(nums[j] > nums[i]) {
                    //if we don't add dp[j], it will be erased.
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                    res = Math.max(dp[j], res);
                }
            }
        }

        return res;
    }

// find the first element that's >= num
    private int binarySearch(ArrayList<Integer> sub, int num) {
        int left = 0; 
        int right = sub.size() - 1;
        while(left < right) {
            int mid = (left + right) / 2; 
            if(sub.get(mid) == num) {
                return mid;
            }
            //the element we want to replace must be further to the right
            if(sub.get(mid) < num) {
                left = mid + 1;
            } else 
            // mid could be the answer
            // or answer cound be further to the left
            // so we can't discard mid
            {
                right = mid;
            }
        }

        return right;

    }
}