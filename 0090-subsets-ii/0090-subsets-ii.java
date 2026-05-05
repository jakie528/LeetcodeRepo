
import java.lang.reflect.Array;

class Solution {
    private int n;
    ArrayList<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); 
        n = nums.length;
        ArrayList<Integer> combo = new ArrayList<Integer>();
        backtrack(0, combo, nums);

        return result;
    }

    public void backtrack (int firstIndex, ArrayList<Integer> curr, int[] nums){
        result.add(new ArrayList<>(curr));

        for(int i = firstIndex; i < n; i++) {
            if(i > firstIndex && nums[i] == nums[i - 1]) continue; // index[0,1] and index[0,2]

            curr.add(nums[i]);
            backtrack(i+1, curr, nums);
            curr.remove(curr.size() - 1);
        }
    }


}