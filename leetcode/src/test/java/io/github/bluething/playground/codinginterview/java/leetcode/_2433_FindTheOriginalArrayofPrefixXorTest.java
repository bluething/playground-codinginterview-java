package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _2433_FindTheOriginalArrayofPrefixXorTest {
    @Test
    void case01() {
        // Input: pref = [5,2,0,3,1]
        // arr[0] = pref[0] = 5
        // arr[1] = pref[1] ^ pref[0] = 2 ^ 5 = 7
        // arr[2] = pref[2] ^ pref[1] = 0 ^ 2 = 2
        // arr[3] = pref[3] ^ pref[2] = 3 ^ 0 = 3
        // arr[4] = pref[4] ^ pref[3] = 1 ^ 3 = 2
        // Result: [5,7,2,3,2]
        int[] pref = {5, 2, 0, 3, 1};
        int[] expected = {5, 7, 2, 3, 2};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: pref = [13]
        // Single element: arr[0] = pref[0] = 13
        int[] pref = {13};
        int[] expected = {13};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case03() {
        // Two elements
        // pref = [4, 6] means:
        // arr[0] = 4
        // arr[1] = 6 ^ 4 = 2 (since 4 ^ 2 = 6)
        int[] pref = {4, 6};
        int[] expected = {4, 2};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case04() {
        // All zeros
        int[] pref = {0, 0, 0};
        int[] expected = {0, 0, 0};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case05() {
        // Prefix array with increasing pattern
        // pref = [1, 3, 7] means:
        // arr[0] = 1
        // arr[1] = 3 ^ 1 = 2
        // arr[2] = 7 ^ 3 = 4
        int[] pref = {1, 3, 7};
        int[] expected = {1, 2, 4};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case06() {
        // Same value in prefix array
        // pref = [5, 5] means:
        // arr[0] = 5
        // arr[1] = 5 ^ 5 = 0
        int[] pref = {5, 5};
        int[] expected = {5, 0};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case07() {
        // Multiple same values
        // pref = [7, 7, 7, 7] means:
        // arr[0] = 7
        // arr[1] = 7 ^ 7 = 0
        // arr[2] = 7 ^ 7 = 0
        // arr[3] = 7 ^ 7 = 0
        int[] pref = {7, 7, 7, 7};
        int[] expected = {7, 0, 0, 0};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case08() {
        // Alternating pattern
        // pref = [3, 0, 3, 0] means:
        // arr[0] = 3
        // arr[1] = 0 ^ 3 = 3
        // arr[2] = 3 ^ 0 = 3
        // arr[3] = 0 ^ 3 = 3
        int[] pref = {3, 0, 3, 0};
        int[] expected = {3, 3, 3, 3};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case09() {
        // Powers of 2
        // pref = [1, 3, 1, 5] means:
        // arr[0] = 1
        // arr[1] = 3 ^ 1 = 2
        // arr[2] = 1 ^ 3 = 2
        // arr[3] = 5 ^ 1 = 4
        int[] pref = {1, 3, 1, 5};
        int[] expected = {1, 2, 2, 4};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case10() {
        // Large numbers
        // pref = [100, 150, 200] means:
        // arr[0] = 100
        // arr[1] = 150 ^ 100 = 250 (since 100 ^ 250 = 150)
        // arr[2] = 200 ^ 150 = 110 (since 150 ^ 110 = 200)
        int[] pref = {100, 150, 200};
        int[] expected = {100, 250, 110};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case11() {
        // Starting with zero
        // pref = [0, 5, 3, 6] means:
        // arr[0] = 0
        // arr[1] = 5 ^ 0 = 5
        // arr[2] = 3 ^ 5 = 6
        // arr[3] = 6 ^ 3 = 5
        int[] pref = {0, 5, 3, 6};
        int[] expected = {0, 5, 6, 5};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case12() {
        // Decreasing pattern in prefix
        // pref = [15, 12, 8, 0] means:
        // arr[0] = 15
        // arr[1] = 12 ^ 15 = 3
        // arr[2] = 8 ^ 12 = 4
        // arr[3] = 0 ^ 8 = 8
        int[] pref = {15, 12, 8, 0};
        int[] expected = {15, 3, 4, 8};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case13() {
        // Binary pattern (only 0s and 1s)
        // pref = [1, 0, 1, 0, 1] means:
        // arr[0] = 1
        // arr[1] = 0 ^ 1 = 1
        // arr[2] = 1 ^ 0 = 1
        // arr[3] = 0 ^ 1 = 1
        // arr[4] = 1 ^ 0 = 1
        int[] pref = {1, 0, 1, 0, 1};
        int[] expected = {1, 1, 1, 1, 1};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case14() {
        // Mixed small numbers
        // pref = [2, 6, 4, 0, 2] means:
        // arr[0] = 2
        // arr[1] = 6 ^ 2 = 4
        // arr[2] = 4 ^ 6 = 2
        // arr[3] = 0 ^ 4 = 4
        // arr[4] = 2 ^ 0 = 2
        int[] pref = {2, 6, 4, 0, 2};
        int[] expected = {2, 4, 2, 4, 2};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case15() {
        // Long sequence with pattern
        int[] pref = {8, 12, 4, 0, 8, 12, 4, 0};
        // arr[0] = 8
        // arr[1] = 12 ^ 8 = 4
        // arr[2] = 4 ^ 12 = 8
        // arr[3] = 0 ^ 4 = 4
        // arr[4] = 8 ^ 0 = 8
        // arr[5] = 12 ^ 8 = 4
        // arr[6] = 4 ^ 12 = 8
        // arr[7] = 0 ^ 4 = 4
        int[] expected = {8, 4, 8, 4, 8, 4, 8, 4};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case16() {
        // Edge case: two zeros
        int[] pref = {0, 0};
        int[] expected = {0, 0};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case17() {
        // Self-inverse pattern (XOR with itself gives 0)
        // pref = [9, 0, 9, 0, 9] means:
        // arr[0] = 9
        // arr[1] = 0 ^ 9 = 9
        // arr[2] = 9 ^ 0 = 9
        // arr[3] = 0 ^ 9 = 9
        // arr[4] = 9 ^ 0 = 9
        int[] pref = {9, 0, 9, 0, 9};
        int[] expected = {9, 9, 9, 9, 9};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case18() {
        // Complex pattern with various numbers
        // pref = [10, 7, 13, 2, 8] means:
        // arr[0] = 10
        // arr[1] = 7 ^ 10 = 13
        // arr[2] = 13 ^ 7 = 10
        // arr[3] = 2 ^ 13 = 15
        // arr[4] = 8 ^ 2 = 10
        int[] pref = {10, 7, 13, 2, 8};
        int[] expected = {10, 13, 10, 15, 10};
        int[] result = findArray(pref);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    private int[] findArray(int[] pref) {
        return new int[]{};
    }
}
