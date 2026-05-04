class Solution {
    private int n;
    private List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        ArrayList<Integer> currCombo = new ArrayList<Integer>();
        backtrack(0, currCombo, nums);
        return output;
    }

    public void backtrack(int firstIndex, ArrayList<Integer> curr, int[] nums) {
        output.add(new ArrayList<>(curr));

        for(int i = firstIndex; i < n; i++) {
            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size() -1);
        }
    }
}