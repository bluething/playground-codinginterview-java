package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _1305_AllElementsinTwoBinarySearchTreesTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root1 = [2,1,4], root2 = [1,0,3]
        // Output: [0,1,1,2,3,4]

        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3, 4);

        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root1 = [1,null,8], root2 = [8,1]
        // Output: [1,1,8,8]

        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(8);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(1);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(1, 1, 8, 8);

        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Edge case: One tree is null
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);

        TreeNode root2 = null;

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(3, 5, 7);

        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Edge case: Both trees are null
        TreeNode root1 = null;
        TreeNode root2 = null;

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList();

        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Single node trees
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(3, 5);

        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // Trees with no overlapping values
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(12);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(5);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(1, 3, 5, 8, 10, 12);

        assertEquals(expected, result);
    }

    @Test
    void case07() {
        // Trees with completely overlapping values
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(7);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(3, 3, 5, 5, 7, 7);

        assertEquals(expected, result);
    }

    @Test
    void case08() {
        // Left-skewed and right-skewed trees
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(1);

        TreeNode root2 = new TreeNode(2);
        root2.right = new TreeNode(4);
        root2.right.right = new TreeNode(6);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertEquals(expected, result);
    }

    @Test
    void case09() {
        // One tree much larger than the other
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(7);
        root1.right.left = new TreeNode(12);
        root1.right.right = new TreeNode(18);

        TreeNode root2 = new TreeNode(6);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(2, 5, 6, 7, 10, 12, 15, 18);

        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Trees with negative values
        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(-3);
        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(-1);
        root2.left = new TreeNode(-5);
        root2.right = new TreeNode(2);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(-5, -3, -1, 0, 2, 3);

        assertEquals(expected, result);
    }

    @Test
    void case11() {
        // Large values
        TreeNode root1 = new TreeNode(1000);
        root1.left = new TreeNode(500);
        root1.right = new TreeNode(1500);

        TreeNode root2 = new TreeNode(750);
        root2.left = new TreeNode(250);
        root2.right = new TreeNode(1250);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(250, 500, 750, 1000, 1250, 1500);

        assertEquals(expected, result);
    }

    @Test
    void case12() {
        // Multiple duplicate values across trees
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(2);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(7);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(2, 2, 2, 5, 5, 5, 7);

        assertEquals(expected, result);
    }

    @Test
    void case13() {
        // Complex balanced trees
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(12);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(6);
        root1.right.left = new TreeNode(10);
        root1.right.right = new TreeNode(14);

        TreeNode root2 = new TreeNode(9);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(13);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(11);
        root2.right.right = new TreeNode(15);

        List<Integer> result = getAllElements(root1, root2);
        List<Integer> expected = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        assertEquals(expected, result);
    }

    @Test
    void case14() {
        // Verify result is sorted when input trees are valid BSTs
        TreeNode root1 = new TreeNode(20);
        root1.left = new TreeNode(15);
        root1.right = new TreeNode(25);

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(12);

        List<Integer> result = getAllElements(root1, root2);

        // Verify both input trees are valid BSTs
        assertTrue(isValidBST(root1, null, null));
        assertTrue(isValidBST(root2, null, null));

        // Verify result is sorted
        List<Integer> expected = Arrays.asList(5, 10, 12, 15, 20, 25);
        assertEquals(expected, result);

        // Additional verification that result is sorted
        for (int i = 1; i < result.size(); i++) {
            assertTrue(result.get(i-1) <= result.get(i),
                    "Result should be sorted: " + result.get(i-1) + " > " + result.get(i));
        }
    }

    List<Integer> list1;
    List<Integer> list2;
    private List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();

        inOrderTraversal(root1, list1);
        inOrderTraversal(root2, list2);

        List<Integer> result = new ArrayList<>();
        int i=0, j=0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i));
                i++;
            } else {
                result.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            result.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            result.add(list2.get(j));
            j++;
        }
        return result;
    }
    private void inOrderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inOrderTraversal(root.left, list);
        list.add(root.value);
        inOrderTraversal(root.right, list);
    }
}
