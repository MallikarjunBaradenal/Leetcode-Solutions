class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head; // handle trivial cases

        int n = 1;                              // count nodes
        ListNode tail = head;                   // find the last node

        while (tail.next != null) {             // traverse to the tail
            tail = tail.next;
            n++;
        }

        k %= n;                                 // remove full rotations
        if (k == 0) return head;                // rotation changes nothing

        tail.next = head;                       // make the list circular

        int steps = n - k;                      // new tail is this many nodes from head
        ListNode newTail = tail;                // start from old tail

        while (steps-- > 0) {                   // move to the new tail
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;        // node after new tail becomes new head
        newTail.next = null;                    // break the circular list

        return newHead;                         // return rotated list
    }
}