package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _19_removeNthNodeFromEndOfListTest extends _00_ParentTest{
    @Test
    void case01() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        removeNthFromEnd(node1, 2);
        printLinkedList(node1);
        Assertions.assertEquals("1235", output.toString());
    }

    @Test
    void case02() {
        ListNode node1 = new ListNode(1);
        removeNthFromEnd(node1, 1);
        printLinkedList(node1);
        Assertions.assertEquals("", output.toString());
    }

    @Test
    void case03() {
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        removeNthFromEnd(node1, 1);
        printLinkedList(node1);
        Assertions.assertEquals("1", output.toString());
    }

    void printLinkedList(ListNode head) {
        if (head == null) {
            System.out.printf("");
            return;
        }
        while (head != null) {
            System.out.printf("%d", head.val);
            head = head.next;
        }
    }

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode left = dummyHead;
        ListNode right = head;
        while (n > 0) {
            right = right.next;
            n--;
        }
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        // remove the node
        left.next = left.next.next;
        return dummyHead.next;
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
