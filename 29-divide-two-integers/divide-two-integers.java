class Solution {
    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Work with long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        long ans = 0;

        // Keep subtracting largest possible multiple
        while (a >= b) {

            long temp = b;      // Current divisor multiple
            long multiple = 1;  // Corresponding quotient

            // Double until next doubling exceeds dividend
            while ((temp << 1) <= a) {
                temp <<= 1;
                multiple <<= 1;
            }

            a -= temp;          // Remove largest chunk
            ans += multiple;    // Add quotient contribution
        }

        // Apply correct sign
        if ((dividend > 0) ^ (divisor > 0)) {
            ans = -ans;
        }

        return (int) ans;
    }
}