package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class _1769_MinimumNumberofOperationstoMoveAllBallstoEachBoxTest {
    @Test
    void case01() {
        // Input: boxes = "110"
        // Box 0: Move ball from box 1 (distance 1) = 1 operation
        // Box 1: Move ball from box 0 (distance 1) = 1 operation
        // Box 2: Move ball from box 0 (distance 2) + ball from box 1 (distance 1) = 3 operations
        String boxes = "110";
        int[] expected = {1, 1, 3};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: boxes = "001011"
        // Balls are at indices 2, 4, 5
        // Box 0: |0-2| + |0-4| + |0-5| = 2+4+5 = 11
        // Box 1: |1-2| + |1-4| + |1-5| = 1+3+4 = 8
        // Box 2: |2-4| + |2-5| = 2+3 = 5 (box 2 has ball)
        // Box 3: |3-2| + |3-4| + |3-5| = 1+1+2 = 4
        // Box 4: |4-2| + |4-5| = 2+1 = 3 (box 4 has ball)
        // Box 5: |5-2| + |5-4| = 3+1 = 4 (box 5 has ball)
        String boxes = "001011";
        int[] expected = {11, 8, 5, 4, 3, 4};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case03() {
        // Single box with no ball
        String boxes = "0";
        int[] expected = {0};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case04() {
        // Single box with ball
        String boxes = "1";
        int[] expected = {0};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case05() {
        // Two boxes: no balls
        String boxes = "00";
        int[] expected = {0, 0};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case06() {
        // Two boxes: one ball in first box
        String boxes = "10";
        int[] expected = {0, 1};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case07() {
        // Two boxes: one ball in second box
        String boxes = "01";
        int[] expected = {1, 0};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case08() {
        // Two boxes: both have balls
        String boxes = "11";
        int[] expected = {1, 1};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case09() {
        // All boxes empty
        String boxes = "0000";
        int[] expected = {0, 0, 0, 0};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case10() {
        // All boxes have balls
        String boxes = "1111";
        int[] expected = {6, 4, 4, 6};
        // Box 0: |0-1| + |0-2| + |0-3| = 1+2+3 = 6
        // Box 1: |1-0| + |1-2| + |1-3| = 1+1+2 = 4
        // Box 2: |2-0| + |2-1| + |2-3| = 2+1+1 = 4
        // Box 3: |3-0| + |3-1| + |3-2| = 3+2+1 = 6
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case11() {
        // Ball only at first position
        String boxes = "10000";
        int[] expected = {0, 1, 2, 3, 4};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case12() {
        // Ball only at last position
        String boxes = "00001";
        int[] expected = {4, 3, 2, 1, 0};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case13() {
        // Ball only in middle
        String boxes = "00100";
        int[] expected = {2, 1, 0, 1, 2};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case14() {
        // Balls at both ends
        String boxes = "10001";
        // Balls at positions: 0, 4
        // Box 0: move ball from 4 → |0-4| = 4
        // Box 1: move from 0,4 → |1-0| + |1-4| = 1+3 = 4
        // Box 2: move from 0,4 → |2-0| + |2-4| = 2+2 = 4
        // Box 3: move from 0,4 → |3-0| + |3-4| = 3+1 = 4
        // Box 4: move ball from 0 → |4-0| = 4
        int[] expected = {4, 4, 4, 4, 4};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case15() {
        // Three consecutive balls
        String boxes = "11100";
        // Balls at positions: 0, 1, 2
        // Box 0: move balls from positions 1,2 → |0-1|+|0-2| = 1+2 = 3
        // Box 1: move balls from positions 0,2 → |1-0|+|1-2| = 1+1 = 2
        // Box 2: move balls from positions 0,1 → |2-0|+|2-1| = 2+1 = 3
        // Box 3: move balls from positions 0,1,2 → |3-0|+|3-1|+|3-2| = 3+2+1 = 6
        // Box 4: move balls from positions 0,1,2 → |4-0|+|4-1|+|4-2| = 4+3+2 = 9
        int[] expected = {3, 2, 3, 6, 9};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    @Test
    void case16() {
        // Alternating pattern
        String boxes = "10101";
        // Balls at positions: 0, 2, 4
        // Box 0: move from 2,4 → |0-2|+|0-4| = 2+4 = 6
        // Box 1: move from 0,2,4 → |1-0|+|1-2|+|1-4| = 1+1+3 = 5
        // Box 2: move from 0,4 → |2-0|+|2-4| = 2+2 = 4
        // Box 3: move from 0,2,4 → |3-0|+|3-2|+|3-4| = 3+1+1 = 5
        // Box 4: move from 0,2 → |4-0|+|4-2| = 4+2 = 6
        int[] expected = {6, 5, 4, 5, 6};
        int[] result = minOperations(boxes);

        assertNotNull(result);
        assertArrayEquals(expected, result);
    }

    private int[] minOperations(String boxes) {
        return new int[]{};
    }
}
