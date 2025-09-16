package io.github.bluething.playground.codinginterview.java.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class _637_AverageofLevelsinBinaryTreeTest extends _01_ParentTreeTest {

    void case01() {
        // Input: root = [3,9,20,null,null,15,7]
        // Tree structure:
        //     3           -> Level 0: [3] -> average = 3.0
        //   /   \
        //  9    20        -> Level 1: [9,20] -> average = 14.5
        //      /  \
        //     15   7      -> Level 2: [15,7] -> average = 11.0
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> expected = Arrays.asList(3.00000, 14.50000, 11.00000);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case02() {
        // Input: root = [3,9,20,15,7]
        // Tree structure:
        //     3           -> Level 0: [3] -> average = 3.0
        //   /   \
        //  9    20        -> Level 1: [9,20] -> average = 14.5
        // / \
        //15  7           -> Level 2: [15,7] -> average = 11.0
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);

        List<Double> expected = Arrays.asList(3.00000, 14.50000, 11.00000);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case03() {
        // Single node tree
        TreeNode root = new TreeNode(5);

        List<Double> expected = Arrays.asList(5.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case04() {
        // Empty tree
        TreeNode root = null;

        List<Double> expected = Collections.emptyList();
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertEquals(expected, result);
    }

    void case05() {
        // Complete balanced binary tree
        //     1           -> Level 0: [1] -> average = 1.0
        //   /   \
        //  2     3        -> Level 1: [2,3] -> average = 2.5
        // / \   / \
        //4   5 6   7     -> Level 2: [4,5,6,7] -> average = 5.5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Double> expected = Arrays.asList(1.0, 2.5, 5.5);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case06() {
        // Left-skewed tree
        //   1             -> Level 0: [1] -> average = 1.0
        //  /
        // 2              -> Level 1: [2] -> average = 2.0
        ///
        //3               -> Level 2: [3] -> average = 3.0
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);

        List<Double> expected = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case07() {
        // Right-skewed tree
        // 1              -> Level 0: [1] -> average = 1.0
        //  \
        //   2            -> Level 1: [2] -> average = 2.0
        //    \
        //     3          -> Level 2: [3] -> average = 3.0
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        List<Double> expected = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case08() {
        // Tree with negative values
        //    -1           -> Level 0: [-1] -> average = -1.0
        //   /  \
        // -2    3        -> Level 1: [-2,3] -> average = 0.5
        //      /
        //    -4          -> Level 2: [-4] -> average = -4.0
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(-4);

        List<Double> expected = Arrays.asList(-1.0, 0.5, -4.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case09() {
        // Two nodes (left child)
        //  1              -> Level 0: [1] -> average = 1.0
        // /
        //2               -> Level 1: [2] -> average = 2.0
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        List<Double> expected = Arrays.asList(1.0, 2.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case10() {
        // Two nodes (right child)
        // 1              -> Level 0: [1] -> average = 1.0
        //  \
        //   2            -> Level 1: [2] -> average = 2.0
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        List<Double> expected = Arrays.asList(1.0, 2.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case11() {
        // Tree with large numbers to test integer overflow protection
        //      2147483647  -> Level 0: [2147483647] -> average = 2147483647.0
        //     /         \
        //2147483647  2147483647 -> Level 1: [2147483647, 2147483647] -> average = 2147483647.0
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);

        List<Double> expected = Arrays.asList(2147483647.0, 2147483647.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    void case12() {
        // Asymmetric tree with different level sizes
        //       1         -> Level 0: [1] -> average = 1.0
        //     /   \
        //    2     3      -> Level 1: [2,3] -> average = 2.5
        //   / \     \
        //  4   5     6    -> Level 2: [4,5,6] -> average = 5.0
        // /
        //7             -> Level 3: [7] -> average = 7.0
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        List<Double> expected = Arrays.asList(1.0, 2.5, 5.0, 7.0);
        List<Double> result = averageOfLevels(root);

        assertNotNull(result);
        assertDoubleListEquals(expected, result);
    }

    private List<Double> averageOfLevels(TreeNode root) {
        return Collections.emptyList();
    }
}
