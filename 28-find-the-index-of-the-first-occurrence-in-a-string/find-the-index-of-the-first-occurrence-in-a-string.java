class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();          // Length of haystack
        int m = needle.length();            // Length of needle

        if (m == 0) return 0;               // Empty needle

        for (int i = 0; i <= n - m; i++) {  // Try every possible start index
            int j = 0;                      // Match characters one by one

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;                        // Continue while characters match
            }

            if (j == m) {                   // Entire needle matched
                return i;
            }
        }

        return -1;                          // Needle not found
    }
}