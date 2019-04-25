package test.hp.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
Example 1:
Input: 1->2->3->4->5->NULL, k = 2
Output: 4->5->1->2->3->NULL
Explanation:
rotate 1 steps to the right: 5->1->2->3->4->NULL
rotate 2 steps to the right: 4->5->1->2->3->NULL
Example 2:

Input: 0->1->2->NULL, k = 4
Output: 2->0->1->NULL
Explanation:
rotate 1 steps to the right: 2->0->1->NULL
rotate 2 steps to the right: 1->2->0->NULL
rotate 3 steps to the right: 0->1->2->NULL
rotate 4 steps to the right: 2->0->1->NULL
 * @author hp
 *
 */
public class RotateList {
	
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		ListNode copy = head;
        int length = 1;
        while(copy.next != null){
        	length ++;
        	copy = copy.next;
        }
        if(k == length) {
        	return head;
        }
        if(k > length) {
        	k = k % length;
        }
        copy.next = head;
        for(int i = length - k; i > 1; i --) {
        	head = head.next;
        }
        copy = head.next;
        head.next = null;
        return copy;
    }

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
