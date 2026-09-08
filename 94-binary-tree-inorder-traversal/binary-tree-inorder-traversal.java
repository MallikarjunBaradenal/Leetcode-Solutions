class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // stores nodes in inorder
        Stack<TreeNode> stack = new Stack<>();    // remembers ancestors
        TreeNode current = root;                  // starts from root

        while (current != null || !stack.isEmpty()) { // continue while nodes remain
            while (current != null) {                  // go as far left as possible
                stack.push(current);                   // save current for later
                current = current.left;                // move to left child
            }

            current = stack.pop();                     // visit leftmost unvisited node
            result.add(current.val);                   // record its value
            current = current.right;                   // process right subtree
        }

        return result;                                 // return inorder sequence
    }
}