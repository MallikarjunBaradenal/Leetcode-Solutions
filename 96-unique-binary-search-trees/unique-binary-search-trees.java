class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];     // dp[i] = number of unique BSTs using i nodes
        dp[0] = 1;                    // Empty tree is one valid subtree

        for (int nodes = 1; nodes <= n; nodes++) {       // Calculate answer for each size
            for (int root = 1; root <= nodes; root++) {  // Try every node as root
                int left = dp[root - 1];                 // Number of BSTs on left side
                int right = dp[nodes - root];            // Number of BSTs on right side
                dp[nodes] += left * right;               // Combine left and right possibilities
            }
        }

        return dp[n];                  // Number of unique BSTs with n nodes
    }
}