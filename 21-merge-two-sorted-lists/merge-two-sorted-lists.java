class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0); // Dummy node before merged list
        ListNode curr = dummy;            // Current tail of merged list

        while (list1 != null && list2 != null) { // Compare both lists

            if (list1.val <= list2.val) { // Take smaller node
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }

            curr = curr.next; // Move tail forward
        }

        curr.next = (list1 != null) ? list1 : list2; // Attach remaining nodes

        return dummy.next; // Skip dummy node
    }
}