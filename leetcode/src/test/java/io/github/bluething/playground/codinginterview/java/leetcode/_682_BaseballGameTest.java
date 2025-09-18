package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _682_BaseballGameTest {
    @Test
    void case01() {
        // Input: ops = ["5","2","C","D","+"]
        // Step by step:
        // "5" -> [5]
        // "2" -> [5, 2]
        // "C" -> [5] (remove 2)
        // "D" -> [5, 10] (double 5)
        // "+" -> [5, 10, 15] (sum of 5 + 10)
        // Total: 5 + 10 + 15 = 30
        String[] ops = {"5", "2", "C", "D", "+"};
        int expected = 30;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: ops = ["5","-2","4","C","D","9","+","+"]
        // Step by step:
        // "5" -> [5]
        // "-2" -> [5, -2]
        // "4" -> [5, -2, 4]
        // "C" -> [5, -2] (remove 4)
        // "D" -> [5, -2, -4] (double -2)
        // "9" -> [5, -2, -4, 9]
        // "+" -> [5, -2, -4, 9, 5] (sum of -4 + 9)
        // "+" -> [5, -2, -4, 9, 5, 14] (sum of 9 + 5)
        // Total: 5 + (-2) + (-4) + 9 + 5 + 14 = 27
        String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        int expected = 27;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: ops = ["1","C"]
        // Step by step:
        // "1" -> [1]
        // "C" -> [] (remove 1)
        // Total: 0 (empty record)
        String[] ops = {"1", "C"};
        int expected = 0;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Single positive score
        String[] ops = {"10"};
        int expected = 10;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Single negative score
        String[] ops = {"-5"};
        int expected = -5;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // Only "D" operation (double)
        String[] ops = {"3", "D"};
        int expected = 9; // 3 + 6 = 9
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Only "+" operation (sum of last two)
        String[] ops = {"2", "5", "+"};
        int expected = 14; // 2 + 5 + 7 = 14
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Multiple cancel operations
        String[] ops = {"1", "2", "C", "3", "C", "4"};
        int expected = 5; // Final record: [1, 4], sum = 5
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // Double a negative number
        String[] ops = {"-3", "D"};
        int expected = -9; // -3 + (-6) = -9
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Sum with negative numbers
        String[] ops = {"5", "-10", "+"};
        int expected = -10; // 5 + (-10) + (-5) = -10
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Complex sequence with all operations
        String[] ops = {"1", "2", "+", "D", "C", "5"};
        // "1" -> [1]
        // "2" -> [1, 2]
        // "+" -> [1, 2, 3] (1+2)
        // "D" -> [1, 2, 3, 6] (double 3)
        // "C" -> [1, 2, 3] (remove 6)
        // "5" -> [1, 2, 3, 5]
        // Total: 1 + 2 + 3 + 5 = 11
        int expected = 11;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case12() {
        // Zero score handling
        String[] ops = {"0", "5", "+"};
        int expected = 10; // 0 + 5 + 5 = 10
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case13() {
        // Multiple doubles in sequence
        String[] ops = {"2", "D", "D"};
        // "2" -> [2]
        // "D" -> [2, 4] (double 2)
        // "D" -> [2, 4, 8] (double 4)
        // Total: 2 + 4 + 8 = 14
        int expected = 14;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case14() {
        // Multiple sums in sequence
        String[] ops = {"1", "2", "+", "+"};
        // "1" -> [1]
        // "2" -> [1, 2]
        // "+" -> [1, 2, 3] (1+2)
        // "+" -> [1, 2, 3, 5] (2+3)
        // Total: 1 + 2 + 3 + 5 = 11
        int expected = 11;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case15() {
        // Large positive numbers
        String[] ops = {"1000", "2000", "+"};
        int expected = 6000; // 1000 + 2000 + 3000 = 6000
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case16() {
        // Cancel after double
        String[] ops = {"5", "D", "C"};
        // "5" -> [5]
        // "D" -> [5, 10] (double 5)
        // "C" -> [5] (remove 10)
        // Total: 5
        int expected = 5;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case17() {
        // Cancel after sum
        String[] ops = {"3", "4", "+", "C"};
        // "3" -> [3]
        // "4" -> [3, 4]
        // "+" -> [3, 4, 7] (3+4)
        // "C" -> [3, 4] (remove 7)
        // Total: 3 + 4 = 7
        int expected = 7;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case18() {
        // Edge case: alternating operations
        String[] ops = {"10", "C", "20", "C", "30"};
        // "10" -> [10]
        // "C" -> [] (remove 10)
        // "20" -> [20]
        // "C" -> [] (remove 20)
        // "30" -> [30]
        // Total: 30
        int expected = 30;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case19() {
        // All negative numbers
        String[] ops = {"-1", "-2", "+", "D"};
        // "-1" -> [-1]
        // "-2" -> [-1, -2]
        // "+" -> [-1, -2, -3] (-1 + -2)
        // "D" -> [-1, -2, -3, -6] (double -3)
        // Total: -1 + (-2) + (-3) + (-6) = -12
        int expected = -12;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    @Test
    void case20() {
        // Mixed positive and negative with all operations
        String[] ops = {"10", "-5", "+", "D", "C", "-10", "+"};
        // "10" -> [10]
        // "-5" -> [10, -5]
        // "+" -> [10, -5, 5] (10 + (-5))
        // "D" -> [10, -5, 5, 10] (double 5)
        // "C" -> [10, -5, 5] (remove 10)
        // "-10" -> [10, -5, 5, -10]
        // "+" -> [10, -5, 5, -10, -5] (5 + (-10))
        // Total: 10 + (-5) + 5 + (-10) + (-5) = -5
        int expected = -5;
        int result = calPoints(ops);
        assertEquals(expected, result);
    }

    private int calPoints(String[] operations) {
        return 0;
    }
}
