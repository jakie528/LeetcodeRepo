class Solution {
    public int minimizeArrayValue(int[] nums) {
        long res = Integer.MIN_VALUE;
        long prefixSum = 0;


        for(int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            // calculate the ceiling average for the first i+1 element
            long currentAverage;
            if(prefixSum%(i+1) == 0){
                currentAverage = prefixSum/(i+1);
            } else {
                currentAverage = prefixSum/(i+1)+1;  //with remaining
            }
            res = Math.max(res,currentAverage);
        }

        return (int)res;
    }
}