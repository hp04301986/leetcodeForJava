package test.hp.leetcode;

/**
 * ����һ���������������������ڵĽڵ㣬�����ؽ����������

ʾ��:

���� 1->2->3->4, ��Ӧ�÷��� 2->1->4->3.
˵��:

����㷨ֻ��ʹ�ó����Ķ���ռ䡣
�㲻��ֻ�ǵ����ĸı�ڵ��ڲ���ֵ��������Ҫʵ�ʵĽ��нڵ㽻����
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


