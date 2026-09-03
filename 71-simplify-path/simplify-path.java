class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>(); // stores valid directory names

        for (String part : path.split("/")) {     // split path into components
            if (part.equals("") || part.equals(".")) { // ignore empty and current-directory parts
                continue;
            }

            if (part.equals("..")) {              // move to parent directory
                if (!stack.isEmpty()) {           // only move back if a directory exists
                    stack.pop();                  // remove the current directory
                }
            } else {
                stack.push(part);                 // store a valid directory
            }
        }

        StringBuilder result = new StringBuilder(); // build canonical path

        while (!stack.isEmpty()) {                // retrieve directories in reverse order
            result.insert(0, "/" + stack.pop());  // prepend each directory
        }

        return result.length() == 0 ? "/" : result.toString(); // root if nothing remains
    }
}