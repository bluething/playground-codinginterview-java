package io.github.bluething.playground.codinginterview.java.hackerrank;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;

    public SinglyLinkedListNode() {
    }

    public SinglyLinkedListNode(int data) {
        this.data = data;
    }

    public SinglyLinkedListNode(int data, SinglyLinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public SinglyLinkedListNode getNext() {
        return next;
    }
}
