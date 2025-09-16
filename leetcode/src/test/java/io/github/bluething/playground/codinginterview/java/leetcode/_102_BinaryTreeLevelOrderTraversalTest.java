package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

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
        if (root == null) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> values = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                values.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(values);
        }
        return result;
    }
}
