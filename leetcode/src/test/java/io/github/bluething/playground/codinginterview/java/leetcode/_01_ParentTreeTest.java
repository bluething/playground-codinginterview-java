package io.github.bluething.playground.codinginterview.java.leetcode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

abstract class _01_ParentTreeTest {
    // Helper method to compare two binary trees
    boolean areTreesEqual(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) {
            return true;
        }
        if (tree1 == null || tree2 == null) {
            return false;
        }
        return tree1.value == tree2.value &&
                areTreesEqual(tree1.left, tree2.left) &&
                areTreesEqual(tree1.right, tree2.right);
    }

    // Helper method to check if a tree is a valid BST
    boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.value <= min) || (max != null && root.value >= max)) {
            return false;
        }
        return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
    }

    // Helper method to check if tree is height-balanced
    int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Helper method to compare double values with tolerance
    void assertDoubleListEquals(List<Double> expected, List<Double> actual) {
        assertEquals(expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), actual.get(i), 0.00001,
                    "Mismatch at index " + i + ": expected " + expected.get(i) + " but got " + actual.get(i));
        }
    }
}
