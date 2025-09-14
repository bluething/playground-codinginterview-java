package io.github.bluething.playground.codinginterview.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _257_BinaryTreePathsTest {
    @Test
    void case01() {
        // Input: root = [1,2,3,null,5]
        // Tree structure:
        //     1
        //   /   \
        //  2     3
        //   \
        //    5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> expected = Arrays.asList("1->2->5", "1->3");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void case02() {
        // Input: root = [1]
        // Single node tree
        TreeNode root = new TreeNode(1);

        List<String> expected = Arrays.asList("1");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case03() {
        // Empty tree
        TreeNode root = null;

        List<String> expected = Collections.emptyList();
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case04() {
        // Left-skewed tree
        //   1
        //  /
        // 2
        ///
        //3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        List<String> expected = Arrays.asList("1->2->3");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case05() {
        // Right-skewed tree
        // 1
        //  \
        //   2
        //    \
        //     3
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        List<String> expected = Arrays.asList("1->2->3");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case06() {
        // Balanced binary tree
        //     1
        //   /   \
        //  2     3
        // / \   / \
        //4   5 6   7
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<String> expected = Arrays.asList("1->2->4", "1->2->5", "1->3->6", "1->3->7");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void case07() {
        // Tree with only left children except one right
        //     1
        //   /   \
        //  2     3
        // /
        //4
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        List<String> expected = Arrays.asList("1->2->4", "1->3");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void case08() {
        // Tree with negative values
        //    -1
        //   /  \
        // -2    3
        //      /
        //    -4
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);

        List<String> expected = Arrays.asList("-1->-2", "-1->3->-4");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
        assertTrue(expected.containsAll(result));
    }

    @Test
    void case09() {
        // Two-node tree (left child)
        //  1
        // /
        //2
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        List<String> expected = Arrays.asList("1->2");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    @Test
    void case10() {
        // Two-node tree (right child)
        // 1
        //  \
        //   2
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        List<String> expected = Arrays.asList("1->2");
        List<String> result = binaryTreePaths(root);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    private List<String> binaryTreePaths(TreeNode root) {
        return null;
    }
}
