package test.hp.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumsTest {

    @Test
    void addTwoNumbers() {
        ListNode l1 = new ListNode(3);
        l1.val = 342;
        ListNode l2 = new ListNode(3);
        l2.val = 465;
        ListNode l3 = new AddTwoNums().addTwoNumbers(l1, l2);
        assertEquals(7, l3.val);
        assertEquals(0, l3.next.val);
    }
}