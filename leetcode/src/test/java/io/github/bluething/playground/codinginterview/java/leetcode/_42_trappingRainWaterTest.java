package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _42_trappingRainWaterTest {
    @Test
    void case01() {
        Assertions.assertEquals(6, trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    @Test
    void case02() {
        Assertions.assertEquals(9, trap(new int[]{4,2,0,3,2,5}));
    }

    private int trap(int[] height) {
        return 0;
    }
}
