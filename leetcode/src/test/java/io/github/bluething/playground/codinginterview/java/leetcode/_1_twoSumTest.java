package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class _1_twoSumTest {
    @Test
    public void case01() {
        int[] expected = new int[]{0,1};
        Assertions.assertArrayEquals(expected, twoSum(new int[]{2,7,11,15}, 9));
    }

    @Test
    public void case02() {
        int[] expected = new int[]{1,2};
        Assertions.assertArrayEquals(expected, twoSum(new int[]{3,2,4}, 6));
    }

    @Test
    public void case03() {
        int[] expected = new int[]{0,1};
        Assertions.assertArrayEquals(expected, twoSum(new int[]{3,3}, 6));
    }

    private int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (complements.containsKey(complement)) {
                return new int[]{complements.get(complement), i};
            }
            complements.put(nums[i], i);
        }
        return new int[]{};
    }
}
