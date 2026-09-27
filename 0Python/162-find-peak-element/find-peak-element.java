class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;                    // start of search range
        int right = nums.length - 1;     // end of search range

        while (left < right) {           // continue until one index remains
            int mid = left + (right - left) / 2; // avoid integer overflow

            if (nums[mid] > nums[mid + 1]) {      // descending: peak is at mid or left
                right = mid;                       // keep mid in search range
            } else {                               // ascending: peak must be to the right
                left = mid + 1;                    // discard mid and everything before it
            }
        }

        return left;                      // remaining index is a peak
    }
}