package test.hp.leetcode;
/**
 * 206. 反转链表
 * 反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
 * @author hp
 *
 */
public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode curr = head;
		ListNode pre = null;
		ListNode next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = pre;
			pre = curr;
			curr = next;
		}
        return pre;
    }
}
