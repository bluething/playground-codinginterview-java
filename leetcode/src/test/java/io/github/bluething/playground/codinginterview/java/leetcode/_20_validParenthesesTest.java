package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class _20_validParenthesesTest {
    @Test
    void case01() {
        Assertions.assertTrue(isValid("()"));
    }

    @Test
    void case02() {
        Assertions.assertTrue(isValid("()[]{}"));
    }

    @Test
    void case03() {
        Assertions.assertFalse(isValid("(]"));
    }

    @Test
    void case04() {
        Assertions.assertFalse(isValid("]"));
    }

    @Test
    void case05() {
        Assertions.assertFalse(isValid("["));
    }

    private boolean isValid(String s) {
        char[] stack = new char[s.length()];
        char[] pairs = new char[128];
        pairs[')'] = '(';
        pairs['}'] = '{';
        pairs[']'] = '[';
        int idx = 0;
        for (char c : s.toCharArray()) {
            if (pairs[c] == 0) {
                stack[idx++] = c;
            } else {
                if (idx == 0) {
                    return false;
                }
                if (pairs[c] != stack[idx - 1]) {
                    return false;
                }
                idx--;
            }
        }
        return idx == 0;
    }
}