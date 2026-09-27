class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;                         // number of elements
        if (n < 2) return 0;                         // fewer than 2 elements means no gap

        int min = nums[0], max = nums[0];           // find overall minimum and maximum
        for (int num : nums) {                      // scan every element
            min = Math.min(min, num);               // update minimum
            max = Math.max(max, num);               // update maximum
        }

        if (min == max) return 0;                   // all elements are identical

        int bucketSize = Math.max(1, (max - min) / (n - 1)); // minimum possible max gap
        int bucketCount = (max - min) / bucketSize + 1;      // number of buckets

        int[] bucketMin = new int[bucketCount];     // minimum value inside each bucket
        int[] bucketMax = new int[bucketCount];     // maximum value inside each bucket
        boolean[] used = new boolean[bucketCount];  // tells whether a bucket contains values

        for (int num : nums) {                      // place every number into its bucket
            int index = (num - min) / bucketSize;   // calculate bucket index

            if (!used[index]) {                     // first element entering this bucket
                bucketMin[index] = num;             // initialize bucket minimum
                bucketMax[index] = num;             // initialize bucket maximum
                used[index] = true;                 // mark bucket as non-empty
            } else {
                bucketMin[index] = Math.min(bucketMin[index], num); // update minimum
                bucketMax[index] = Math.max(bucketMax[index], num); // update maximum
            }
        }

        int answer = 0;                              // stores largest adjacent gap
        int previousMax = min;                      // maximum of previous non-empty bucket

        for (int i = 0; i < bucketCount; i++) {     // examine buckets from left to right
            if (!used[i]) continue;                 // empty buckets contain no actual values

            answer = Math.max(answer, bucketMin[i] - previousMax); // gap across buckets
            previousMax = bucketMax[i];             // current bucket becomes previous bucket
        }

        return answer;                              // largest gap between sorted neighbors
    }
}