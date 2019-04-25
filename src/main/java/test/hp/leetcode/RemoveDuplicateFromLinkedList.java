package test.hp.leetcode;
/**
 * 82. 删除排序链表中的重复元素 II
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
示例 1:
输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:
输入: 1->1->1->2->3
输出: 2->3

83. 删除排序链表中的重复元素
给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
示例 1:
输入: 1->1->2
输出: 1->2
示例 2:
输入: 1->1->2->3->3
输出: 1->2->3
 * @author hp
 *
 */
public class RemoveDuplicateFromLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode deleteDuplicates(ListNode head) {
		ListNode fakehead = new ListNode(-1);
		fakehead.next = head;
		ListNode prior = fakehead;
		ListNode real = head;
        while((real != null ) && (real.next != null)) {
        	if(prior.next.val== real.next.val) {
        		real = real.next.next;
        		while(real != null && real.val == prior.next.val) {
        			real = real.next;
        		}
        		prior.next = real;
        	}else {
        		prior = prior.next;
        		real = real.next;
        	}
        }
        return fakehead.next;
    }
	public ListNode removeDuplicates(ListNode head) {
		ListNode tmp = head;
		while((tmp != null) && (tmp.next != null)) {
			if(tmp.val == tmp.next.val) {
				tmp.next= tmp.next.next;
			}else tmp = tmp.next;
		}
        return head;
    }
}
