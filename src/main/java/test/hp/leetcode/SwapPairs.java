package test.hp.leetcode;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
说明:

你的算法只能使用常数的额外空间。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * @author heping
 *
 */
public class SwapPairs {

	public SwapPairs() {
		// TODO Auto-generated constructor stub
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	public ListNode swapPairs(ListNode head) {
        ListNode virtual = new ListNode(0);
        virtual.next = head;
        ListNode cur = head;
        ListNode pre = virtual;
        while(cur != null && cur.next != null) {
        	pre.next = cur.next;
        	pre = cur;
        	cur = cur.next.next;
        	pre.next.next = pre;
        }
        pre.next = cur;
        return virtual.next;
    }
}


