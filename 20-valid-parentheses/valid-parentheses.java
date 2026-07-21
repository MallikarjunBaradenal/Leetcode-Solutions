class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();          // stores opening brackets

        for (char ch : s.toCharArray()) {                // traverse each character
            if (ch == '(' || ch == '[' || ch == '{') {   // opening bracket
                stack.push(ch);                          // save it
            } else {                                     // closing bracket
                if (stack.isEmpty()) return false;       // nothing to match

                char top = stack.pop();                  // latest opening bracket

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{'))
                    return false;                        // mismatched pair
            }
        }

        return stack.isEmpty();                          // all brackets matched
    }
}