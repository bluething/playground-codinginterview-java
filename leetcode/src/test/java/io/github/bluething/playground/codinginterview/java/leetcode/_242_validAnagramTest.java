package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _242_validAnagramTest {
    @Test
    void case01() {
        Assertions.assertTrue(isAnagram("anagram", "nagaram"));
    }

    @Test
    void case02() {
        Assertions.assertFalse(isAnagram("rat", "car"));
    }

    @Test
    void case03() {
        Assertions.assertFalse(isAnagram("a", "ab"));
    }

    private boolean isAnagram(String s, String t) {
        return false;
    }
}
