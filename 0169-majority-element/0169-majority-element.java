class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                ans = entry.getKey();
            }
        }

        return ans;
    }
}

// We iterate over nums once and make a constant time HashMap insertion
// on each iteration. Therefore, the algorithm runs in O(n) time.

// Space complexity : O(n)