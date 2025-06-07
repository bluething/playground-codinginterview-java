package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _347_topKFrequentElementsTest {
    @Test
    void case01() {
        Assertions.assertArrayEquals(new int[]{1,2}, topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }

    @Test
    void case02() {
        Assertions.assertArrayEquals(new int[]{1}, topKFrequent(new int[]{1}, 1));
    }

    private int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqeuncies = new HashMap<>();
        for (int num : nums) {
            freqeuncies.put(num, freqeuncies.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int num : freqeuncies.keySet()) {
            int frequency = freqeuncies.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            List<Integer> bucket = buckets[i];
            if (bucket != null) {
                for (int num : bucket) {
                    result[idx++] = num;
                    if (idx == k) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
