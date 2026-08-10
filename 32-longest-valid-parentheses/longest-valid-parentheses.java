class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();   // store indices
        stack.push(-1);                         // base index before valid substring
        int maxLen = 0;                         // answer

        for (int i = 0; i < s.length(); i++) {  // traverse string
            char c = s.charAt(i);

            if (c == '(') {
                stack.push(i);                  // store opening bracket index
            } else {
                stack.pop();                    // match one opening bracket if possible

                if (stack.isEmpty()) {
                    stack.push(i);              // new base after unmatched ')'
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek()); // current valid length
                }
            }
        }

        return maxLen;                          // longest valid substring length
    }
}