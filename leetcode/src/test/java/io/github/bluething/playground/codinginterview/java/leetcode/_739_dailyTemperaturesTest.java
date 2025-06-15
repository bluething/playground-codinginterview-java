package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class _739_dailyTemperaturesTest {
    @Test
    void case01() {
        Assertions.assertArrayEquals(new int[]{1,1,4,2,1,1,0,0}, dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

    @Test
    void case02() {
        Assertions.assertArrayEquals(new int[]{1,1,1,0}, dailyTemperatures(new int[]{30,40,50,60}));
    }

    @Test
    void case03() {
        Assertions.assertArrayEquals(new int[]{1,1,0}, dailyTemperatures(new int[]{30,60,90}));
    }

    private int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] timeToWait = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < currTemp) {
                int idx = stack.pop();
                timeToWait[idx] = i - idx;
            }
            stack.push(i);
        }
        return timeToWait;
    }
}
