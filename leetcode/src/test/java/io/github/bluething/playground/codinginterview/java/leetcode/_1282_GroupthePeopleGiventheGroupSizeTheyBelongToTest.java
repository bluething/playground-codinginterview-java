package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _1282_GroupthePeopleGiventheGroupSizeTheyBelongToTest {
    @Test
    void case01() {
        // Input: groupSizes = [3,3,3,3,3,1,3]
        // Person 5 wants group size 1: [5]
        // Persons 0,1,2,3,4,6 want group size 3: can form groups like [0,1,2] and [3,4,6]
        int[] groupSizes = {3, 3, 3, 3, 3, 1, 3};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(3, result.size()); // Should have 3 groups total

        // Verify there's one group of size 1 and two groups of size 3
        int size1Groups = 0, size3Groups = 0;
        for (List<Integer> group : result) {
            if (group.size() == 1) size1Groups++;
            else if (group.size() == 3) size3Groups++;
        }
        assertEquals(1, size1Groups);
        assertEquals(2, size3Groups);
    }

    @Test
    void case02() {
        // Input: groupSizes = [2,1,3,3,3,2]
        // Person 1 wants group size 1: [1]
        // Persons 0,5 want group size 2: [0,5]
        // Persons 2,3,4 want group size 3: [2,3,4]
        int[] groupSizes = {2, 1, 3, 3, 3, 2};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(3, result.size()); // Should have 3 groups total
    }

    @Test
    void case03() {
        // Single person wanting group size 1
        int[] groupSizes = {1};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(0), result.get(0));
    }

    @Test
    void case04() {
        // Two people each wanting group size 1
        int[] groupSizes = {1, 1};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(2, result.size());

        // Each group should have size 1
        for (List<Integer> group : result) {
            assertEquals(1, group.size());
        }
    }

    @Test
    void case05() {
        // Two people wanting to be in group of size 2
        int[] groupSizes = {2, 2};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).size());
    }

    @Test
    void case06() {
        // Three people wanting to be in group of size 3
        int[] groupSizes = {3, 3, 3};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(1, result.size());
        assertEquals(3, result.get(0).size());
    }

    @Test
    void case07() {
        // Mixed group sizes: some 1s, some 2s
        int[] groupSizes = {1, 2, 1, 2};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(3, result.size()); // Two size-1 groups and one size-2 group
    }

    @Test
    void case08() {
        // All people want same group size (larger)
        int[] groupSizes = {4, 4, 4, 4};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(1, result.size());
        assertEquals(4, result.get(0).size());
    }

    @Test
    void case09() {
        // Multiple groups of same size needed
        int[] groupSizes = {2, 2, 2, 2};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(2, result.size()); // Two groups of size 2 each

        for (List<Integer> group : result) {
            assertEquals(2, group.size());
        }
    }

    @Test
    void case10() {
        // Various group sizes: 1, 2, 3, 4
        int[] groupSizes = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(4, result.size()); // One group each of sizes 1, 2, 3, 4

        // Count groups by size
        int[] groupCounts = new int[5];
        for (List<Integer> group : result) {
            groupCounts[group.size()]++;
        }
        assertEquals(1, groupCounts[1]); // One group of size 1
        assertEquals(1, groupCounts[2]); // One group of size 2
        assertEquals(1, groupCounts[3]); // One group of size 3
        assertEquals(1, groupCounts[4]); // One group of size 4
    }

    @Test
    void case11() {
        // Six people wanting group size 2 (should form 3 groups)
        int[] groupSizes = {2, 2, 2, 2, 2, 2};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(3, result.size()); // Three groups of size 2 each

        for (List<Integer> group : result) {
            assertEquals(2, group.size());
        }
    }

    @Test
    void case12() {
        // Nine people wanting group size 3 (should form 3 groups)
        int[] groupSizes = {3, 3, 3, 3, 3, 3, 3, 3, 3};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(3, result.size()); // Three groups of size 3 each

        for (List<Integer> group : result) {
            assertEquals(3, group.size());
        }
    }

    @Test
    void case13() {
        // Large group size
        int[] groupSizes = {5, 5, 5, 5, 5};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(1, result.size());
        assertEquals(5, result.get(0).size());
    }

    @Test
    void case14() {
        // Mixed pattern: multiple small and large groups
        int[] groupSizes = {1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);

        // Should have: 2 groups of size 1, 1 group of size 2, 1 group of size 3, 1 group of size 4
        int[] groupCounts = new int[5];
        for (List<Integer> group : result) {
            groupCounts[group.size()]++;
        }
        assertEquals(2, groupCounts[1]); // Two groups of size 1
        assertEquals(1, groupCounts[2]); // One group of size 2
        assertEquals(1, groupCounts[3]); // One group of size 3
        assertEquals(1, groupCounts[4]); // One group of size 4
    }

    @Test
    void case15() {
        // Edge case: everyone wants to be in a group of size equal to total people
        int[] groupSizes = {6, 6, 6, 6, 6, 6};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);
        assertEquals(1, result.size());
        assertEquals(6, result.get(0).size());
    }

    @Test
    void case16() {
        // Pattern requiring multiple groups of various sizes
        int[] groupSizes = {2, 3, 2, 3, 2, 3, 1, 1};
        List<List<Integer>> result = groupThePeople(groupSizes);

        validateGrouping(groupSizes, result);

        // Should have: 2 groups of size 1, 1-2 groups of size 2, 1-2 groups of size 3
        int[] groupCounts = new int[4];
        for (List<Integer> group : result) {
            groupCounts[group.size()]++;
        }
        assertEquals(2, groupCounts[1]); // Two groups of size 1
        assertTrue(groupCounts[2] >= 1); // At least one group of size 2
        assertTrue(groupCounts[3] >= 1); // At least one group of size 3
    }

    // Helper method to validate the grouping result
    private void validateGrouping(int[] groupSizes, List<List<Integer>> result) {
        assertNotNull(result);

        // Check that all people are included exactly once
        List<Integer> allPeople = new ArrayList<>();
        for (List<Integer> group : result) {
            allPeople.addAll(group);
        }
        Collections.sort(allPeople);

        List<Integer> expectedPeople = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            expectedPeople.add(i);
        }
        assertEquals(expectedPeople, allPeople);

        // Check that each group has the correct size for its members
        for (List<Integer> group : result) {
            assertTrue(group.size() > 0);
            int expectedSize = groupSizes[group.get(0)];
            assertEquals(expectedSize, group.size());

            // All members in the group should have the same group size requirement
            for (int person : group) {
                assertEquals(expectedSize, groupSizes[person]);
            }
        }
    }

    private List<List<Integer>> groupThePeople(int[] groupSizes) {
        return List.of();
    }
}
