package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class _3_longestSubstringWithoutRepeatingCharactersTest {
    @Test
    void case01() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    void case02() {
        Assertions.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
    }

    @Test
    void case03() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    void case04() {
        Assertions.assertEquals(0, lengthOfLongestSubstring(""));
    }

    @Test
    void case05() {
        Assertions.assertEquals(4, lengthOfLongestSubstring("dabcabcbb"));
    }

    @Test
    void case06() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("abccabcbb"));
    }

    private int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> uniqueTracker = new HashMap<>();
        int maxLength = 0;
        while (right < s.length()) {
            uniqueTracker.put(s.charAt(right), uniqueTracker.getOrDefault(s.charAt(right), 0) + 1);
            while (uniqueTracker.size() != (right - left + 1)) {
                uniqueTracker.remove(s.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
