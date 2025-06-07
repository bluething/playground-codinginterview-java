package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _141_linkedListCycleTest {
    @Test
    void case01() {
        ListNode minus4 = new ListNode(-4);
        ListNode zero = new ListNode(0, minus4);
        ListNode two = new ListNode(2, zero);
        minus4.next = two;
        ListNode three = new ListNode(3, two);
        Assertions.assertTrue(hasCycle(three));
    }

    @Test
    void case02() {
        ListNode two = new ListNode(2);
        ListNode one = new ListNode(1, two);
        two.next = one;
        Assertions.assertTrue(hasCycle(one));
    }

    @Test
    void case03() {
        ListNode one = new ListNode(1);
        Assertions.assertFalse(hasCycle(one));
    }

    private boolean hasCycle(ListNode head) {
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
