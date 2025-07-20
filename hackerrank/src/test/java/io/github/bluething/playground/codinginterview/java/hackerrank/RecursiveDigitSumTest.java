package io.github.bluething.playground.codinginterview.java.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RecursiveDigitSumTest {
    @Test
    void case01() {
        Assertions.assertEquals(8, superDigit("9875", 4));
    }
    @Test
    void case02() {
        Assertions.assertEquals(3, superDigit("148", 3));
    }
    @Test
    void case03() {
        Assertions.assertEquals(9, superDigit("123", 3));
    }

    private int superDigit(String n, int k) {
        return 0;
    }
}
