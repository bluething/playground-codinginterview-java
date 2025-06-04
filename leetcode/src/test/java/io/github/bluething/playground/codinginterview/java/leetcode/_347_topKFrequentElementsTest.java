package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _347_topKFrequentElementsTest {
    @Test
    void case01() {
        Assertions.assertArrayEquals(new int[]{1,2}, topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    @Test
    void case02() {
        Assertions.assertArrayEquals(new int[]{1}, topKFrequent(new int[]{1}, 1));
    }

    private int[] topKFrequent(int[] nums, int k) {
        return new int[]{};
    }
}
