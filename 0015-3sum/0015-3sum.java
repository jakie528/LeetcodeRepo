class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1]){            
                twoSum(i, nums, res);
            }
        }
        return res;
    }

        private void twoSum(int i, int[] nums, List<List<Integer>> res){
            int lo = i + 1;
            int hi = nums.length-1;

            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum < 0) {
                    lo++;
                } else if(sum > 0){
                    hi--;
                } else {
                    //convert an array into a fixed-size list.
                    res.add(Arrays.asList (nums[i], nums[lo], nums[hi]));
                    lo++;
                    hi--;
                    while(lo < hi && nums[lo] == nums[lo-1]) {
                        lo++;
                    }
                }

            }
        }
}