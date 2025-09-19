package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _2657_FindthePrefixCommonArrayofTwoArraysTest {
    @Test
    void case01() {
        // Input: A = [1,3,2,4], B = [3,1,2,4]
        // i=0: A=[1], B=[3] → common: [] → count = 0
        // i=1: A=[1,3], B=[3,1] → common: [1,3] → count = 2
        // i=2: A=[1,3,2], B=[3,1,2] → common: [1,2,3] → count = 3
        // i=3: A=[1,3,2,4], B=[3,1,2,4] → common: [1,2,3,4] → count = 4
        int[] A = {1, 3, 2, 4};
        int[] B = {3, 1, 2, 4};
        int[] expected = {0, 2, 3, 4};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: A = [2,3,1], B = [3,1,2]
        // i=0: A=[2], B=[3] → common: [] → count = 0
        // i=1: A=[2,3], B=[3,1] → common: [3] → count = 1
        // i=2: A=[2,3,1], B=[3,1,2] → common: [1,2,3] → count = 3
        int[] A = {2, 3, 1};
        int[] B = {3, 1, 2};
        int[] expected = {0, 1, 3};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case03() {
        // Single element arrays
        int[] A = {1};
        int[] B = {1};
        int[] expected = {1};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case04() {
        // Single element arrays - different elements
        int[] A = {1};
        int[] B = {2};
        int[] expected = {0};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case05() {
        // Identical arrays
        int[] A = {1, 2, 3};
        int[] B = {1, 2, 3};
        int[] expected = {1, 2, 3};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case06() {
        // Completely reversed arrays
        int[] A = {1, 2, 3};
        int[] B = {3, 2, 1};
        // i=0: A=[1], B=[3] → common: [] → count = 0
        // i=1: A=[1,2], B=[3,2] → common: [2] → count = 1
        // i=2: A=[1,2,3], B=[3,2,1] → common: [1,2,3] → count = 3
        int[] expected = {0, 1, 3};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case07() {
        // Two element arrays - same order
        int[] A = {1, 2};
        int[] B = {1, 2};
        int[] expected = {1, 2};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case08() {
        // Two element arrays - reverse order
        int[] A = {1, 2};
        int[] B = {2, 1};
        // i=0: A=[1], B=[2] → common: [] → count = 0
        // i=1: A=[1,2], B=[2,1] → common: [1,2] → count = 2
        int[] expected = {0, 2};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case09() {
        // No common elements until the end
        int[] A = {1, 2, 3, 4};
        int[] B = {4, 3, 2, 1};
        // i=0: A=[1], B=[4] → common: [] → count = 0
        // i=1: A=[1,2], B=[4,3] → common: [] → count = 0
        // i=2: A=[1,2,3], B=[4,3,2] → common: [2,3] → count = 2
        // i=3: A=[1,2,3,4], B=[4,3,2,1] → common: [1,2,3,4] → count = 4
        int[] expected = {0, 0, 2, 4};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case10() {
        // Gradual increase in common elements
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {5, 1, 4, 2, 3};
        // i=0: A=[1], B=[5] → common: [] → count = 0
        // i=1: A=[1,2], B=[5,1] → common: [1] → count = 1
        // i=2: A=[1,2,3], B=[5,1,4] → common: [1] → count = 1
        // i=3: A=[1,2,3,4], B=[5,1,4,2] → common: [1,2,4] → count = 3
        // i=4: A=[1,2,3,4,5], B=[5,1,4,2,3] → common: [1,2,3,4,5] → count = 5
        int[] expected = {0, 1, 1, 3, 5};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case11() {
        // All elements appear in first position
        int[] A = {3, 1, 2};
        int[] B = {3, 2, 1};
        // i=0: A=[3], B=[3] → common: [3] → count = 1
        // i=1: A=[3,1], B=[3,2] → common: [3] → count = 1
        // i=2: A=[3,1,2], B=[3,2,1] → common: [1,2,3] → count = 3
        int[] expected = {1, 1, 3};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case12() {
        // Pattern with early matches
        int[] A = {2, 1, 3, 4};
        int[] B = {1, 2, 4, 3};
        // i=0: A=[2], B=[1] → common: [] → count = 0
        // i=1: A=[2,1], B=[1,2] → common: [1,2] → count = 2
        // i=2: A=[2,1,3], B=[1,2,4] → common: [1,2] → count = 2
        // i=3: A=[2,1,3,4], B=[1,2,4,3] → common: [1,2,3,4] → count = 4
        int[] expected = {0, 2, 2, 4};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case13() {
        // Longer array with mixed pattern
        int[] A = {1, 4, 2, 3, 6, 5};
        int[] B = {2, 1, 3, 4, 5, 6};
        // i=0: A=[1], B=[2] → common: [] → count = 0
        // i=1: A=[1,4], B=[2,1] → common: [1] → count = 1
        // i=2: A=[1,4,2], B=[2,1,3] → common: [1,2] → count = 2
        // i=3: A=[1,4,2,3], B=[2,1,3,4] → common: [1,2,3,4] → count = 4
        // i=4: A=[1,4,2,3,6], B=[2,1,3,4,5] → common: [1,2,3,4] → count = 4
        // i=5: A=[1,4,2,3,6,5], B=[2,1,3,4,5,6] → common: [1,2,3,4,5,6] → count = 6
        int[] expected = {0, 1, 2, 4, 4, 6};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case14() {
        // Pattern where common count decreases then increases
        int[] A = {1, 3, 2, 5, 4};
        int[] B = {1, 2, 3, 4, 5};
        // i=0: A=[1], B=[1] → common: [1] → count = 1
        // i=1: A=[1,3], B=[1,2] → common: [1] → count = 1
        // i=2: A=[1,3,2], B=[1,2,3] → common: [1,2,3] → count = 3
        // i=3: A=[1,3,2,5], B=[1,2,3,4] → common: [1,2,3] → count = 3
        // i=4: A=[1,3,2,5,4], B=[1,2,3,4,5] → common: [1,2,3,4,5] → count = 5
        int[] expected = {1, 1, 3, 3, 5};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case15() {
        // Alternating common elements
        int[] A = {1, 2, 3, 4};
        int[] B = {2, 3, 4, 1};
        // i=0: A=[1], B=[2] → common: [] → count = 0
        // i=1: A=[1,2], B=[2,3] → common: [2] → count = 1
        // i=2: A=[1,2,3], B=[2,3,4] → common: [2,3] → count = 2
        // i=3: A=[1,2,3,4], B=[2,3,4,1] → common: [1,2,3,4] → count = 4
        int[] expected = {0, 1, 2, 4};
        int[] result = findThePrefixCommonArray(A, B);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    private int[] findThePrefixCommonArray(int[] A, int[] B) {
        return new int[]{};
    }
}
