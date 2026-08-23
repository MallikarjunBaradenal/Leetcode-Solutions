class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0"; // zero product

        int m = num1.length(), n = num2.length();             // lengths of both numbers
        int[] result = new int[m + n];                        // maximum possible digits

        for (int i = m - 1; i >= 0; i--) {                    // process num1 from right
            for (int j = n - 1; j >= 0; j--) {                // process num2 from right
                int a = num1.charAt(i) - '0';                // convert digit to integer
                int b = num2.charAt(j) - '0';                // convert digit to integer

                int product = a * b;                          // multiply two digits
                int pos1 = i + j;                             // carry position
                int pos2 = i + j + 1;                         // current digit position

                int sum = product + result[pos2];             // add existing value
                result[pos2] = sum % 10;                      // store current digit
                result[pos1] += sum / 10;                     // store carry
            }
        }

        StringBuilder sb = new StringBuilder();              // build answer efficiently
        for (int digit : result) {                            // traverse result array
            if (sb.length() == 0 && digit == 0) continue;     // skip leading zeros
            sb.append(digit);                                 // append digit
        }

        return sb.toString();                                 // return product
    }
}