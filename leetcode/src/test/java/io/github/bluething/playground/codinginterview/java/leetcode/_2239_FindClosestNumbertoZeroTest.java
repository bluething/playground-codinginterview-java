package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _2239_FindClosestNumbertoZeroTest {
    @Test
    void case01() {
        // Input: nums = [-4,-2,1,4,8]
        // Distances: |-4|=4, |-2|=2, |1|=1, |4|=4, |8|=8
        // Closest to zero: 1 (distance = 1)
        int[] nums = {-4, -2, 1, 4, 8};
        int expected = 1;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: nums = [2,-1,1]
        // Distances: |2|=2, |-1|=1, |1|=1
        // Both -1 and 1 have distance 1, return the positive one (1)
        int[] nums = {2, -1, 1};
        int expected = 1;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Single element array
        int[] nums = {5};
        int expected = 5;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Array with zero
        int[] nums = {-3, 0, 2};
        int expected = 0;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // All negative numbers
        int[] nums = {-10, -5, -2, -1};
        int expected = -1;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // All positive numbers
        int[] nums = {1, 3, 5, 7, 9};
        int expected = 1;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Multiple numbers with same distance (tie-breaker: choose positive)
        int[] nums = {-3, -3, 3, 3};
        int expected = 3;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Two elements: positive and negative with same absolute value
        int[] nums = {-5, 5};
        int expected = 5;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // Two elements: both negative
        int[] nums = {-7, -3};
        int expected = -3;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Two elements: both positive
        int[] nums = {2, 8};
        int expected = 2;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Large array with mixed values
        int[] nums = {-100, -50, -10, 5, 15, 25, 100};
        int expected = 5;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case12() {
        // Array where the closest is negative (no positive counterpart)
        int[] nums = {-2, -4, -6, 10};
        int expected = -2;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case13() {
        // Array with duplicates of the closest number
        int[] nums = {1, 1, -1, -1, 2};
        int expected = 1;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case14() {
        // Edge case: very large numbers
        int[] nums = {1000000, -999999, 500000};
        int expected = -999999;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case15() {
        // Multiple zeros in array
        int[] nums = {0, 0, 0};
        int expected = 0;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case16() {
        // Mix of zero and other numbers
        int[] nums = {-1, 0, 1, 2};
        int expected = 0;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case17() {
        // Only one negative and one positive (different absolute values)
        int[] nums = {-10, 3};
        int expected = 3;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    @Test
    void case18() {
        // Tie between negative and positive, ensure positive is chosen
        int[] nums = {-2, 2, -5, 5, -1, 1};
        int expected = 1;
        int result = findClosestNumber(nums);
        assertEquals(expected, result);
    }

    private int findClosestNumber(int[] nums) {
        return 0;
    }
}
