class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[] suf = new int[n + 1];
        suf[n] = m;

        int j = m - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) j--;
            suf[i] = j + 1;
        }

        int[] ans = new int[m];
        int i = 0;
        j = 0;
        boolean used = false;

        while (j < m) {
            while (i < n) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    ans[j++] = i++;
                    break;
                }

                if (!used && suf[i + 1] <= j + 1) {
                    used = true;
                    ans[j++] = i++;
                    break;
                }

                i++;
            }

            if (i > n || (j < m && i == n)) return new int[0];
        }

        return ans;
    }
}