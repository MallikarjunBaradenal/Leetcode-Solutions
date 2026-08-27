class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(); // stores all permutations
        boolean[] used = new boolean[nums.length];      // tracks chosen elements
        backtrack(nums, used, new ArrayList<>(), result); // generate permutations
        return result;                                  // return all permutations
    }

    private void backtrack(int[] nums, boolean[] used,
                           List<Integer> current,
                           List<List<Integer>> result) {
        if (current.size() == nums.length) {            // permutation is complete
            result.add(new ArrayList<>(current));       // save a copy of current
            return;                                     // stop this branch
        }

        for (int i = 0; i < nums.length; i++) {         // try every element
            if (used[i]) continue;                      // skip already chosen elements

            used[i] = true;                             // mark element as chosen
            current.add(nums[i]);                       // add element to permutation

            backtrack(nums, used, current, result);     // choose the next position

            current.remove(current.size() - 1);         // undo the choice
            used[i] = false;                            // make element available again
        }
    }
}