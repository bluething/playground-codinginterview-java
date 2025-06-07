package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _155_minStackTest {
    @Test
    void case01() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMin());
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(-2, minStack.getMin());
    }

    class MinStack {

        private Node top;

        public MinStack() {

        }

        public void push(int val) {
            if (top == null) {
                top = new Node(val, val, null);
            } else {
                top = new Node(val, Math.min(val, top.min), top);
            }
        }

        public void pop() {
            top = top.next;
        }

        public int top() {
            return top.val;
        }

        public int getMin() {
            return top.min;
        }

        class Node {
            private final int val;
            private int min;
            Node next;

            Node(int val, int min, Node next) {
                this.val = val;
                this.min = min;
                this.next = next;
            }
        }
    }
}
