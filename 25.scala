// https://leetcode.com/problems/reverse-nodes-in-k-group/

import scala.util.control._

/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */
object Solution {
    def reverseKGroup(head: ListNode, k: Int): ListNode = {
        // short circuit trivial case
        if (head == null) {
            return null;
        }
        
        // initialize curr and probe
        // curr points to head of current sublist to reverse
        // probe points to head of next sublist to reverse, if any
        var curr: ListNode = head;
        var probe: ListNode = curr;

        // after this for loop executes, probe will point to the node BEFORE the head of the next sublist to reverse
        // note: 1 UNTIL k, not 1 TO k
        for (i <- 1 until k) {
            probe = probe.next;
            if (probe == null) {
                return head;
            }
        }
        // now probe points to the head of the next sublist to reverse
        probe = probe.next;
        
        // reverse current sublist and store new head in return variable
        var ans = reverseList(curr, null, 0, k);
        
        // short circuit if there is no next sublist to reverse
        if (probe == null) {
            return ans;
        }

        // iterate until a break
        // for each iteration of the loop:
        //      - updates curr to equal probe
        //      - attempts to update probe
        //      - 
        val outer = new Breaks;
        outer.breakable {
            while (true) {
                // store curr in a variable to fix it's next pointer later
                var temp: ListNode = curr;
                
                // short circuit if there's nothing else to reverse
                if (probe == null) {
                    outer.break;
                }
                
                // set the new curr and probe
                curr = probe;
                var sublistHasKElements: Boolean = true;
                val inner = new Breaks;
                inner.breakable {
                    // after this for loop executes, probe will point to the node BEFORE the head of the next sublist to reverse
                    for (i <- 1 until k) {
                        probe = probe.next;
                        if (probe == null) {
                            sublistHasKElements = false;
                            inner.break;
                        }
                    }
                }
                
                if (sublistHasKElements) {
                    // now probe points to the head of the next sublist to reverse
                    probe = probe.next;
                    temp.next = reverseList(curr, null, 0, k);
                } else {
                    // sublist does not have enough elements, so do not reverse. attach the remainder of the original list and then break
                    temp.next = curr;
                    outer.break;
                }
            }
        }
        return ans;
    }
    
    // reverse count nodes starting at curr
    def reverseList(curr: ListNode, prev: ListNode, count: Int, target: Int): ListNode = {
        if (count + 1 >= target || curr.next == null) {
            curr.next = prev;
            return curr;
        } else {
            var ans: ListNode = reverseList(curr.next, curr, count + 1, target);
            curr.next = prev;
            return ans;
        }
    }
}