
import java.util.Currency;class Solution {
    public int maxSubArray(int[] nums) {
        int maxSubarray = nums[0];
        int currSubarray = nums[0];

        for(int i = 1; i < nums.length; i++){
           int num = nums[i];

           currSubarray = Math.max(num, currSubarray + num);
           maxSubarray = Math.max(currSubarray, maxSubarray);
        }

        return maxSubarray;
    }
}