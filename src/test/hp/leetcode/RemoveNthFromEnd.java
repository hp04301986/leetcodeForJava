package test.hp.leetcode;


/**
 * ����һ������ɾ������ĵ����� n ���ڵ㣬���ҷ��������ͷ��㡣
ʾ����

����һ������: 1->2->3->4->5, �� n = 2.
��ɾ���˵����ڶ����ڵ�������Ϊ 1->2->3->5.
˵����
������ n ��֤����Ч�ġ�
���ף�
���ܳ���ʹ��һ��ɨ��ʵ����
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
