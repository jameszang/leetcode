// https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	carry := 0
	dummyHead := &ListNode{}
	prev := dummyHead
	var curr *ListNode = nil

	for l1 != nil && l2 != nil {
		temp := l1.Val + l2.Val + carry
		if temp >= 10 {
			temp, carry = temp-10, 1
		} else {
			carry = 0
		}
		curr = &ListNode{temp, nil}
		prev.Next = curr
		prev = prev.Next
		curr = nil
		l1 = l1.Next
		l2 = l2.Next
	}

	var survivor *ListNode = nil
	if l1 != nil {
		survivor = l1
	} else if l2 != nil {
		survivor = l2
	}

	for survivor != nil {
		temp := survivor.Val + carry
		if temp >= 10 {
			temp, carry = temp-10, 1
		} else {
			carry = 0
		}
		curr = &ListNode{temp, nil}
		prev.Next = curr
		prev = prev.Next
		curr = nil
		survivor = survivor.Next
	}

	if carry != 0 {
		curr = &ListNode{carry, nil}
		prev.Next = curr
	}

	return dummyHead.Next
}