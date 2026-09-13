class Solution {
    TreeNode first = null;       // first incorrectly placed node
    TreeNode second = null;      // second incorrectly placed node
    TreeNode prev = null;        // previously visited node in inorder

    public void recoverTree(TreeNode root) {
        inorder(root);           // inorder traversal detects the violations

        int temp = first.val;     // save first wrong value
        first.val = second.val;   // put second value into first node
        second.val = temp;        // put first value into second node
    }

    private void inorder(TreeNode root) {
        if (root == null) return; // stop at empty subtree

        inorder(root.left);       // visit smaller values first

        if (prev != null && prev.val > root.val) { // BST ordering is broken
            if (first == null) first = prev;       // record first wrong node
            second = root;                         // update second wrong node
        }

        prev = root;              // current node becomes previous node

        inorder(root.right);      // continue with larger values
    }
}