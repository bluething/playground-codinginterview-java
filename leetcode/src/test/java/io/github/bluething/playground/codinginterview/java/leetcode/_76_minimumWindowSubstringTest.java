package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _76_minimumWindowSubstringTest {
    @Test
    void case01() {
        Assertions.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }
    @Test
    void case02() {
        Assertions.assertEquals("a", minWindow("a", "a"));
    }
    @Test
    void case03() {
        Assertions.assertEquals("", minWindow("a", "aa"));
    }
    private String minWindow(String s, String t) {
        int[] frequencies = new int[128];
        for (char c : t.toCharArray()) {
            frequencies[c]++;
        }
        int left=0, right=0, minLength=Integer.MAX_VALUE, count = 0;
        String answer = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            if (--frequencies[c] >= 0) {
                count++;
            }

            while (count == t.length()) {
                int curLen = right - left + 1;
                if (curLen < minLength) {
                    minLength = curLen;
                    answer = s.substring(left, right+1);
                }
                char leftChar = s.charAt(left);
                if (++frequencies[leftChar] > 0) {
                    count--;
                }
                left++;
            }

            right++;
        }
        return answer;
    }
}
