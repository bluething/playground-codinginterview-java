package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class _155_minStack2Test {
    @Test
    void case01() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Assertions.assertEquals(-3, minStack.getMins());
        minStack.pop();
        Assertions.assertEquals(0, minStack.top());
        Assertions.assertEquals(-2, minStack.getMins());
    }

    class MinStack {
        private int[] stack;
        private int[] mins;
        private int size;
        private final int INITIAL_CAPACITY = 16;

        public MinStack() {
            stack = new int[INITIAL_CAPACITY];
            mins = new int[INITIAL_CAPACITY];
            size = 0;
        }

        private void ensureCapacity() {
            if (size == stack.length) {
                int newSize = stack.length * 2;
                stack = Arrays.copyOf(stack, newSize);
                mins = Arrays.copyOf(mins, newSize);
            }
        }

        public void push(int val) {
            ensureCapacity();
            stack[size] = val;
            mins[size] = (size == 0) ? val : Math.min(mins[size - 1], val);
            size++;
        }

        public void pop() {
            size--;
        }

        public int top() {
            return stack[size-1];
        }

        public int getMins() {
            return mins[size-1];
        }
    }
}
