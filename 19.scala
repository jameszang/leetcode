// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
        var prev: ListNode = null;
        var curr: ListNode = head;
        var probe: ListNode = head;
        for (i <- 1 to n) {
            probe = probe.next;
        }
        while(probe != null) {
            prev = curr;
            curr = curr.next;
            probe = probe.next;
        }
        if (prev != null) {
            prev.next = curr.next;  // normal case
            return head;
        } else {
            return head.next;       // remove the head
        }
    }
}