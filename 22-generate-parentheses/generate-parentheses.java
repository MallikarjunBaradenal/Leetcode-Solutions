class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();      // stores all valid combinations
        backtrack(ans, new StringBuilder(), 0, 0, n); // start recursion
        return ans;                                // return result
    }

    private void backtrack(List<String> ans, StringBuilder cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {               // one valid sequence formed
            ans.add(cur.toString());
            return;
        }

        if (open < n) {                            // can place '('
            cur.append('(');
            backtrack(ans, cur, open + 1, close, n);
            cur.deleteCharAt(cur.length() - 1);    // undo choice
        }

        if (close < open) {                        // place ')' only if valid
            cur.append(')');
            backtrack(ans, cur, open, close + 1, n);
            cur.deleteCharAt(cur.length() - 1);    // undo choice
        }
    }
}