package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class _15_3SumTest {
    @Test
    public void case01() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(-1,-1,2),
                Arrays.asList(-1,0,1));
        Assertions.assertEquals(expected, threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    @Test
    public void case02() {
        List<List<Integer>> expected = Collections.emptyList();
        Assertions.assertEquals(expected, threeSum(new int[]{0,1,1}));
    }

    @Test
    public void case03() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(0,0,0));
        Assertions.assertEquals(expected, threeSum(new int[]{0,0,0}));
    }

    private List<List<Integer>> threeSum(int[] nums) {
        return Collections.emptyList();
    }

}
