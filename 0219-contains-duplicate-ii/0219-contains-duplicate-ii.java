class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) return true;
            set.add(nums[i]); // add 1 2 3

            if(set.size() > k) { //3 > 2
                set.remove(nums[i-k]); //nums[2-2] = 0, remove 1
            }

        }
        return false;       
    }
}