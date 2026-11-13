class Solution {
    public int findValueOfPartition(int[] nums) {
        Arrays.sort(nums);
        int value = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length-1; i++) {
            value = Math.min(nums[i+1]-nums[i], value);
        }

        return value;
    }
}