class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);                         // Put duplicates next to each other
        List<List<Integer>> result = new ArrayList<>(); // Store unique permutations
        boolean[] used = new boolean[nums.length]; // Track elements used in current permutation
        backtrack(nums, used, new ArrayList<>(), result); // Generate permutations
        return result;                             // Return all unique permutations
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current,
                           List<List<Integer>> result) {
        if (current.size() == nums.length) {       // A complete permutation is formed
            result.add(new ArrayList<>(current));  // Store a copy of the permutation
            return;                                // Stop this recursion branch
        }

        for (int i = 0; i < nums.length; i++) {    // Try every available element
            if (used[i]) continue;                 // Skip an element already in current path

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                continue;                           // Skip duplicate choices at this level

            used[i] = true;                        // Mark this occurrence as used
            current.add(nums[i]);                  // Choose the element

            backtrack(nums, used, current, result); // Build the remaining positions

            current.remove(current.size() - 1);    // Undo the choice
            used[i] = false;                       // Make the element available again
        }
    }
}