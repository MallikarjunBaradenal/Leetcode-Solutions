class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;              // 0 and 1 are their own square roots

        int left = 1;                    // smallest possible answer
        int right = x / 2;               // for x >= 2, sqrt(x) <= x/2
        int ans = 1;                     // stores the largest valid square root

        while (left <= right) {          // search while a candidate range exists
            int mid = left + (right - left) / 2; // avoid integer overflow

            if (mid <= x / mid) {         // equivalent to mid*mid <= x, without overflow
                ans = mid;               // mid is a valid answer
                left = mid + 1;          // try to find a larger valid value
            } else {
                right = mid - 1;         // mid is too large
            }
        }

        return ans;                      // floor(sqrt(x))
    }
}