class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder(); // stores the answer efficiently
        int i = a.length() - 1;                      // pointer at the last bit of a
        int j = b.length() - 1;                      // pointer at the last bit of b
        int carry = 0;                              // carry produced by addition

        while (i >= 0 || j >= 0 || carry != 0) {   // process remaining bits and carry
            int sum = carry;                        // start with previous carry

            if (i >= 0) sum += a.charAt(i--) - '0'; // add current bit from a
            if (j >= 0) sum += b.charAt(j--) - '0'; // add current bit from b

            result.append(sum % 2);                 // current binary digit
            carry = sum / 2;                        // calculate new carry
        }

        return result.reverse().toString();         // digits were built from right to left
    }
}