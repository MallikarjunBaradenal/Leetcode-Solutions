class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Keep k largest elements

        for (int num : nums) {                                  // Process every number
            minHeap.offer(num);                                 // Add current number

            if (minHeap.size() > k) {                           // More than k elements
                minHeap.poll();                                 // Remove the smallest
            }
        }

        return minHeap.peek();                                  // Smallest among k largest = kth largest
    }
}