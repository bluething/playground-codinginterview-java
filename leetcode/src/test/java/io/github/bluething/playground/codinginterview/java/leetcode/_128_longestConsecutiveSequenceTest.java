package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _128_longestConsecutiveSequenceTest {
    @Test
    void case01() {
        Assertions.assertEquals(4, longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    @Test
    void case02() {
        Assertions.assertEquals(9, longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    @Test
    void case03() {
        Assertions.assertEquals(3, longestConsecutive(new int[]{1,0,-1}));
    }
    private int longestConsecutive(int[] nums) {
        return 0;
    }
}
