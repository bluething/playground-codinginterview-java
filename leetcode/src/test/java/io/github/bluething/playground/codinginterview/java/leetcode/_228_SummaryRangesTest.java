package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _228_SummaryRangesTest {
    @Test
    void case01() {
        // Input: nums = [0,1,2,4,5,7]
        // Ranges: [0,1,2] -> "0->2", [4,5] -> "4->5", [7] -> "7"
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> expected = Arrays.asList("0->2", "4->5", "7");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: nums = [0,2,3,4,6,8,9]
        // Ranges: [0] -> "0", [2,3,4] -> "2->4", [6] -> "6", [8,9] -> "8->9"
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> expected = Arrays.asList("0", "2->4", "6", "8->9");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Empty array
        int[] nums = {};
        List<String> expected = Collections.emptyList();
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Single element
        int[] nums = {5};
        List<String> expected = Arrays.asList("5");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // All consecutive numbers
        int[] nums = {1, 2, 3, 4, 5};
        List<String> expected = Arrays.asList("1->5");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // All non-consecutive numbers (each number is its own range)
        int[] nums = {1, 3, 5, 7, 9};
        List<String> expected = Arrays.asList("1", "3", "5", "7", "9");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Two consecutive numbers
        int[] nums = {1, 2};
        List<String> expected = Arrays.asList("1->2");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Two non-consecutive numbers
        int[] nums = {1, 3};
        List<String> expected = Arrays.asList("1", "3");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // Array with negative numbers
        int[] nums = {-3, -2, -1, 1, 2, 4};
        List<String> expected = Arrays.asList("-3->-1", "1->2", "4");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Array with mix of negative, zero, and positive
        int[] nums = {-2, -1, 0, 1, 3, 4, 5};
        List<String> expected = Arrays.asList("-2->1", "3->5");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Large consecutive range
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> expected = Arrays.asList("0->9");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case12() {
        // Multiple single elements and ranges mixed
        int[] nums = {1, 3, 4, 5, 7, 10, 11, 15};
        List<String> expected = Arrays.asList("1", "3->5", "7", "10->11", "15");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case13() {
        // Array starting with zero
        int[] nums = {0, 1, 2};
        List<String> expected = Arrays.asList("0->2");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case14() {
        // Array with only negative numbers
        int[] nums = {-5, -4, -3, -1};
        List<String> expected = Arrays.asList("-5->-3", "-1");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case15() {
        // Large gaps between numbers
        int[] nums = {1, 10, 20, 30};
        List<String> expected = Arrays.asList("1", "10", "20", "30");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case16() {
        // Edge case: Integer boundaries
        int[] nums = {-2147483648, -2147483647, 2147483646, 2147483647};
        List<String> expected = Arrays.asList("-2147483648->-2147483647", "2147483646->2147483647");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case17() {
        // Single range at the beginning, then isolated numbers
        int[] nums = {1, 2, 3, 10, 20, 30};
        List<String> expected = Arrays.asList("1->3", "10", "20", "30");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case18() {
        // Isolated numbers at the beginning, then a range
        int[] nums = {1, 5, 10, 11, 12, 13};
        List<String> expected = Arrays.asList("1", "5", "10->13");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case19() {
        // Only zero
        int[] nums = {0};
        List<String> expected = Arrays.asList("0");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case20() {
        // Complex pattern with alternating ranges and singles
        int[] nums = {1, 2, 4, 5, 6, 8, 10, 11, 15, 16, 17, 20};
        List<String> expected = Arrays.asList("1->2", "4->6", "8", "10->11", "15->17", "20");
        List<String> result = summaryRanges(nums);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    private List<String> summaryRanges(int[] nums) {
        return List.of();
    }
}
