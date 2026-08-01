class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();          // Stores answer indices
        if (s == null || words == null || words.length == 0)
            return ans;

        int wordLen = words[0].length();                // Length of one word
        int totalWords = words.length;                  // Number of words
        int windowLen = wordLen * totalWords;           // Total substring length

        if (s.length() < windowLen)
            return ans;

        Map<String, Integer> target = new HashMap<>();  // Required frequencies
        for (String word : words)
            target.put(word, target.getOrDefault(word, 0) + 1);

        // Try every possible starting offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;                          // Left boundary
            int count = 0;                             // Words inside window

            Map<String, Integer> window = new HashMap<>();

            // Move right one word at a time
            for (int right = offset; right + wordLen <= s.length(); right += wordLen) {

                String word = s.substring(right, right + wordLen);

                if (target.containsKey(word)) {

                    window.put(word, window.getOrDefault(word, 0) + 1);
                    count++;

                    // Remove extra occurrences
                    while (window.get(word) > target.get(word)) {

                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Valid window found
                    if (count == totalWords) {
                        ans.add(left);

                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                } else {

                    window.clear();                     // Invalid word
                    count = 0;
                    left = right + wordLen;
                }
            }
        }

        return ans;
    }
}