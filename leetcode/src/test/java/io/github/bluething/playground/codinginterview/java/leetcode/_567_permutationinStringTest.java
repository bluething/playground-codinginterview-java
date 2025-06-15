package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class _567_permutationinStringTest {
    @Test
    void case01() {
        Assertions.assertTrue(checkInclusion("ab", "eidbaooo"));
    }
    @Test
    void case02() {
        Assertions.assertFalse(checkInclusion("ab", "eidboaoo"));
    }
    @Test
    void case03() {
        Assertions.assertFalse(checkInclusion("abc", "ccccbbbbaaaa"));
    }

    private boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) {
            return false;
        }
        int[] freq = new int[26];
        for (char c : s1.toCharArray()) {
            freq[c - 'a']++;
        }
        int left=0, right=0, count = len1;
        while (right < len1) {
            if(freq[s2.charAt(right++) - 'a']-- > 0) {
                count--;
            }
        }
        while (right < len2 && count != 0) {
            if (freq[s2.charAt(left++) - 'a']++ >= 0) {
                count++;
            }
            if (freq[s2.charAt(right++) - 'a']-- > 0) {
                count--;
            }
        }
        return count == 0;
    }
}
