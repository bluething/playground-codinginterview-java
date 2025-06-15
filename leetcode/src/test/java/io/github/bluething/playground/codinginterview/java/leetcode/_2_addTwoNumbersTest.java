package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _2_addTwoNumbersTest extends _00_ParentTest {
    @Test
    void case01() {
        ListNode three1 = new ListNode(3);
        ListNode four1 = new ListNode(4, three1);
        ListNode two1 = new ListNode(2, four1);

        ListNode four2 = new ListNode(4);
        ListNode six2 = new ListNode(6, four2);
        ListNode five2 = new ListNode(5, six2);

        ListNode result = addTwoNumbers(two1, five2);
        printLinkedList(result);
        Assertions.assertEquals("708", output.toString());
    }

    @Test
    void case02() {
        ListNode zero1 = new ListNode(0);

        ListNode zero2 = new ListNode(0);

        ListNode result = addTwoNumbers(zero1, zero2);
        printLinkedList(result);
        Assertions.assertEquals("0", output.toString());
    }

    @Test
    void case03() {
        ListNode nine17 = new ListNode(9);
        ListNode nine16 = new ListNode(9, nine17);
        ListNode nine15 = new ListNode(9, nine16);
        ListNode nine14 = new ListNode(9, nine15);
        ListNode nine13 = new ListNode(9, nine14);
        ListNode nine12 = new ListNode(9, nine13);
        ListNode nine1 = new ListNode(9, nine12);

        ListNode nine23 = new ListNode(9);
        ListNode nine22 = new ListNode(9, nine23);
        ListNode nine21 = new ListNode(9, nine22);
        ListNode nine2 = new ListNode(9, nine21);

        ListNode result = addTwoNumbers(nine1, nine2);
        printLinkedList(result);
        Assertions.assertEquals("89990001", output.toString());
    }


    void printLinkedList(ListNode head) {
        while (head != null) {
            System.out.printf("%d", head.val);
            head = head.next;
        }
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        // each of their nodes contains a single digit
        // then we need aware about the carrier
        int carry = 0;
        // carry != 0
        // there are case when sum from last node have a carrier
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
        }

        return head.next;
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
