class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0; // Points to the last unique element

        for (int j = 1; j < nums.length; j++) { // Traverse from second element
            if (nums[j] != nums[i]) { // Found a new unique value
                i++;                  // Move unique pointer forward
                nums[i] = nums[j];    // Place unique value in correct position
            }
        }

        return i + 1; // Number of unique elements
    }
}