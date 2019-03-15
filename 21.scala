// https://leetcode.com/problems/merge-two-sorted-lists/

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
        var first = l1;
        var second = l2;
        var dummyHead: ListNode = ListNode(0);
        var curr: ListNode = dummyHead;
        while (first != null || second != null) {
            var firstIsSmaller: Boolean = false;         
            if (first != null && second == null) {
                firstIsSmaller = true;
            } else if (second != null && first == null) {
                firstIsSmaller = false;
            } else if (first.x <= second.x) {
                firstIsSmaller = true;
            } else {
                firstIsSmaller = false;
            }
            
            if (firstIsSmaller) {
                curr.next = ListNode(first.x);
                first = first.next;
            } else {
                curr.next = ListNode(second.x);
                second = second.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }
}