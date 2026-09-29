class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder ans = new StringBuilder();

        long num = numerator;
        long den = denominator;

        if ((num < 0) ^ (den < 0)) ans.append("-");

        num = Math.abs(num);
        den = Math.abs(den);

        ans.append(num / den);

        long remainder = num % den;

        if (remainder == 0) return ans.toString();

        ans.append(".");

        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                ans.insert(map.get(remainder), "(");
                ans.append(")");
                break;
            }

            map.put(remainder, ans.length());

            remainder *= 10;
            ans.append(remainder / den);
            remainder %= den;
        }

        return ans.toString();
    }
}