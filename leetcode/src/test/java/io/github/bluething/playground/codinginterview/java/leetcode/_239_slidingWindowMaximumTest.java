package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _239_slidingWindowMaximumTest {
    @Test
    void case01() {
        Assertions.assertArrayEquals(new int[]{3,3,5,5,6,7}, maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
    }
    @Test
    void case02() {
        Assertions.assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1}, 1));
    }
    private int[] maxSlidingWindow(int[] nums, int k) {
        return null;
    }
}
