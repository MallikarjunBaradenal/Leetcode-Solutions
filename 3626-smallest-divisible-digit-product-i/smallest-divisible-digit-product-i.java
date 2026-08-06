class Solution {
    public int smallestNumber(int n, int t) {
        for (int i = n; ; i++) {          // Check every number starting from n
            int product = 1;              // Store product of digits

            for (int x = i; x > 0; x /= 10) { // Extract every digit
                product *= (x % 10);          // Multiply current digit
            }

            if (product % t == 0) {       // Product divisible by t
                return i;                 // Smallest valid number found
            }
        }
    }
}