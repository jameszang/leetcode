// https://leetcode.com/problems/reverse-linked-list/

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseList(head: ListNode): ListNode = {
        // return reverseListIterative(head);
        return reverseListRecursive(head, null);
    }
    
    def reverseListIterative(head: ListNode): ListNode = {
        if (head == null) {
            return null;
        }
        var prev: ListNode = head;
        var curr: ListNode = prev.next;
        var neighbor: ListNode = null;
        if (curr != null) {
            neighbor = curr.next;
        }
        
        while (curr != null) {
            // reverse curr's pointer
            curr.next = prev;
            
            // update prev, curr, and neighbor
            prev = curr;
            curr = neighbor;
            if (neighbor != null) {
                neighbor = neighbor.next;
            }
        }
        
        var tail: ListNode = head;
        tail.next = null;
        return prev;
    }
    
    def reverseListRecursive(curr: ListNode, prev: ListNode): ListNode = {
        if (curr == null) {
            return null;
        } else if (curr.next == null) {
            curr.next = prev;
            return curr;
        } else {
            var ans: ListNode = reverseListRecursive(curr.next, curr);
            curr.next = prev;
            return ans;
        }
    }
}