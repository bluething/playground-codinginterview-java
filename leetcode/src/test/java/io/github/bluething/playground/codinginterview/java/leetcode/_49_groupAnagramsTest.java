package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class _49_groupAnagramsTest {
    @Test
    void case01() {
        List<List<String>> expected = Arrays.asList(Arrays.asList("eat","tea","ate"),
                Arrays.asList("bat"),
                Arrays.asList("tan", "nat"));
        Assertions.assertEquals(expected, groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    @Test
    void case02() {
        List<List<String>> expected = Arrays.asList(Arrays.asList(""));
        Assertions.assertEquals(expected, groupAnagrams(new String[]{""}));
    }

    @Test
    void case03() {
        List<List<String>> expected = Arrays.asList(Arrays.asList("a"));
        Assertions.assertEquals(expected, groupAnagrams(new String[]{"a"}));
    }

    private List<List<String>> groupAnagrams(String[] strs) {
        int[] frequencies = new int[26];
        Map<String, List<String>> frequenciesMap = new HashMap<>();
        for (String str : strs) {
            Arrays.fill(frequencies, 0);
            for (char c : str.toCharArray()) {
                frequencies[c - 'a']++;
            }
            String key = Arrays.toString(frequencies);
            frequenciesMap.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(frequenciesMap.values());
    }
}
