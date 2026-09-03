class Solution {
    public int subarraySum(int[] nums, int k) {
        // use a map < cumulative sum : counts of the sum occur>
        // iterate the maxSum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
    
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if map contains the sum-k, we have a new subarray
            if(map.containsKey(sum -k)) { // 1 2 3 2 1
                count += map.get(sum-k);
            } 
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;

    }
}