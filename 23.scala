// https://leetcode.com/problems/merge-k-sorted-lists/

import scala.collection.mutable.PriorityQueue

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def mergeKLists(lists: Array[ListNode]): ListNode = {
        var pq: PriorityQueue[Int] = PriorityQueue()(Ordering[Int].reverse);
        for (i <- lists) {
            var j: ListNode = i;
            while (j != null) {
                pq.enqueue(j.x); 
                j = j.next;
            }
        }
        var dummyHead: ListNode = ListNode(0);
        var curr: ListNode = dummyHead;
        while (!pq.isEmpty) {
            curr.next = ListNode(pq.dequeue());
            curr = curr.next;
        }
        return dummyHead.next;
    }
}