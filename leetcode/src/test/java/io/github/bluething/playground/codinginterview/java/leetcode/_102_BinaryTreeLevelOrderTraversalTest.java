package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class _102_BinaryTreeLevelOrderTraversalTest {

    @Test
    void case01() {
        // Input: root = [3,9,20,null,null,15,7]
        // Output: [[3],[9,20],[15,7]]
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(3),
                Arrays.asList(9, 20),
                Arrays.asList(15, 7)
        );

        List<List<Integer>> result = levelOrder(root);
        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = [1]
        // Output: [[1]]
        // Simple single node case
        TreeNode root = new TreeNode(1);

        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1)
        );

        List<List<Integer>> result = levelOrder(root);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: root = []
        // Output: []
        // Empty tree case
        TreeNode root = null;

        List<List<Integer>> expected = Collections.emptyList();

        List<List<Integer>> result = levelOrder(root);
        assertEquals(expected, result);
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        return null;
    }
}
