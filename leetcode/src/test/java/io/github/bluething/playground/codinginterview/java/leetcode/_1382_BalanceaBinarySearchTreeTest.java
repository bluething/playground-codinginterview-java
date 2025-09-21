package io.github.bluething.playground.codinginterview.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class _1382_BalanceaBinarySearchTreeTest extends _01_ParentTreeTest {
    @Test
    void case01() {
        // Input: root = [1,null,2,null,3,null,4,null,null]
        // Output: [2,1,3,null,null,null,4] or similar balanced structure

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode result = balanceBST(root);

        // Verify the tree is balanced
        assertTrue(getHeight(result) != -1);

        // Verify it's still a valid BST
        assertTrue(isValidBST(result, null, null));

        // Verify same elements (inorder should be the same)
        List<Integer> originalInorder = getInorder(root);
        List<Integer> resultInorder = getInorder(result);
        assertEquals(originalInorder, resultInorder);

        // For this specific case, root should be 2 or 3
        assertTrue(result.value == 2 || result.value == 3);
    }

    @Test
    void case02() {
        // Input: root = [2,1,3]
        // Output: [2,1,3] (already balanced)

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        TreeNode result = balanceBST(root);

        // Verify the tree is balanced
        assertTrue(getHeight(result) != -1);

        // Verify it's still a valid BST
        assertTrue(isValidBST(result, null, null));

        // Verify same elements
        List<Integer> originalInorder = getInorder(root);
        List<Integer> resultInorder = getInorder(result);
        assertEquals(originalInorder, resultInorder);

        // Should maintain the same structure since it's already balanced
        assertEquals(2, result.value);
        assertEquals(1, result.left.value);
        assertEquals(3, result.right.value);
    }

    @Test
    void case03() {
        // Edge case: Single node
        TreeNode root = new TreeNode(5);

        TreeNode result = balanceBST(root);

        assertTrue(getHeight(result) != -1);
        assertTrue(isValidBST(result, null, null));
        assertEquals(5, result.value);
        assertNull(result.left);
        assertNull(result.right);
    }

    @Test
    void case04() {
        // Edge case: Left skewed tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(2);
        root.left.left.left.left = new TreeNode(1);

        TreeNode result = balanceBST(root);

        assertTrue(getHeight(result) != -1);
        assertTrue(isValidBST(result, null, null));

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, getInorder(result));

        // Root should be the middle element (3)
        assertEquals(3, result.value);
    }

    @Test
    void case05() {
        // Edge case: Right skewed tree
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);

        TreeNode result = balanceBST(root);

        assertTrue(getHeight(result) != -1);
        assertTrue(isValidBST(result, null, null));

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
        assertEquals(expected, getInorder(result));

        // Root should be the middle element (3)
        assertEquals(3, result.value);
    }

    @Test
    void case06() {
        // Complex unbalanced tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(20);
        root.right.right.right = new TreeNode(25);

        TreeNode result = balanceBST(root);

        assertTrue(getHeight(result) != -1);
        assertTrue(isValidBST(result, null, null));

        List<Integer> expected = Arrays.asList(1, 2, 5, 10, 15, 20, 25);
        assertEquals(expected, getInorder(result));
    }

    @Test
    void case07() {
        // Tree with duplicate middle scenario
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        root.right.right.right.right = new TreeNode(5);
        root.right.right.right.right.right = new TreeNode(6);

        TreeNode result = balanceBST(root);

        assertTrue(getHeight(result) != -1);
        assertTrue(isValidBST(result, null, null));

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, getInorder(result));

        // For 6 elements, middle should be index 2 or 3 (value 3 or 4)
        assertTrue(result.value == 3 || result.value == 4);
    }

    @Test
    void case08() {
        // Already perfectly balanced tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        TreeNode result = balanceBST(root);

        assertTrue(getHeight(result) != -1);
        assertTrue(isValidBST(result, null, null));

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertEquals(expected, getInorder(result));

        // Root should be 4 (middle element)
        assertEquals(4, result.value);
    }

    @Test
    void case09() {
        // Edge case: Two nodes
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        TreeNode result = balanceBST(root);

        assertTrue(getHeight(result) != -1);
        assertTrue(isValidBST(result, null, null));

        List<Integer> expected = Arrays.asList(1, 2);
        assertEquals(expected, getInorder(result));

        // Either 1 or 2 could be root in a balanced 2-node tree
        assertTrue(result.value == 1 || result.value == 2);
    }

    @Test
    void case10() {
        // Edge case: Null root
        TreeNode root = null;
        TreeNode result = balanceBST(root);
        assertNull(result);
    }

    List<Integer> sortedNodes = new ArrayList<>();
    private TreeNode balanceBST(TreeNode root) {
        inOrder(root);
        return buildBalancedBST(sortedNodes, 0, sortedNodes.size() - 1);
    }
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        sortedNodes.add(node.value);
        inOrder(node.right);
    }

    private TreeNode buildBalancedBST(List<Integer> nodes, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nodes.get(mid));

        node.left = buildBalancedBST(nodes, start, mid - 1);
        node.right = buildBalancedBST(nodes, mid + 1, end);

        return node;
    }
}
