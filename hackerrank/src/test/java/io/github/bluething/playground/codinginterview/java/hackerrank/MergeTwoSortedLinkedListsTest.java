package io.github.bluething.playground.codinginterview.java.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeTwoSortedLinkedListsTest {
    @Test
    void case01() {
        SinglyLinkedListNode a7 = new SinglyLinkedListNode(7);
        SinglyLinkedListNode a3 = new SinglyLinkedListNode(3, a7);
        SinglyLinkedListNode a1 = new SinglyLinkedListNode(1, a3);

        SinglyLinkedListNode b2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode b1 = new SinglyLinkedListNode(1, b2);

        SinglyLinkedListNode merged = mergeLists(a1, b1);

        SinglyLinkedListNode merged7 = new SinglyLinkedListNode(7);
        SinglyLinkedListNode merged3 = new SinglyLinkedListNode(3, merged7);
        SinglyLinkedListNode merged2 = new SinglyLinkedListNode(2, merged3);
        SinglyLinkedListNode merged12 = new SinglyLinkedListNode(1, merged2);
        SinglyLinkedListNode merged11 = new SinglyLinkedListNode(1, merged12);

        Assertions.assertEquals(merged, merged11);
    }
    @Test
    void case02() {
        SinglyLinkedListNode a2 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode a1 = new SinglyLinkedListNode(1, a2);
        SinglyLinkedListNode a3 = new SinglyLinkedListNode(3, a1);

        SinglyLinkedListNode b4 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode b3 = new SinglyLinkedListNode(3, b4);
        SinglyLinkedListNode b2 = new SinglyLinkedListNode(2, b3);

        SinglyLinkedListNode merged = mergeLists(a1, b2);

        SinglyLinkedListNode merged4 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode merged32 = new SinglyLinkedListNode(3, merged4);
        SinglyLinkedListNode merged31 = new SinglyLinkedListNode(3, merged32);
        SinglyLinkedListNode merged2 = new SinglyLinkedListNode(2, merged31);
        SinglyLinkedListNode merged1 = new SinglyLinkedListNode(1, merged2);

        Assertions.assertEquals(merged, merged1);
    }

    private SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        return null;
    }
}
