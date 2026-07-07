class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    private int dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return max - min;
        }

        min = Math.min(min, node.val);
        max = Math.max(max, node.val);

        int left = dfs(node.left, min, max);
        int right = dfs(node.right, min, max);

        return Math.max(left, right);
    }
}