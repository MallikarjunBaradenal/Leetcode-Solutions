class Solution {
    public int maxDepth(TreeNode root) {       // Find maximum depth of tree
        if (root == null) return 0;            // Empty tree has depth 0

        int left = maxDepth(root.left);        // Find depth of left subtree
        int right = maxDepth(root.right);      // Find depth of right subtree

        return 1 + Math.max(left, right);      // Current node + deeper subtree
    }
}