package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class _217_containsduplicatetest {
    @Test
    void case01() {
        Assertions.assertTrue(containsDuplicate(new int[]{1,2,3,1}));
    }
    @Test
    void case02() {
        Assertions.assertFalse(containsDuplicate(new int[]{1,2,3,4}));
    }
    @Test
    void case03() {
        Assertions.assertTrue(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    private boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
