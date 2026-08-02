class Solution {

    // Store the candidate numbers array
    private int[] candidates;
    // store the current combination being build
    private List<Integer> currentCombination = new ArrayList<>();
    // store all combination that sum to target
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Sort candidates to enable early termination in DFS
        Arrays.sort(candidates);
        this.candidates = candidates;

        // start DFS from index0 with the initial target
        dfs(0, target);

        return result;
    }

    /**
     * Depth-first search to find all combinations starting from index startIndex
     * 
     * @param startIndex Starting index in candidates array to avoid duplicates
     * @param remainingTarget Remaining sum needed to reach the target
     */
    private void dfs(int startIndex, int remainingTarget) {
        // base case : found a combination sum
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }
        // Early termination: remaining target is less than smallest available candidate
        if (remainingTarget < candidates[startIndex]) {
            return;
        }
        // try each candidate starting from startIndex
        for(int i = startIndex; i < candidates.length; ++i) {
            // add current candidate to the combination
            currentCombination.add(candidates[i]);
            // Recursively search with the same starting index (allowing reuse)
            // and reduced target
            dfs(i, remainingTarget - candidates[i]);
            // Backtrack: remove the last added candidate
            currentCombination.remove(currentCombination.size() - 1);
        }

    }
}