package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _424_longestRepeatingCharacterReplacementTest {
    @Test
    void case01() {
        Assertions.assertEquals(4, characterReplacement("ABAB", 2));
    }

    @Test
    void case02() {
        Assertions.assertEquals(4, characterReplacement("AABABBA", 1));
    }

    private int characterReplacement(String s, int k) {
        return 0;
    }
}
