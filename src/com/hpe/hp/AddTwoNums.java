package com.hpe.hp;

/**
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 * @author pihe
 *
 */
public class AddTwoNums {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode prev = new ListNode(0);
        ListNode head = prev;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
        	ListNode cur = l1 !=null ? l1 : (l2 != null ? l2 : (new ListNode(0)));
            int sum = ((l2 == null) ? 0 : l2.val) + ((l1 == null) ? 0 : l1.val) + carry;
            cur.val = sum % 10;
            carry = sum / 10;
            prev.next = cur;
            prev = cur;
            
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
        }
        return head.next;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		l1.val = 342;
		ListNode l2 = new ListNode(3);
		l2.val = 465;
		ListNode result = new AddTwoNums().addTwoNumbers(l1, l2);
		System.out.println(result.val+", "+ result.next.val + ", "+result.next.next.val);
	}

}
