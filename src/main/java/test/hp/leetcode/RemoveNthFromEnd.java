package test.hp.leetcode;


/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.
当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：
给定的 n 保证是有效的。
进阶：
你能尝试使用一趟扫描实现吗？
 * @author heping
 *
 */
public class RemoveNthFromEnd {

	public RemoveNthFromEnd() {
		// TODO Auto-generated constructor stub
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head.next == null){
            return null;
        }
        int length = 1;
		ListNode temp = head;
		ListNode result = head;
		while(temp.next != null) {
			temp = temp.next;
			length ++;
		}
		if(n == length) {
            return head.next;
		}else {
			int index = length - n;
			for(int i = 1; i < index; i ++) {
				head = head.next;
			}
            head.next = head.next.next;
		}
        return result;
    }
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
