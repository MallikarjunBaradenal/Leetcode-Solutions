class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // Store all valid combinations
        backtrack(0, candidates, target, new ArrayList<>(), ans); // Start recursion
        return ans; // Return answer
    }

    private void backtrack(int index, int[] candidates, int target,
                           List<Integer> curr, List<List<Integer>> ans) {

        if (target == 0) { // Combination found
            ans.add(new ArrayList<>(curr)); // Save copy
            return;
        }

        if (index == candidates.length || target < 0) { // Invalid path
            return;
        }

        curr.add(candidates[index]); // Choose current number
        backtrack(index, candidates, target - candidates[index], curr, ans); // Reuse same element
        curr.remove(curr.size() - 1); // Undo choice

        backtrack(index + 1, candidates, target, curr, ans); // Skip current element
    }
}