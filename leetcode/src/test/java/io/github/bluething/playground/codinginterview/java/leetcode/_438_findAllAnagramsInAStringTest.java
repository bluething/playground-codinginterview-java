package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class _438_findAllAnagramsInAStringTest {
    @Test
    void case01() {
        Assertions.assertEquals(List.of(0, 6), findAnagrams("cbaebabacd", "abc"));
    }

    @Test
    void case02() {
        Assertions.assertEquals(List.of(0, 1, 2), findAnagrams("abab", "ab"));
    }

    private List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (n < m) {
            return result;
        }
        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int need = m;
        int left = 0, right = 0;
        while (right < n) {
            char c = s.charAt(right);
            if (count[c - 'a']-- > 0) {
                need--;
            }
            right++;

            while (need == 0) {
                if (right - left == m) {
                    result.add(left);
                }
                if (count [s.charAt(left) - 'a']++ >= 0) {
                    need++;
                }

                left++;
            }
        }

        return result;
    }
}
