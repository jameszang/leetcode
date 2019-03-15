// https://leetcode.com/problems/swap-nodes-in-pairs/

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def swapPairs(head: ListNode): ListNode = {
        var curr: ListNode = head;      // the left node to swap
        var neighbor: ListNode = null;  // the right node to swap
        if (curr != null) {
            neighbor = curr.next;
        }
        
        var ans: ListNode = null;       // the head node to return later
        var prev: ListNode = null;      // the node pointing to curr

        // do first iteration explicitly to properly initialize prev and ans
        if (curr != null && neighbor != null) {
            // initialize ans
            ans = neighbor;
            // swap
            curr.next = neighbor.next;
            neighbor.next = curr;
            // initialize prev
            prev = curr;
            curr = curr.next;
            if (curr != null) {
                neighbor = curr.next;
            } else {
                neighbor = null;
            }
        } else {
            // only 0 or 1 nodes, so nothing to swap
            return head;
        }
        
        while (curr != null && neighbor != null) {
            // swap
            curr.next = neighbor.next;
            neighbor.next = curr;
            prev.next = neighbor;
            
            // reassign pointers
            prev = curr;
            curr = curr.next;
            if (curr != null) {
                neighbor = curr.next;
            } else {
                neighbor = null;
            }
        }
        
        return ans;
    }
}