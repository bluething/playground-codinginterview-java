package io.github.bluething.playground.codinginterview.java.hackerrank;

import java.util.Stack;

class QueueUsingTwoStacksTest {
    static class MyQueue {
        Stack<Long> lifo;
        Stack<Long> fifo;
        long front;

        public MyQueue() {
            lifo = new Stack<>();
            fifo = new Stack<>();
        }

        public boolean isEmpty() {
            return lifo.isEmpty() || fifo.isEmpty();
        }

        public void enqueue(long val) {
            if (lifo.isEmpty()) {
                front = val;
            }
            lifo.push(val);
        }
        public long dequeue() {
            if (fifo.isEmpty()) {
                while (!lifo.isEmpty()) {
                    fifo.push(lifo.pop());
                }
            }
            return fifo.pop();
        }
        public long peek() {
            if (!fifo.isEmpty()) {
                return fifo.peek();
            }
            return front;
        }
    }
}
