package io.github.bluething.playground.codinginterview.java.leetcode;

import java.util.ArrayList;
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

    // Helper method to get inorder traversal for comparison
   List<Integer> getInorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    // Helper method to check if a tree is balanced
    private boolean isBalanced(TreeNode root) {
        return checkBalance(root) != -1;
    }

    private int checkBalance(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Helper method to verify BST property
    private boolean isBST(TreeNode root) {
        return isBSTHelper(root, null, null);
    }

    private boolean isBSTHelper(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }

        return isBSTHelper(node.left, min, node.value) &&
                isBSTHelper(node.right, node.value, max);
    }

    private void inorderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) return;

        inorderTraversal(node.left, values);
        values.add(node.value);
        inorderTraversal(node.right, values);
    }

    // Helper method to get preorder traversal for verification
    List<Integer> getPreorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    void preorderTraversal(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.value);
        preorderTraversal(node.left, result);
        preorderTraversal(node.right, result);
    }

    private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        // Merge two sorted lists using two pointers
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                merged.add(list1.get(i));
                i++;
            } else {
                merged.add(list2.get(j));
                j++;
            }
        }

        // Add remaining elements from list1
        while (i < list1.size()) {
            merged.add(list1.get(i));
            i++;
        }

        // Add remaining elements from list2
        while (j < list2.size()) {
            merged.add(list2.get(j));
            j++;
        }

        return merged;
    }
}
