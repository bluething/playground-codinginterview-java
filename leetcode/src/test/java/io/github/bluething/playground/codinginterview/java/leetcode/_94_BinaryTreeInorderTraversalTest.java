package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _94_BinaryTreeInorderTraversalTest {

    @Test
    void case01() {
        // Input: root = [1,null,2,3]
        // Tree structure:
        //   1
        //    \
        //     2
        //    /
        //   3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(1, 3, 2);
        List<Integer> result = inorderTraversal(root);

        assertEquals(expected, result);
    }

    @Test
    void case02() {
        // Input: root = []
        // Empty tree
        TreeNode root = null;

        List<Integer> expected = Arrays.asList();
        List<Integer> result = inorderTraversal(root);

        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Input: root = [1]
        // Single node tree
        TreeNode root = new TreeNode(1);

        List<Integer> expected = Arrays.asList(1);
        List<Integer> result = inorderTraversal(root);

        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Input: root = [1,2,3,4,5]
        // Balanced tree
        //     1
        //    / \
        //   2   3
        //  / \
        // 4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> expected = Arrays.asList(4, 2, 5, 1, 3);
        List<Integer> result = inorderTraversal(root);

        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Left-skewed tree
        //   1
        //  /
        // 2
        ///
        //3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        List<Integer> expected = Arrays.asList(3, 2, 1);
        List<Integer> result = inorderTraversal(root);

        assertEquals(expected, result);
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }
}
